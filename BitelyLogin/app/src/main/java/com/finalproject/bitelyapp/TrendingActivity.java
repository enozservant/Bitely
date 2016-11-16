package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;


public class TrendingActivity extends AppCompatActivity {

    private final String TAG = "TrendingActivity";
    private final String RESTAURANT_CHOSEN = "Restaurant Chosen";


    ArrayList<ListItem> restaurantItemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);


        restaurantItemInfo = new ArrayList<ListItem>();
        callYelp("Los Angeles");

        final ListView listView = (ListView) findViewById(R.id.trending_list);
        listView.setAdapter(new CustomListAdapter(this, restaurantItemInfo));

        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                Toast.makeText(TrendingActivity.this, "Selected :" + " " + position, Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable(RESTAURANT_CHOSEN, restaurantItemInfo.get(position));

                Intent intent = new Intent(TrendingActivity.this, RestaurantInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void initializeListView()
    {
        final ListView listView = (ListView) findViewById(R.id.trending_list);
        listView.setAdapter(new CustomListAdapter(this, restaurantItemInfo));
    }


    private void callYelp(String str){
        final String loc = str;
        Runnable r = new Runnable(){
            @Override
            public void run() {

                try {
                    YelpAPIFactory apiFactory = new YelpAPIFactory("ezGAcfxEnpiWLsbtDvHxhw","3fObU_RY_UyED5bUiixGbHuev6Q",
                            "iXKNIgegrgUNfSPJcFzz59PUt0vjARbn", "zZdQfjNqLrujtGxwD4DJS5IcIxM");
                    YelpAPI yelpAPI = apiFactory.createAPI();

                    Map<String, String> params = new HashMap<>();
                    params.put("term", "food");
                    params.put("limit","10");
                    params.put("sort", "2");

                    Call<SearchResponse> call = yelpAPI.search(loc,  params);
                    SearchResponse response = call.execute().body();

                    ArrayList<Business> businesses = response.businesses();

                    Log.d("YELP", businesses.size() + " responses received.");

                    populateListGUI(businesses);

                } catch (IOException ioe){
                    ioe.printStackTrace();
                }
            }
        };

        Thread yelpThread = new Thread (r);
        yelpThread.start();

       try
       {
            yelpThread.join();
           initializeListView();

        } catch(InterruptedException ie) { Log.d("YELP_THREAD", "Yelp thread interrupted"); }
    }

    private void populateListGUI(ArrayList<Business> businessList){
        for(int i = 0; i < businessList.size(); i++)
        {

            ListItem restaurantItemsList = new ListItem();

            restaurantItemsList.setName(businessList.get(i).name());
            restaurantItemsList.setImageURL(businessList.get(i).imageUrl());
            restaurantItemsList.setComment(businessList.get(i).snippetText());
            restaurantItemsList.setLocation(businessList.get(i).location().displayAddress().get(0));
            restaurantItemsList.setTags(businessList.get(i).categories());
            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setPhoneNumber(businessList.get(i).displayPhone());

            restaurantItemsList.setRatingURL(businessList.get(i).ratingImgUrlLarge());

            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setReviewCount(businessList.get(i).reviewCount());



            restaurantItemInfo.add(restaurantItemsList);
        }
    }
}
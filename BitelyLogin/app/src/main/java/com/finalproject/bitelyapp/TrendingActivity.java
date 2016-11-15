package com.finalproject.bitelyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;

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

    ArrayList<ListItem> restaurantItemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        restaurantItemInfo = new ArrayList<ListItem>();
        callYelp("Los Angeles");

        final ListView listView = (ListView) findViewById(R.id.trending_list);
        listView.setAdapter(new CustomListAdapter(this, restaurantItemInfo));
        /*
        listView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                Toast.makeText(TrendingActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });
    */



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
            Log.i(TAG, businessList.get(i).name());
            Log.i(TAG, businessList.get(i).imageUrl());
            ListItem restaurantItemsList = new ListItem();
            restaurantItemsList.setName(businessList.get(i).name());
            restaurantItemsList.setImageURL(businessList.get(i).imageUrl());

            if(businessList.get(i).reviews() != null && businessList.get(i).reviews().size() > 0)
            {
                restaurantItemsList.setComment(businessList.get(i).reviews().get(0).excerpt());
            }


            restaurantItemsList.setTags(businessList.get(i).categories());
            restaurantItemsList.setStars(businessList.get(i).rating());







            restaurantItemInfo.add(restaurantItemsList);
        }
    }
}
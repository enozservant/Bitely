package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

class Restaurants{
    String restaurantName;

    Restaurants(String name){
        restaurantName = name;
    }

    public String toString(){
        return restaurantName;
    }
}

public class IndividualListActivity extends ListActivity{
    ArrayList<ListItem> myRestaurants;
    public static final String TAG = "IndividualListActivity";
    private Button addRestaurant;
    private String category;
    private TextView ListName;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_a_list);

        Bundle bundle = getIntent().getExtras();
        category = bundle.getString("listName");
        ListName = (TextView) findViewById(R.id.new_list_name);
        ListName.setText(category);

        myRestaurants = new ArrayList<>();
        callYelp("Los Angeles", category);
        initializeListView();



        addRestaurant = (Button) findViewById(R.id.add_restaurant_button);
        addRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SearchActivity.class);
                view.getContext().startActivity(i);
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                // ListItem newsData = (ListItem) listView.getItemAtPosition(position);
//                // Toast.makeText(TrendingActivity.this, "Selected :" + " " + position, Toast.LENGTH_LONG).show();
//                Bundle bundle = new Bundle();
//                bundle.putSerializable(RESTAURANT_CHOSEN,  myRestaurants.get(position));
//
//                Intent intent = new Intent(IndividualListActivity.this, RestaurantInfoActivity.class);
//                intent.putExtras(bundle);
//                startActivity(intent);
//            }
//        });

    }


//    public void AddRestaurant(String name) {
//        myRestaurants.add(new Restaurants(name));
//        mAdapter.notifyDataSetChanged();
//    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, RestaurantInfoActivity_2.class);
        startActivity(i);
    }
    private void initializeListView()
    {
        final ListView listView = (ListView) findViewById(android.R.id.list);
        listView.setAdapter(new CustomListAdapter3(this, myRestaurants));
    }


    private void callYelp(String location, String str){
        final String loc = location;
        final String searchkey = str;
        Runnable r = new Runnable(){
            @Override
            public void run() {

                try {
                    YelpAPIFactory apiFactory = new YelpAPIFactory("ezGAcfxEnpiWLsbtDvHxhw","3fObU_RY_UyED5bUiixGbHuev6Q",
                            "iXKNIgegrgUNfSPJcFzz59PUt0vjARbn", "zZdQfjNqLrujtGxwD4DJS5IcIxM");
                    YelpAPI yelpAPI = apiFactory.createAPI();

                    Map<String, String> params = new HashMap<>();
                    params.put("term", loc);
                    params.put("term", searchkey);
                    params.put("limit","10");

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


            myRestaurants.add(restaurantItemsList);
        }
    }

}




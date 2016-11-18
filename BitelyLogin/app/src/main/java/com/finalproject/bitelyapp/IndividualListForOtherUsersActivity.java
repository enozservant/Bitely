package com.finalproject.bitelyapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

public class IndividualListForOtherUsersActivity extends ListActivity{
//    ArrayList<Restaurants> myRestaurants;
//    ArrayAdapter<Restaurants> mAdapter;
    ArrayAdapter<String> mAdapter;
    private Button addList;
    private TextView numFollowedView;
    private int numberFollows = 4;
    private final String RESTAURANT_CHOSEN = "Restaurant Chosen";
    ArrayList<ListItem> myRestaurants;
    private ListView listView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_a_list_from_other_user);


        Bundle bundle = getIntent().getExtras();
        String category = bundle.getString("search");
        System.out.println(category);

        numFollowedView = (TextView) findViewById(R.id.num_ppl_follow_list);
        numFollowedView.setText(numberFollows + " follows");

        //myRestaurants = new ArrayList<Restaurants>();

//        String[] values = new String[] { "Panda Express", "California Pizza Kitchen", "Seeds",
//                "In-n-out", "Coffee Bean", "Lemonade", "KFC"};
//        mAdapter = new ArrayAdapter<String>(this, R.layout.list_item_gui, R.id.label, values);

//        setListAdapter(mAdapter);

        myRestaurants = new ArrayList<>();
        callYelp("Los Angeles", category);
        initializeListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                // Toast.makeText(TrendingActivity.this, "Selected :" + " " + position, Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable(RESTAURANT_CHOSEN,  myRestaurants.get(position));

                Intent intent = new Intent(IndividualListForOtherUsersActivity.this, RestaurantInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        addList = (Button) findViewById(R.id.add_restaurant_button);
        addList.setTag(0);
        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button addList = (Button) findViewById(R.id.add_restaurant_button);
                addList.setText("");
                final int status = (Integer) view.getTag();
                switch (status) {
                    case 0:
                        addList.setText("Unfollow List");
                        Toast.makeText(getBaseContext(), "Followed", Toast.LENGTH_LONG).show();
                        numberFollows--;
                        numFollowedView.setText(numberFollows + " follows");
                        view.setTag(1); //pause
                        break;
                    case 1:
                        addList.setText("Follow List");
                        numberFollows++;
                        numFollowedView.setText(numberFollows + " follows");
                        Toast.makeText(getBaseContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                        view.setTag(0); //pause
                        break;
                }
            }
        });

    }


//    public void AddRestaurant(String name) {
//        myRestaurants.add(new Restaurants(name));
//        mAdapter.notifyDataSetChanged();
//    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(RESTAURANT_CHOSEN, myRestaurants.get(position));

        Intent intent = new Intent(IndividualListForOtherUsersActivity.this, RestaurantInfoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    private void initializeListView()
    {
        listView = (ListView) findViewById(android.R.id.list);
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
            restaurantItemsList.setPhoneNumber(businessList.get(i).displayPhone());

            restaurantItemsList.setRatingURL(businessList.get(i).ratingImgUrlLarge());

            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setReviewCount(businessList.get(i).reviewCount());
            restaurantItemsList.setBusinessURL(businessList.get(i).url());



            myRestaurants.add(restaurantItemsList);
        }
    }


}

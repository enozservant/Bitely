package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
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

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button Biteme;
    public static final String TAG = "HomeScreen";
    public static final String RESTAURANT_CHOSEN = "Restaurant Chosen";
    ArrayList<ListItem> restaurantItemInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_logged);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        restaurantItemInfo = new ArrayList<>();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


//        restaurantItemInfo.clear();
        callYelp();
        initializeListView();

        Biteme = (Button) findViewById(R.id.biteMe);
        Biteme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("RRR");
                Intent i = new Intent(HomeScreen.this, BiteMeActivity.class);
                startActivity(i);
            }
        });

    }

    private void initializeListView()
    {
        final ListView theRestaurantView = (ListView) findViewById(R.id.discoverList);
        theRestaurantView.setAdapter(new CustomListAdapter2(this, restaurantItemInfo));

        theRestaurantView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                // Toast.makeText(TrendingActivity.this, "Selected :" + " " + position, Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable(RESTAURANT_CHOSEN, restaurantItemInfo.get(position));

                Intent intent = new Intent(HomeScreen.this, RestaurantInfoActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen_logged, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home_screen)
        {
            // Handle the home screen action
//            Log.i(TAG,"I'm Here");
            Intent i = new Intent(this, HomeScreen.class);
            this.startActivity(i);
        } else if (id == R.id.nav_my_list)
        {
            // Handle the my list action
//            Log.i(TAG,"BiteMeActivity in myList");
            Intent i = new Intent(this, MylistActivity.class);
            this.startActivity(i);
        } else if (id == R.id.nav_trending)
        {
            // Handle the trending action
            Intent intent = new Intent(this, TrendingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_friends)
        {
            // Handle the my my friends action
            Intent i = new Intent(this, MyFriendActivity.class);
            this.startActivity(i);
        } else if (id == R.id.nav_browse_screen)
        {
            // Handle the my browse screen action
            Intent i = new Intent(this, SearchActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_user_profile)
        {
            // Handle the nav user profile action
//            Log.i(TAG, "UserProfile");
            Intent i = new Intent(this, ProfileActivity.class);
            this.startActivity(i);
        }
        else if(id == R.id.nav_user_logout)
        {
            startActivity(new Intent(getApplicationContext(), LogoutActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void callYelp(){
        Runnable r = new Runnable(){
            @Override
            public void run() {

                try {
                    YelpAPIFactory apiFactory = new YelpAPIFactory("ezGAcfxEnpiWLsbtDvHxhw","3fObU_RY_UyED5bUiixGbHuev6Q",
                            "iXKNIgegrgUNfSPJcFzz59PUt0vjARbn", "zZdQfjNqLrujtGxwD4DJS5IcIxM");
                    YelpAPI yelpAPI = apiFactory.createAPI();

                    Map<String, String> params = new HashMap<>();
//                    params.put("term", restaurantItemInfo);
                    params.put("term", "restaurants");
                    params.put("price", "$$$$");
                    params.put("limit","15");
                    params.put("sort", "2");

                    Call<SearchResponse> call = yelpAPI.search("Los Angeles",  params);
                    Log.i(TAG,"broken happens here");
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
            Log.i(TAG, businessList.get(i).name());
            Log.i(TAG, businessList.get(i).imageUrl());

            ListItem restaurantItemsList = new ListItem();

            restaurantItemsList.setName(businessList.get(i).name());
            restaurantItemsList.setImageURL(businessList.get(i).imageUrl());
            restaurantItemsList.setComment(businessList.get(i).snippetText());
            restaurantItemsList.setLocation(businessList.get(i).location().displayAddress().get(0));
            restaurantItemsList.setTags(businessList.get(i).categories());
            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setPhoneNumber(businessList.get(i).displayPhone());

            restaurantItemsList.setRatingURL(businessList.get(i).ratingImgUrlLarge());
            restaurantItemsList.setImageURL(businessList.get(i).imageUrl());

            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setReviewCount(businessList.get(i).reviewCount());



            restaurantItemInfo.add(restaurantItemsList);
        }
    }
}

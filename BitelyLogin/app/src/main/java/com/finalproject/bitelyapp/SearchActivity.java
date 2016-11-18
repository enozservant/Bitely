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
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;

public class SearchActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = "SEARCH_ACTIVITY";
    public static final String RESTAURANT_CHOSEN = "Restaurant Chosen";
    ArrayList<ListItem> restaurantItemInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//            // TODO: Consider calling
//            //    ActivityCompat#requestPermissions
//            // here to request the missing permissions, and then overriding
//            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
//            //                                          int[] grantResults)
//            // to handle the case where the user grants the permission. See the documentation
//            // for ActivityCompat#requestPermissions for more details.
//            return;
//        }
//        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//        double longitude = location.getLongitude();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final EditText searchThese = (EditText) findViewById(R.id.editText2);
        searchThese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchThese.setText("");
            }
        });

        restaurantItemInfo = new ArrayList<>();

//        ArrayList<String> search = new ArrayList<>();


        ImageButton searchYelp = (ImageButton) findViewById(R.id.imageButton);
        searchYelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantItemInfo.clear();
                String loc = "";
                loc = searchThese.getText().toString();
                callYelp(loc);
                initializeListView();
            }
        });



//-----------------------------------------------------------------------------------------------
        final RadioButton restaurantButt = (RadioButton) findViewById(R.id.restaurantRadio);
        final RadioButton usersButt = (RadioButton) findViewById(R.id.usersRadio);
        final RadioButton listsButt = (RadioButton) findViewById(R.id.listsRadio);


        restaurantButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usersButt.setChecked(false);
                listsButt.setChecked(false);
                searchThese.setText("Search for Restaurants in LA");
            }
        });
        usersButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantButt.setChecked(false);
                listsButt.setChecked(false);
                searchThese.setText("Search for other Users");
            }
        });
        listsButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restaurantButt.setChecked(false);
                usersButt.setChecked(false);
                searchThese.setText("Search for Lists");
            }
        });
    }

    private void initializeListView()
    {
        final ListView theRestaurantView = (ListView) findViewById(R.id.theList);
        theRestaurantView.setAdapter(new CustomListAdapter2(this, restaurantItemInfo));

        theRestaurantView.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                // ListItem newsData = (ListItem) listView.getItemAtPosition(position);
                // Toast.makeText(TrendingActivity.this, "Selected :" + " " + position, Toast.LENGTH_LONG).show();
                Bundle bundle = new Bundle();
                bundle.putSerializable(RESTAURANT_CHOSEN, restaurantItemInfo.get(position));

                Intent intent = new Intent(SearchActivity.this, RestaurantInfoActivity.class);
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
        getMenuInflater().inflate(R.menu.search, menu);
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
            Log.i(TAG,"I'm Here");
            Intent i = new Intent(this, HomeScreen.class);
            this.startActivity(i);
        } else if (id == R.id.nav_my_list)
        {
            // Handle the my list action
            Log.i(TAG,"BiteMeActivity in myList");
            Intent i = new Intent(this, BiteMeActivity.class);
            this.startActivity(i);
        } else if (id == R.id.nav_trending)
        {
            // Handle the trending action
        } else if (id == R.id.nav_my_friends)
        {
            // Handle the my my friends action
        } else if (id == R.id.nav_browse_screen)
        {
            // Handle the my browse screen action
        } else if (id == R.id.nav_user_profile)
        {
            // Handle the nav user profile action
        }
        else if(id == R.id.nav_user_logout)
        {
            startActivity(new Intent(getApplicationContext(), LogoutActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
                    params.put("term", loc);
//                    params.put("term", "restaurants");
                    params.put("limit","15");
                    params.put("sort", "2");

                    Call<SearchResponse> call = yelpAPI.search("Los Angeles",  params);
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

            restaurantItemsList.setRating(businessList.get(i).rating());
            restaurantItemsList.setReviewCount(businessList.get(i).reviewCount());
            restaurantItemsList.setBusinessURL(businessList.get(i).url());



            restaurantItemInfo.add(restaurantItemsList);
        }
    }
}

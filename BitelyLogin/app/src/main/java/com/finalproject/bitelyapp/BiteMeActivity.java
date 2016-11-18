package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import retrofit2.Call;

public class BiteMeActivity extends AppCompatActivity {

    private final String TAG = "BiteMeActivity";
    private final String RESTAURANT_CHOSEN = "Restaurant Chosen";

    ListItem restaurantItem;
    private ImageView image_view;
    private TextView headlineView;
    private Button Biteme;
    private Button moreInfoButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_bite_me);
        image_view=(ImageView) findViewById(R.id.biteMeRestaurantPic);
        headlineView= (TextView) findViewById(R.id.rname);
        restaurantItem = new ListItem();
        callYelp("Los Angeles");

        Biteme = (Button) findViewById(R.id.biteMeAgain);
        moreInfoButton = (Button) findViewById(R.id.more_info_button);

        moreInfoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(BiteMeActivity.this, RestaurantInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable(RESTAURANT_CHOSEN, restaurantItem);

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

        Biteme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callYelp("Los Angeles");
//                Intent i = new Intent(BiteMeActivity.this, BiteMeActivity.class);
//                startActivity(i);
            }
        });


    }

    private void initializeListView()
    {
        new ImageDownloaderTask(image_view).execute(restaurantItem.getImageURL());
        headlineView.setText(restaurantItem.getName());
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
                    params.put("term", "restaurant");
                    params.put("limit","20");

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
        Random rn = new Random();
        int answer = rn.nextInt(businessList.size());
        Log.i(TAG, businessList.get(answer).name());
        Log.i(TAG, businessList.get(answer).imageUrl());
        restaurantItem.setName(businessList.get(answer).name());
        restaurantItem.setImageURL(businessList.get(answer).imageUrl());
        // restaurantImagesUrl.add(businessList.get(i).imageUrl());
        restaurantItem.setName(businessList.get(answer).name());
        restaurantItem.setImageURL(businessList.get(answer).imageUrl());
        // restaurantImagesUrl.add(businessList.get(i).imageUrl());
        restaurantItem.setName(businessList.get(answer).name());
        restaurantItem.setImageURL(businessList.get(answer).imageUrl());
        restaurantItem.setComment(businessList.get(answer).snippetText());
        restaurantItem.setLocation(businessList.get(answer).location().displayAddress().get(0));
        restaurantItem.setTags(businessList.get(answer).categories());
        restaurantItem.setRating(businessList.get(answer).rating());
        restaurantItem.setPhoneNumber(businessList.get(answer).displayPhone());

        restaurantItem.setRatingURL(businessList.get(answer).ratingImgUrlLarge());

        restaurantItem.setRating(businessList.get(answer).rating());
        restaurantItem.setReviewCount(businessList.get(answer).reviewCount());
    }
}
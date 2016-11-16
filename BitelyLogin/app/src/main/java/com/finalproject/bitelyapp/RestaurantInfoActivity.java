package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantInfoActivity extends AppCompatActivity
{

    private ListItem restaurantItem;

    private final String RESTAURANT_CHOSEN = "Restaurant Chosen";
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView typeTextView;
    private TextView ratingView;
    private ImageView restaurantImage;

    private String displayReviewText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_info);

        // get the restaurant item
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        restaurantItem = (ListItem) bundle.getSerializable(RESTAURANT_CHOSEN);

        // bind the view variables
        nameTextView = (TextView) findViewById(R.id.restaurant_info_name);
        locationTextView = (TextView) findViewById(R.id.restaurant_info_address);
        typeTextView = (TextView) findViewById(R.id.restaurant_info_type);
        ratingView = (TextView) findViewById(R.id.restaurant_info_rating);
        restaurantImage = (ImageView) findViewById(R.id.restaurant_info_image);

        displayReviewText = restaurantItem.getReviewCount() + " people have rated this restaurant";



        // set the values
        nameTextView.setText(restaurantItem.getName());
        locationTextView.setText(restaurantItem.getLocation());
        typeTextView.setText(restaurantItem.getTags());
        ratingView.setText(displayReviewText);
        new ImageDownloaderTask(restaurantImage).execute(restaurantItem.getImageURL());










    }

}

package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class UserInfoActivity extends AppCompatActivity {

    private User chosenUser;

    private final String USER_CHOSEN = "User Chosen";
    private TextView nameTextView;
    private TextView locationTextView;
    private TextView typeTextView;
    private TextView ratingView;
    private ImageView restaurantImage;

    private String displayReviewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        // get the restaurant item
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        chosenUser = (User) bundle.getSerializable(USER_CHOSEN);

        // bind the view variables
        nameTextView = (TextView) findViewById(R.id.person_info_name);
        // locationTextView = (TextView) findViewById(R.id.restaurant_info_address);
        // typeTextView = (TextView) findViewById(R.id.restaurant_info_type);
        // ratingView = (TextView) findViewById(R.id.restaurant_info_rating);
        // restaurantImage = (ImageView) findViewById(R.id.restaurant_info_image);

        // displayReviewText = chosenUser.getReviewCount() + " people have rated this restaurant";


        // set the values
        nameTextView.setText(chosenUser.toString());
        // locationTextView.setText(chosenUser.getLocation());
        // typeTextView.setText(chosenUser.getTags());
        // ratingView.setText(displayReviewText);
        // new ImageDownloaderTask(restaurantImage).execute(restaurantItem.getImageURL());
    }


}

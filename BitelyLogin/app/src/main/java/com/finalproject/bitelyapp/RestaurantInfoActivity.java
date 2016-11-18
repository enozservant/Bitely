package com.finalproject.bitelyapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RestaurantInfoActivity extends AppCompatActivity
{

    private ListItem restaurantItem;

    private Button googleButton;
    private Button yelpButton;
    private Button addToListButton;

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


        googleButton = (Button) findViewById(R.id.google_button);
        yelpButton = (Button) findViewById(R.id.yelp_button);
        addToListButton = (Button) findViewById(R.id.add_to_my_list);

        yelpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // if(restaurantItem.getBusinessURL().equals("")) restaurantItem.setBusinessURL("google.com/");
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(restaurantItem.getBusinessURL()));
                startActivity(browserIntent);
            }
        });

        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(constructGoogleQuery()));
                startActivity(browserIntent);
            }
        });

        addToListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToFirebase();
            }
        });





        // set the values
        nameTextView.setText(restaurantItem.getName());
        locationTextView.setText(restaurantItem.getLocation());
        typeTextView.setText(restaurantItem.getTags());
        ratingView.setText(displayReviewText);
        new ImageDownloaderTask(restaurantImage).execute(restaurantItem.getImageURL());










    }

    private String constructGoogleQuery()
    {
        String baseURL = "https://www.google.com/#q=";
        String restaurantName = restaurantItem.getName();
        String parsedName = restaurantName.replace(' ', '+');

        String query = baseURL += parsedName;
        return query;
    }

    private void addToFirebase()
    {

    }

}

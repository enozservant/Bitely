package com.finalproject.bitelyapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
    private Button callButton;

    private String displayReviewText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);



       callButton = (Button) findViewById(R.id.call_user_button);

        callButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // call the friend
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + chosenUser.getPhoneNumber()));
                /*
                if (ActivityCompat.checkSelfPermission(UserInfoActivity.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                */
                startActivity(callIntent);
            }
        });

        // get the restaurant item
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        chosenUser = (User) bundle.getSerializable(USER_CHOSEN);

        // hardcode the user's phone number to test
        chosenUser.setPhoneNumer("7608518162");

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

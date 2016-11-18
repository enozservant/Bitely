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
    private TextView numFriendsView;
    private TextView numListsView;
    private TextView emailTextView;
    private TextView ratingView;
    private ImageView restaurantImage;
    private Button callButton;

    private String displayReviewText;

    private ImageView profilePicView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);



        callButton = (Button) findViewById(R.id.call_user_button);


        callButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) { call(); }
        });

        // get the restaurant item
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        chosenUser = (User) bundle.getSerializable(USER_CHOSEN);


        // bind the view variables
        nameTextView = (TextView) findViewById(R.id.person_info_name);
        profilePicView = (ImageView) findViewById(R.id.person_info_image);
        numFriendsView = (TextView) findViewById(R.id.person_number_friends);
        numListsView = (TextView) findViewById(R.id.person_number_lists);
        emailTextView = (TextView) findViewById(R.id.person_info_email);



        // set the values
        new ImageDownloaderTask(profilePicView).execute(chosenUser.getImageURL());
        nameTextView.setText(chosenUser.toString());
        numFriendsView.setText(chosenUser.getNumberFriends() + " friend connections");
        numListsView.setText(chosenUser.getNumberLists() + " lists created");
        emailTextView.setText(chosenUser.getEmail());

    }

    private void call()
    {
        // call the friend
        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:" + chosenUser.getPhoneNumber()));


        startActivity(callIntent);

    }
}

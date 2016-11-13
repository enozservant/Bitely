package com.finalproject.bitelyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BiteMeActivity extends AppCompatActivity {
    private static final String TAG = "BiteMeActivity";

    @Bind(R.id.alrightGoing) Button _alrightGoing; //Alright Going Button
    @Bind(R.id.biteMeAgain) Button _biteMeAgain; //Bite Me Again Button
    @Bind(R.id.biteMeRestaurantPic) ImageButton _biteMeRestaurant; //Picture of the Chosen Restaurant, click & direct you to the Restaurant Info Page

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bite_me);
        ButterKnife.bind(this);

        _alrightGoing.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                login();
            }
        });

        _biteMeAgain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });

        _biteMeRestaurant.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Start the Signup activity
                Intent intent = new Intent(getApplicationContext(), SignupActivity.class);
                startActivityForResult(intent, REQUEST_SIGNUP);
                finish();
                overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
            }
        });
    }
}

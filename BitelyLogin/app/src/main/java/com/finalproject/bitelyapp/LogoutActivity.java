package com.finalproject.bitelyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sorencraig on 11/13/16.
 */

public class LogoutActivity  extends AppCompatActivity
{
    private FirebaseUser mUser;
    // a reference to the firebase database
    private FirebaseAuth mFirebaseAuth;

    @Bind(R.id.btn_logout)
    Button _logoutButton;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout);
        ButterKnife.bind(this);

        mFirebaseAuth = FirebaseAuth.getInstance();

        _logoutButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                logout();
            }
        });

    }

    public void logout()
    {
        // if the user is logged in, log them out
        mFirebaseAuth.signOut();
    }


}

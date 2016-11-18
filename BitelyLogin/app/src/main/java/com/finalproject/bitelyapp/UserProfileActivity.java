package com.finalproject.bitelyapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class UserProfileActivity extends AppCompatActivity
{
    // a reference to the firebase database
    private FirebaseAuth mFirebaseAuth;
    // a reference to the database
    private FirebaseDatabase mFirebaseDatabase;
    // a firebase auth listener
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mDatabaseRef;
    private FirebaseUser currentUser;
    private DatabaseReference mDatabase;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private TextView userNameText;
    private TextView emailText;
    private TextView phoneNumberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_profile);

        userNameText = (TextView) findViewById(R.id.user_name_field);
        emailText = (TextView) findViewById(R.id.user_profile_email);
        phoneNumberText = (TextView) findViewById(R.id.user_profile_phone);
        userNameText.setEnabled(true);
        firstName = "";
        lastName = "";
        email = "";
        phoneNumber = "";

        mDatabaseRef = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        currentUser = mFirebaseAuth.getCurrentUser();


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String currUID = currentUser.getUid();
                for(DataSnapshot d : dataSnapshot.getChildren())
                {
                    boolean correctUser = false;
                    System.out.println("Above: " + d.getKey());
                    if(d.getKey().equals(currUID))
                    {
                        correctUser = true;
                    }
                    else
                    {
                        correctUser = false;
                    }
                    HashMap<String,String> user_map= (HashMap<String,String>)d.getValue();
                    for (HashMap.Entry<String, String> innerEntry : user_map.entrySet()) {
                        String key = innerEntry.getKey();
                        Object value = innerEntry.getValue();

                        if(key.equals("firstName") && correctUser)
                        {
                            System.out.println("IN FIRST NAME");
                            firstName = (String)value;
                            setUserName();
                        }
                        if(key.equals("lastName") && correctUser)
                        {
                            System.out.println("IN FIRST NAME");
                            lastName = (String)value;
                            setUserName();
                        }
                        if(key.equals("phoneNumber") && correctUser)
                        {
                            phoneNumber = (String) value;
                            setPhoneNumber();
                        }
                        System.out.println("innerkey: " + key + "// innervalue: " + value);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    private void setUserName()
    {
        if(!firstName.equals("") && !lastName.equals(""))
        {
            userNameText.setText(firstName + " " + lastName);
            setEmail();
        }
    }

    private void setEmail()
    {
        // get the current email of the current logged in user
        if(currentUser != null)
        {
            emailText.setText(currentUser.getEmail());
        }
    }

    private void setPhoneNumber()
    {
        if(!phoneNumber.equals(""))
        {
            phoneNumberText.setText(phoneNumber);
        }
    }
}

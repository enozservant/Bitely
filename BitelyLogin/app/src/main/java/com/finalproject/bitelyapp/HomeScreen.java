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
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class HomeScreen extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private Button Biteme;

    public static final String TAG = "HomeScreen";

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen_logged);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firstName = "";
        lastName = "";

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
                        System.out.println("innerkey: " + key + "// innervalue: " + value);
                        // System.out.println("Children" + user);
                        // System.out.println("Value" + (String)d.getValue());
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // NavigationView navigationView = (NavigationView) findViewById(nav_view);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        Biteme = (Button) findViewById(R.id.biteMe);

        Biteme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("RRR");
                Intent i = new Intent(HomeScreen.this, BiteMeActivity.class);
                startActivity(i);
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
        getMenuInflater().inflate(R.menu.main_screen_logged, menu);
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
            Intent i = new Intent(this, MylistActivity.class);
            this.startActivity(i);
        } else if (id == R.id.nav_trending)
        {
            // Handle the trending action
            Intent intent = new Intent(this, TrendingActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_my_friends)
        {
            // Handle the my my friends action
            Intent i = new Intent(this, MyFriendActivity.class);
            this.startActivity(i);
        } else if (id == R.id.nav_browse_screen)
        {
            // Handle the my browse screen action
            Intent i = new Intent(this, SearchActivity.class);
            startActivity(i);
        } else if (id == R.id.nav_user_profile)
        {
            // Handle the nav user profile action
            Log.i(TAG, "UserProfile");
            Intent i = new Intent(this, ProfileActivity.class);
            this.startActivity(i);
        }
        else if(id == R.id.nav_user_logout)
        {
            startActivity(new Intent(getApplicationContext(), LogoutActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUserName()
    {
        if(!firstName.equals("") && !lastName.equals(""))
        {
            // set some text!
        }
    }
}

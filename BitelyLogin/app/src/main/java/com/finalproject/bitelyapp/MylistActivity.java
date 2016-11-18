package com.finalproject.bitelyapp;

/**
 * Created by ElenaHe on 11/12/16.
 */


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

class Contact{
    String nume;
    String prenume;

    Contact(String nume, String prenume){
        this.nume=nume;
        this.prenume=prenume;
    }

    public String toString(){
        return prenume +" "+ nume;
    }
}

public class MylistActivity extends ListActivity {
    ArrayList<String> lista;
    ArrayAdapter <String> adaptor;
    private ArrayList<String> restaurantNames;
    private ImageButton addList;
    // a reference to the firebase database
    private FirebaseAuth mFirebaseAuth;
    // a reference to the database
    private FirebaseDatabase mFirebaseDatabase;
    // a firebase auth listener
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseDatabase mDatabaseRef;
    private FirebaseUser currentUser;
    private DatabaseReference mDatabase;

    private HashMap<String, String> dataMap;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);
        restaurantNames = new ArrayList<String>();
        mDatabaseRef = FirebaseDatabase.getInstance();
        mFirebaseAuth = FirebaseAuth.getInstance();
        currentUser = mFirebaseAuth.getCurrentUser();


        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Lists").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String currUID = currentUser.getUid();
                for(DataSnapshot d : dataSnapshot.getChildren())
                {

                    System.out.println("Above: " + d.getKey());


                    HashMap<String,String> user_map= (HashMap<String,String>)d.getValue();
                    for (HashMap.Entry<String, String> innerEntry : user_map.entrySet())
                    {
                        String key = innerEntry.getKey();
                        Object value = innerEntry.getValue();

                        if(key.equals("restaurants"))
                        {
                            System.out.println("IN RESTAURANTS");
                            dataMap = (HashMap<String, String>) value;
                           for(String str : dataMap.keySet())
                           {
                               System.out.println("Got KEY: " + str);
                               addRestaurantName(str);
                           }

                        }
                        System.out.println("innerkey: " + key + "// innervalue: " + value);
                    }

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry" };
        // use your custom layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.list_item_gui, R.id.label, values);
        setListAdapter(adapter);
        addList = (ImageButton) findViewById(R.id.addButton);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("RRR");
                Intent i = new Intent(MylistActivity.this,CreateListActivity.class);
                startActivity(i);
            }
        });
    }

    private void addRestaurantName(String name)
    {
        restaurantNames.add(name);
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, IndividualListActivity.class);
        startActivity(i);
    }


}
package com.finalproject.bitelyapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class IndividualListForOtherUsersActivity extends ListActivity{
    ArrayList<Restaurants> myRestaurants;
    ArrayAdapter<Restaurants> mAdapter;
    private Button addList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_a_list_from_other_user);

        myRestaurants = new ArrayList<Restaurants>();

        mAdapter = new ArrayAdapter<Restaurants>(this, R.layout.list_item, myRestaurants);

        AddRestaurant("Panda Express");
        AddRestaurant("California Pizza Kitchen");
        AddRestaurant("Seeds");
        AddRestaurant("In-n-out");
        AddRestaurant("Coffee Bean");
        AddRestaurant("Lemonade");
        AddRestaurant("KFC");
        AddRestaurant("Triple 8");
        AddRestaurant("StarBucks");

        setListAdapter(mAdapter);

        addList = (Button) findViewById(R.id.add_restaurant_button);

    }


    public void AddRestaurant(String name) {
        myRestaurants.add(new Restaurants(name));
        mAdapter.notifyDataSetChanged();
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, RestaurantInfoActivity_2.class);
        startActivity(i);
    }
}

package com.finalproject.bitelyapp;


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class IndividualListForOtherUsersActivity extends ListActivity{
//    ArrayList<Restaurants> myRestaurants;
//    ArrayAdapter<Restaurants> mAdapter;
    ArrayAdapter<String> mAdapter;
    private Button addList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_a_list_from_other_user);

        //myRestaurants = new ArrayList<Restaurants>();

        String[] values = new String[] { "Panda Express", "California Pizza Kitchen", "Seeds",
                "In-n-out", "Coffee Bean", "Lemonade", "KFC"};
        mAdapter = new ArrayAdapter<String>(this, R.layout.list_item_gui, R.id.label, values);

//        AddRestaurant("Panda Express");
//        AddRestaurant("California Pizza Kitchen");
//        AddRestaurant("Seeds");
//        AddRestaurant("In-n-out");
//        AddRestaurant("Coffee Bean");
//        AddRestaurant("Lemonade");
//        AddRestaurant("KFC");
//        AddRestaurant("Triple 8");
//        AddRestaurant("StarBucks");

        setListAdapter(mAdapter);

        addList = (Button) findViewById(R.id.add_restaurant_button);
        addList.setTag(0);
        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button addList = (Button) findViewById(R.id.add_restaurant_button);
                addList.setText("");
                final int status = (Integer) view.getTag();
                switch (status) {
                    case 0:
                        addList.setText("Unfollow List");
                        Toast.makeText(getBaseContext(), "Followed", Toast.LENGTH_LONG).show();
                        view.setTag(1); //pause
                        break;
                    case 1:
                        addList.setText("Follow List");
                        Toast.makeText(getBaseContext(), "Unfollowed", Toast.LENGTH_LONG).show();
                        view.setTag(0); //pause
                        break;
                }
            }
        });

    }


//    public void AddRestaurant(String name) {
//        myRestaurants.add(new Restaurants(name));
//        mAdapter.notifyDataSetChanged();
//    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, RestaurantInfoActivity_2.class);
        startActivity(i);
    }
}

package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

class Restaurants{
    String restaurantName;

    Restaurants(String name){
        restaurantName = name;
    }

    public String toString(){
        return restaurantName;
    }
}

public class IndividualListActivity extends ListActivity{
//    ArrayList<Restaurants> myRestaurants;
//    ArrayAdapter<Restaurants> mAdapter;
    //ArrayList<String> myRestaurants;
    ArrayAdapter<String> mAdapter;
    private Button addRestaurant;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_a_list);

//        myRestaurants = new ArrayList<Restaurants>();
        //myRestaurants = new ArrayList<String>();

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

        addRestaurant = (Button) findViewById(R.id.add_restaurant_button);
        addRestaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), SearchActivity.class);
                view.getContext().startActivity(i);
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

    private void getFirebaseLists()
    {

    }
}


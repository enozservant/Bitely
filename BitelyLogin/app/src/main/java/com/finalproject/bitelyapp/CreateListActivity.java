package com.finalproject.bitelyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CreateListActivity extends AppCompatActivity{
    private ImageButton add_Restaurant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_list);

        add_Restaurant = (ImageButton) findViewById(R.id.add_restuarant_button);
        add_Restaurant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (view.getContext(), SearchActivity.class);
                view.getContext().startActivity(i);
            }
        });
    }

}

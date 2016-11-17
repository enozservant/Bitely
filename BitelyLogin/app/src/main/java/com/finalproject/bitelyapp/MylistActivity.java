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

import java.util.ArrayList;

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
    private ImageButton addList;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
                "Blackberry" };
        // use your custom layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.friend_item, R.id.label, values);
        setListAdapter(adapter);
        addList = (ImageButton) findViewById(R.id.addButton);

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.print("RRR");
                Intent i = new Intent(MylistActivity.this,RestaurantInfoActivity.class);
                startActivity(i);
            }
        });
    }

    public void adaugaContact(String prenume) {
        lista.add(prenume);
        adaptor.notifyDataSetChanged();
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, IndividualListActivity.class);
        startActivity(i);
    }


}
package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.finalproject.bitelyapp.R.layout.my_list;

class U{
    String nume;
    String prenume;

    U(String nume, String prenume){
        this.nume=nume;
        this.prenume=prenume;
    }

    public String toString(){
        return prenume +" "+ nume;
    }
}

public class MyFriendActivity extends ListActivity {
    ArrayList<U> lista;
    ArrayAdapter<U> adaptor;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(my_list);

        lista = new ArrayList<U>();

        adaptor = new ArrayAdapter<U>(this, R.layout.list_item, lista);
        adaugaContact("Florian", "Iancu");
        adaugaContact("he", "jjjja");

        setListAdapter(adaptor);
    }

    public void adaugaContact(String nume, String prenume) {
        lista.add(new U(nume, prenume));
        adaptor.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, MylistActivity.class);
        startActivity(i);
    }
}
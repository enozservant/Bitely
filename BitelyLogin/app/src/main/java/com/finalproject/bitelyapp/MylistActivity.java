package com.finalproject.bitelyapp;

/**
 * Created by ElenaHe on 11/12/16.
 */


import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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
    ArrayList<Contact> lista;
    ArrayAdapter <Contact> adaptor;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        lista = new ArrayList<Contact>();


        adaptor = new ArrayAdapter<Contact>(this,R.layout.list_item, lista);
        adaugaContact("Florian", "Iancu");
        adaugaContact("Ioana", "Constantina");

        setListAdapter(adaptor);
    }

    public void adaugaContact(String nume, String prenume) {
        lista.add(new Contact(nume, prenume));
        adaptor.notifyDataSetChanged();
    }

    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent i = new Intent(this, MylistActivity.class);
        startActivity(i);
    }
}
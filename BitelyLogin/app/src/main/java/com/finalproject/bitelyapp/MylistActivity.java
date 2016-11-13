package com.finalproject.bitelyapp;

/**
 * Created by ElenaHe on 11/12/16.
 */


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

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

        //Intent intent = getIntent();

        lista = new ArrayList<Contact>();
        adaugaContact("Florian", "Iancu");
        adaugaContact("Ioana", "Constantina");

        adaptor = new ArrayAdapter<Contact>(this,R.layout.list_item, lista);

        setListAdapter(adaptor);
    }

    public void adaugaContact(String nume, String prenume) {
        lista.add(new Contact(nume, prenume));
        adaptor.notifyDataSetChanged();
    }
}
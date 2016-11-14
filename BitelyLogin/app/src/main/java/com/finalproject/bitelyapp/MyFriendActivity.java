package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

class User{
    String nume;
    String prenume;

    User(String nume, String prenume){
        this.nume=nume;
        this.prenume=prenume;
    }

    public String toString(){
        return prenume +" "+ nume;
    }
}

public class MyFriendActivity extends ListActivity {
    ArrayList<User> lista;
    ArrayAdapter<User> adaptor;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_list);

        lista = new ArrayList<User>();

        adaptor = new ArrayAdapter<User>(this,R.layout.list_item, lista);
        adaugaContact("Florian", "Iancu");
        adaugaContact("Ioana", "Constantina");

        setListAdapter(adaptor);
    }

    public void adaugaContact(String nume, String prenume) {
        lista.add(new User(nume, prenume));
        adaptor.notifyDataSetChanged();
    }
}
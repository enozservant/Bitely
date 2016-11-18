package com.finalproject.bitelyapp;

import java.util.ArrayList;

/**
 * Created by ElenaHe on 11/18/16.
 */

public class individualUser{
    int howManylists;
    ArrayList<String> listsName = new ArrayList<>();

    public void setHowManylists(int h){
        howManylists = h;
    }

    public void addlists(String s){
        listsName.add(s);
    }

    public int getHowmanylists(){
        return howManylists;
    }

    public String listnameatindex(int i ){
        return listsName.get(i);
    }
}

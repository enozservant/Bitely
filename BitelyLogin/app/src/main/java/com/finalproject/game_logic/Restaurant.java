package com.finalproject.game_logic;

import java.util.*;

/**
 * Created by williamxu on 12/11/2016.
 */

public class Restaurant {

    private List<String> tags;
    private String loc;
    private double rating;

    public Restaurant(){
        /*
        TODO: get tags of the restaurant from yelp call
        TODO: get location information from yelp call
        TODO: get rating information from yelp call
         */
        tags = new ArrayList<String>();
    }

    public List<String> getTags(){
        return tags;
    }

    public double getRating(){
        return rating;
    }

}

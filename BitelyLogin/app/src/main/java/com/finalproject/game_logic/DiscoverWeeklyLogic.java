package com.finalproject.game_logic;

import java.util.*;


//takes care of logic for discover weekly

public class DiscoverWeeklyLogic  {

    public List<Restaurant> generateDiscovery(User user){
        List<Restaurant> discoverWeeklyList = new ArrayList<Restaurant>();
        return user.getSurroundingRestaurants();

    }
}

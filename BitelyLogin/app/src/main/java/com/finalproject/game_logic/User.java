package com.finalproject.game_logic;


import java.util.*;

/**
 * Created by williamxu on 12/11/2016.
 */

public class User {

    private List<User> friends;
    private List<Restaurant> restaurants;
    private List<CustomList> myLists;
    private List<CustomList> myFollowedLists;

    private UserProfileLogic profile;



    public User(){
        friends = new ArrayList<User>();
        restaurants = new ArrayList<Restaurant>();
        myLists = new ArrayList<CustomList>();
        profile = new UserProfileLogic();
        myFollowedLists = new ArrayList<CustomList>();
    }

    public void saveRestaurant(Restaurant r){
        restaurants.add(r);
        List<String> tags = r.getTags();
        for (String tag : tags){
            profile.addTag(tag);
        }
    }

    public void followList(CustomList list){
        myFollowedLists.add(list);

        //adding tags
        List<Restaurant> temp = list.getRestaurants();
        for (Restaurant r : temp ){
            List<String> tags = r.getTags();
            for (String tag : tags){
                profile.addTag(tag);
            }
        }
    }

    public UserProfileLogic getProfile(){
        return profile;
    }

    public Set<Restaurant> getSurroundingRestaurants(){

        //TODO: get surrounding restaurants based on user location

        Set<Restaurant> retval = new HashSet<>();
        for (Restaurant r : restaurants){
            retval.add(r);
        }
        return retval;
    }

    public void addToList(Restaurant toAdd, CustomList toList){
        toList.addRestaurant(toAdd);
        restaurants.add(toAdd);
    }

    public void removeFromList(Restaurant toRemove, CustomList fromList){
        fromList.removeRestaurant(toRemove);
        restaurants.remove(toRemove);
    }

    public List<Restaurant> generateDiscoverWeekly(){
        DiscoverWeeklyLogic dl = new DiscoverWeeklyLogic();
        return dl.generateDiscovery(this);
    }




}

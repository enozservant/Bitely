package com.finalproject.game_logic;
import java.util.*;
/**
 * Created by williamxu on 12/11/2016.
 */

public class CustomList {
    private User creator;
    private List<User> followers;
    private List<Restaurant> content;

    public CustomList(User user){
        this.creator = user;
        content = new ArrayList<Restaurant>();
        followers = new ArrayList<User>();
    }

    public List<Restaurant> getRestaurants(){
        return content;
    }

    public List<User> getFollowers(){
        return followers;
    }

    public User getOwner(){
        return creator;
    }

    public void addRestaurant(Restaurant r){
        content.add(r);
    }

    public void removeRestaurant(Restaurant r){
        content.remove(r);
    }
}

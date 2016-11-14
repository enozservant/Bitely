package com.finalproject.bitelyapp;

import java.util.ArrayList;

/**
 * Created by sorencraig on 11/13/16.
 *
 * Fully encapsulated class representing the user information
 */

public class User {

    private String UID;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    // private boolean isLoggedIn

    private ArrayList<User> friendList;
    private ArrayList<User> restaurantList;
    private ArrayList<User> listOfOwnedList;
    private ArrayList<User> listOfFollowedList;

    // what array lists are going to be here

    public User()
    {
        // initialize arrayLists of lists they follow etc
        friendList = new ArrayList<User>();
        // listOfOwnedList = new ArrayList<List>();
        // listOfFollowedList = new ArrayList<List>();

    }

    /*
     * Accessor methods for class variables
     */

    public void setUID(String UID)
    {
        this.UID = UID;
    }

    public void addFriend(User friend)
    {
        friendList.add(friend);
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public void setPhoneNumer(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    /*
     * Getter methods for class variables
     */


    public String getUID()
    {
        return this.UID;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getPhoneNumber()
    {
        return this.phoneNumber;
    }

    public ArrayList<User> getFriends()
    {
        return this.friendList;
    }
}

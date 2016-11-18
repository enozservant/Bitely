package com.finalproject.bitelyapp;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by sorencraig on 11/13/16.
 *
 * Fully encapsulated class representing the user information
 */

public class User implements Serializable
{
    public static final long serialVersionUID = 79382748l;

    private String UID;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String imageURL;
    private String email;

    private int numberFriends;
    private int numberLists;

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
        UID = "";
        firstName = "";
        lastName = "";
        phoneNumber = "";
        imageURL = "";
        numberFriends = 0;
        numberLists = 0;
        email = "";

    }

    /*
     * Accessor methods for class variables
     */

    public void setEmail(String email)
    {
        this.email = email;
    }
    public String toString()
    {
        return this.firstName + " " + this.lastName;
    }

    public void setNumberLists(int numberLists)
    {
        this.numberLists = numberLists;
    }

    public void addList()
    {
        this.numberLists++;
    }

    public void setNumberFriends(int numberFriends)
    {
        this.numberFriends = numberFriends;
    }
    public void addFriend()
    {
        this.numberFriends++;
    }

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

    public void setImageURL(String imageURL) { this.imageURL = imageURL; }

    /*
     * Getter methods for class variables
     */


    public String getImageURL() { return this.imageURL; }

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

    public int getNumberFriends()
    {
        return this.numberFriends;
    }

    public int getNumberLists()
    {
        return this.numberLists;
    }

    public String getEmail()
    {
        return this.email;
    }
}

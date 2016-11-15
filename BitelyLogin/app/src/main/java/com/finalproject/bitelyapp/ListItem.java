package com.finalproject.bitelyapp;

/**
 * Created by sorencraig on 11/14/16.
 */

public class ListItem
{
    /*
     * This will be restaurant specific-info like tags, rating, price
     */

    private String imageURL;
    private String name;


    public void setName(String name)
    {
        this.name = name;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }

    public String getName()
    {
        return this.name;
    }

    public String getImageURL()
    {
        return imageURL;
    }
}

package com.finalproject.bitelyapp;

import com.yelp.clientlib.entities.Category;

import java.util.ArrayList;

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
    private String comment;
    private Double stars;
    private String location;
    private String tags;

    public ListItem()
    {
        imageURL = "";
        name = "";
        comment = "";
        stars = 0.0;
        location = "";
        tags = "";
    }


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

    public String getComment()
    {
        return this.comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public Double getStars()
    {
        return this.stars;
    }

    public void setStars(Double stars)
    {
        this.stars = stars;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }

    public String getLocation()
    {
        return this.location;
    }

    public void setTags(ArrayList<Category> tagsStrings)
    {
        int min = 0;
        if(tagsStrings.size() > 3 )
        {
            min = 3;
        }
        else
        {
            min = tagsStrings.size();
        }
        for(int i = 0; i < min; i++)
        {
            if(i < min - 1)
            {
                tags += tagsStrings.get(i).name() + ", ";
            }
            else
            {
                tags += tagsStrings.get(i).name();
            }
        }
    }

    public String getTags()
    {
        return this.tags;
    }
}

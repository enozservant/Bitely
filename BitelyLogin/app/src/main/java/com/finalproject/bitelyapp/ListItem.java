package com.finalproject.bitelyapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import com.yelp.clientlib.entities.Category;

import java.io.File;
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
    private String snippet;

    private Bitmap starsBitmap;

    public ListItem()
    {
        imageURL = "";
        name = "";
        comment = "";
        stars = 0.0;
        location = "";
        tags = "";
        // starsBitmap = null;
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
        setStarsBitmap(stars);
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

    public void setSnippet(String snippet)
    {
        this.snippet = snippet;
    }

    public String getSnippet()
    {
        return this.snippet;
    }

    public void setStarsBitmap(Double stars)
    {
        String fileName = "";
        // decide what file
        if(stars == 0)
        {
            fileName = "drawable/rating_0_star.png";
        }
        else if(stars == 0.5 || stars == 1.0)
        {
            fileName = "drawable/rating_1_star.png";
        }
        else if( stars == 1.5)
        {
            fileName = "drawable/rating_15_star.png";
        }
        else if(stars == 2.0)
        {
            fileName = "drawable/rating_2_star.png";
        }
        else if(stars == 2.5)
        {
            fileName = "drawable/rating_25_star.png";
        }
        else if(stars == 3.0)
        {
            fileName = "drawable/rating_3_star.png";
        }
        else if(stars == 3.5)
        {
            fileName = "drawable/rating_35_star.png";
        }
        else if(stars == 4.0)
        {
            fileName = "res/drawable/rating_4_star.png";
        }
        else if(stars == 4.5)
        {
            fileName = "res/drawable/rating_45_star.png";
        }
        else if(stars == 5.0)
        {
            fileName = "rating_5_star.png";
        }
        else
        {
            fileName = "res/drawable/rating_3_star.png";

        }

        try
        {
            starsBitmap = BitmapFactory.decodeFile(fileName);
        }

        catch (OutOfMemoryError e) {
            Log.d("IMAGE", "FILE IS TOOOOO BIG");
        }
        File currentDir = new File("");
        String filePath = currentDir.getPath();
        Log.d("FILE_PATH", filePath);
    }

    public Bitmap getStarsBitmap()
    {
        return this.starsBitmap;
    }
}

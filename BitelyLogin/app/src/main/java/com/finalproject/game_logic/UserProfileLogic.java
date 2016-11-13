package com.finalproject.game_logic;

import java.util.*;

/**
 * Created by williamxu on 12/11/2016.
 */

public class UserProfileLogic {

    private List<TagCountPair> tags;
    
    public UserProfileLogic(){
        tags = new ArrayList<TagCountPair>();
    }

    public void addTag(String tag){
        for (TagCountPair tcp : tags){
            if (tcp.equals(tag)){
                tcp.increment();
                return;
            }
        }
        tags.add(new TagCountPair(tag));
    }

    public int getWeight(String tag){
        for (TagCountPair tcp : tags) {
            if (tcp.equals(tag)) {
                return tcp.getVal();
            }
        }
        return 0;
    }

    private class TagCountPair{
        private String tag;
        private int count;

        TagCountPair(String tag){
            this.tag = tag;
            this.count = 1;
        }

        boolean equals(String tag){
            return (this.tag == tag);
        }

        void increment(){
            count++;
        }

        int getVal(){
            return count;
        }
    }
    
}

package com.finalproject.bitelyapp;

import java.util.ArrayList;

/**
 * Created by ElenaHe on 11/17/16.
 * */


public class FriendandTheirList {
    public ArrayList<individualUser> individualUsers;

    public FriendandTheirList() {

        individualUsers=new ArrayList<>();

        individualUser steve = new individualUser();
        steve.setHowManylists(3);
        steve.addlists("Korean");
        steve.addlists("Sea Food");
        steve.addlists("American");

        individualUser Bob = new individualUser();
        Bob.setHowManylists(2);
        Bob.addlists("Take out");
        Bob.addlists("Branch");

        individualUser Jeff = new individualUser();
        Jeff.setHowManylists(5);
        Jeff.addlists("Japanese");
        Jeff.addlists("Tea");
        Jeff.addlists("Sushi");
        Jeff.addlists("Michelin");
        Jeff.addlists("Ramen");

        individualUsers.add(steve);
        individualUsers.add(Bob);
        individualUsers.add(Jeff);

    }

}

package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

import static com.finalproject.bitelyapp.R.layout.my_list;

class UserName{

    String firstName;
    String lastName;

    UserName(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString(){
        return firstName +" "+ lastName;
    }
}

public class MyFriendActivity extends ListActivity
{
    private final String USER_CHOSEN = "User Chosen";

    private ArrayList<User> userList;
    private ArrayAdapter<User> adapter;
    private ImageButton add_Friend;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_friend);

        userList = new ArrayList<User>();

        adapter = new ArrayAdapter<User>(this, R.layout.list_item, userList);


        // create dummy users
        User userOne = new User();
        userOne.setFirstName("Steve");
        userOne.setLastName("Jobs");
        userOne.setPhoneNumer("7608518162");
        userOne.setEmail("stevejobs@apple.com");
        userOne.setImageURL("http://www.adweek.com/agencyspy/wp-content/uploads/sites/7/2015/06/steve-jobs.jpg");
        userOne.setNumberLists(2);
        userOne.setNumberFriends(4);


        User userTwo = new User();
        userTwo.setFirstName("Bob");
        userTwo.setLastName("Dylan");
        userOne.setPhoneNumer("7608518162");
        userTwo.setEmail("bobdylan@music.com");
        userTwo.setImageURL("http://www.mojo4music.com/media/2014/02/Dylan-770.jpg");
        userTwo.setNumberLists(4);
        userTwo.setNumberFriends(3);

        // Jeffrey Miller
        User millerUser = new User();
        millerUser.setFirstName("Dr. Jeffrey");
        millerUser.setLastName("Miller");
        millerUser.setPhoneNumer("2137407129");
        millerUser.setEmail("jeffrey.miller@usc.edu");
        millerUser.setImageURL("https://pressroom.usc.edu/files/2015/01/JeffreyMiller-cropped.jpg");
        millerUser.setNumberLists(5);
        millerUser.setNumberFriends(4);

        // add the users to the list view
        addAContact(userOne);
        addAContact(userTwo);
        addAContact(millerUser);

        setListAdapter(adapter);

        add_Friend = (ImageButton) findViewById(R.id.add_friend_button);
        add_Friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), SearchActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }

    public void addAContact(User user)
    {
        userList.add(user);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Intent intent = new Intent(this, IndividualUserActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_CHOSEN, userList.get(position));
        intent.putExtras(bundle);
        intent.putExtra("position", position);
        startActivity(intent);
        // Intent i = new Intent(this, IndividualUserActivity.class);
        // startActivity(i);
    }
}
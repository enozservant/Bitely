package com.finalproject.bitelyapp;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
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

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(my_list);

        userList = new ArrayList<User>();

        adapter = new ArrayAdapter<User>(this, R.layout.list_item, userList);


        // create dummy users
        User userOne = new User();
        userOne.setFirstName("Soren");
        userOne.setLastName("Craig");

        User userTwo = new User();
        userTwo.setFirstName("Bob");
        userTwo.setLastName("Dylan");

        addAContact(userOne);
        addAContact(userTwo);

        setListAdapter(adapter);
    }

    public void addAContact(User user)
    {
        userList.add(user);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
//        Intent intent = new Intent(this, UserInfoActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putSerializable(USER_CHOSEN, userList.get(position));
//        intent.putExtras(bundle);
//        startActivity(intent);
        Intent i = new Intent(this, IndividualUserActivity.class);
        startActivity(i);
    }
}
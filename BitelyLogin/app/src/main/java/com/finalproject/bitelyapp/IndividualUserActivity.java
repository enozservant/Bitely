package com.finalproject.bitelyapp;


import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<String> list = new ArrayList<String>();
    private Context context;
    private int p;


    public MyCustomAdapter(ArrayList<String> list, Context context, int p) {
        this.list = list;
        this.context = context;
        this.p=p;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
//        Object x = list.get(pos);
//        return x.getId();//list.get(pos).getId();
        //just return 0 if your list items do not have an Id variable.
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item_2, null);
        }
            //Handle TextView and display string from your list
            TextView listItemText = (TextView) view.findViewById(R.id.list_item_string);
            listItemText.setText(list.get(position));
            //listItemText.toString();

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    FriendandTheirList fat = new FriendandTheirList();
                    individualUser iu= fat.individualUsers.get(p);
                    String searchkey=iu.listnameatindex(position);
                    Intent i = new Intent(v.getContext(), IndividualListForOtherUsersActivity.class);
                    i.putExtra("search", searchkey);
                    v.getContext().startActivity(i);
                    notifyDataSetChanged();
                }
            });

            //Handle buttons and add onClickListeners
            Button addBtn = (Button) view.findViewById(R.id.add_btn);
            addBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //do something
                    new AlertDialog.Builder(context)
                            .setTitle("Add List")
                            .setMessage("Are you sure you want to add this list to my list?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener(){
                                public void onClick(DialogInterface dialog, int which) {
                                    // continue with delete
                                }
                            })
                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    // do nothing
                                }
                            })
                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                    notifyDataSetChanged();
                }
            });

            return view;
        }
}


public class IndividualUserActivity extends ListActivity{
    private ArrayList<String> list;
    private MyCustomAdapter adapter;
    private ImageView userPic;
    private final String USER_CHOSEN = "User Chosen";
    private User userChosen;
    private FriendandTheirList fat;
    private individualUser iu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_when_press_an_user);

        // get the restaurant item
        Intent intent = this.getIntent();
        Bundle bundle = intent.getExtras();
        int position = bundle.getInt("position");
        userChosen = (User) bundle.getSerializable(USER_CHOSEN);

        userPic = (ImageView) findViewById(R.id.user_pic);
        if(userPic != null)
        {
            new ImageDownloaderTask(userPic).execute(userChosen.getImageURL());
        }

        //generate list
        list = new ArrayList<String>();
        fat = new FriendandTheirList();
        iu= fat.individualUsers.get(position);
        for(int i=0; i<iu.getHowmanylists();i++){
            System.out.println(iu.listnameatindex(i));
            list.add(iu.listnameatindex(i));
        }

        //instantiate custom adapter
        adapter = new MyCustomAdapter(list, this,position);

        setListAdapter(adapter);

        //userPic Clickable
        userPic = (ImageView) findViewById(R.id.user_pic);
        userPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeToUserInfoPage();
            }
        });
    }

    private void changeToUserInfoPage()
    {
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_CHOSEN, userChosen);

        Intent intent = new Intent(IndividualUserActivity.this, UserInfoActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}

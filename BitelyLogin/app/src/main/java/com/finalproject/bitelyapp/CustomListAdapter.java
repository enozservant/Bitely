package com.finalproject.bitelyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by sorencraig on 11/14/16.
 */

public class CustomListAdapter extends BaseAdapter
{
    private ArrayList listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return listData.size();
    }

    public Object getItem(int position) {
        return listData.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            // convertView = layoutInflater.inflate(R.layout.trending_list_item_layout, null);
            convertView = layoutInflater.inflate(R.layout.trending_item, null);
            holder = new ViewHolder();
            holder.nameView = (TextView) convertView.findViewById(R.id.title);
            holder.commentView = (TextView) convertView.findViewById(R.id.restaurant_comment);
            holder.locationView = (TextView) convertView.findViewById(R.id.restaurant_location);
            holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ListItem newsItem = (ListItem) listData.get(position);
        holder.nameView.setText(newsItem.getName());
        holder.commentView.setText(newsItem.getComment());
        holder.locationView.setText(newsItem.getLocation());

        if (holder.imageView != null) {
            new ImageDownloaderTask(holder.imageView).execute(newsItem.getImageURL());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView nameView;
        ImageView imageView;
        TextView commentView;
        TextView starsView;
        TextView locationView;
        TextView tagsView;
    }

    /*
    private String imageURL;
    private String name;
    private String comment;
    private Double stars;
    private String location;
    private String tags;
     */
}

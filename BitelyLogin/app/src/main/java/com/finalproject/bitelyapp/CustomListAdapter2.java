package com.finalproject.bitelyapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Enoz on 11/16/2016.
 */

public class CustomListAdapter2 extends BaseAdapter {
    private ArrayList listData;
    private LayoutInflater layoutInflater;

    public CustomListAdapter2(Context context, ArrayList listData) {
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
            convertView = layoutInflater.inflate(R.layout.trending_list_item_layout, null);
            holder = new ViewHolder();
            holder.headlineView = (TextView) convertView.findViewById(R.id.title);
            holder.reporterNameView = (TextView) convertView.findViewById(R.id.reporter);
            holder.reportedDateView = (TextView) convertView.findViewById(R.id.date);
            holder.imageView = (ImageView) convertView.findViewById(R.id.thumbImage);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }


        ListItem newsItem = (ListItem) listData.get(position);
        holder.headlineView.setText(newsItem.getName());
        // holder.reporterNameView.setText("By, " + newsItem.getReporterName());
        // holder.reportedDateView.setText(newsItem.getDate());

        if (holder.imageView != null) {
            new ImageDownloaderTask(holder.imageView).execute(newsItem.getImageURL());
        }

        return convertView;
    }

    static class ViewHolder {
        TextView headlineView;
        TextView reporterNameView;
        TextView reportedDateView;
        ImageView imageView;
    }
}

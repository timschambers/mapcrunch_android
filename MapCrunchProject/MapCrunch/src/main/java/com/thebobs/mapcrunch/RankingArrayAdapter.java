package com.thebobs.mapcrunch;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

// here's our beautiful adapter
public class RankingArrayAdapter extends ArrayAdapter<Ranking> {

    Context mContext;
    int layoutResourceId;
    private static ArrayList<Ranking> rankings = new ArrayList<Ranking>();

    public RankingArrayAdapter(Context mContext, int layoutResourceId, ArrayList<Ranking> r) {
        super(mContext, layoutResourceId, r);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.rankings = r;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            // inflate the layout
            LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
            convertView = inflater.inflate(layoutResourceId, parent, false);
        }

        // object item based on the position
        Ranking rank = rankings.get(position);

        // get the TextView and then set the text (item name) and tag (item ID) values
        TextView textViewItem = (TextView) convertView.findViewById(R.id.textViewItem);
        textViewItem.setText(rank.getName());
        textViewItem.setTag(rank.getScore());

        return convertView;

    }

}
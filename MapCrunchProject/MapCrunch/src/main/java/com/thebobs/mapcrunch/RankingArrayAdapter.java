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

    private final Context mContext;
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
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rankings_row_item, parent, false);
        TextView txtvwName = (TextView) rowView.findViewById(R.id.rankingName);
        txtvwName.setText(rankings.get(position).getName());
        TextView txtvwScore = (TextView) rowView.findViewById(R.id.rankingValue);
        txtvwScore.setText(Double.toString(rankings.get(position).getScore()));

        return rowView;
    }

}
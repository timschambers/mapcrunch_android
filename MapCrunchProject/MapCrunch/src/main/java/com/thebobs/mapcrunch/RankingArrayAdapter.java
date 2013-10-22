package com.thebobs.mapcrunch;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingArrayAdapter extends ArrayAdapter<Ranking> {

    private final Context mContext;
    int layoutResourceId;
    private static ArrayList<Ranking> rankings = new ArrayList<Ranking>();
    private Typeface tfNevis;

    public RankingArrayAdapter(Context mContext, int layoutResourceId, ArrayList<Ranking> r,
                               Typeface n) {
        super(mContext, layoutResourceId, r);

        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.rankings = r;
        this.tfNevis = n;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Ranking current = rankings.get(position);

        //Inflate the layout
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.rankings_row_item, parent, false);

        //Set text and font for each element of the row
        TextView txtvwName = (TextView) rowView.findViewById(R.id.rankingName);
        txtvwName.setText(current.getName());
        txtvwName.setTypeface(tfNevis);

        TextView txtvwScore = (TextView) rowView.findViewById(R.id.rankingValue);
        txtvwScore.setText(Double.toString(current.getScore()));
        txtvwScore.setTypeface(tfNevis);

        TextView txtvwPlace = (TextView) rowView.findViewById(R.id.rankingPlace);
        txtvwPlace.setText(Integer.toString(current.getPlace()));
        txtvwPlace.setTypeface(tfNevis);

        return rowView;
    }

}
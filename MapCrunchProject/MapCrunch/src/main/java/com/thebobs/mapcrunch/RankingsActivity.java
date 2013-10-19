package com.thebobs.mapcrunch;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);
        setTitle("Rankings");
        final ListView lstRankings = (ListView) findViewById(R.id.lstRankings);

        ArrayList<Ranking> samplerankings = new ArrayList<Ranking>();
        samplerankings.add(new Ranking("Ben", 100.00, 1));
        samplerankings.add(new Ranking("Alexei", 83.91, 2));
        samplerankings.add(new Ranking("Sophia", 78.12, 3));
        samplerankings.add(new Ranking("Tim", 12.03, 4));

        ArrayAdapter adapter = new RankingArrayAdapter(this, R.layout.activity_rankings,samplerankings);

        View header = (View)getLayoutInflater().inflate(R.layout.rankings_header_row, null);
        lstRankings.addHeaderView(header);
        lstRankings.setAdapter(adapter);
        //lstRankings.setOnItemClickListener(new Listener());
    }
}
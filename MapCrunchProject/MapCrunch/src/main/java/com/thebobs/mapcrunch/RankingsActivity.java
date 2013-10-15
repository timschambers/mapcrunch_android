package com.thebobs.mapcrunch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rankings");
        final ListView lstRankings = (ListView) findViewById(R.id.lstRankings);

        ArrayList<Ranking> samplerankings = new ArrayList<Ranking>();
        samplerankings.add(new Ranking("Ben", 100.00));
        samplerankings.add(new Ranking("Alexei", 83.91));
        samplerankings.add(new Ranking("Sophia", 78.12));
        samplerankings.add(new Ranking("Time", 12.03));


        ArrayAdapter adapter = new RankingArrayAdapter(this,
                android.R.layout.simple_list_item_1, samplerankings);
        lstRankings.setAdapter(adapter);
        //lstRankings.setOnItemClickListener(new Listener());
    }
}
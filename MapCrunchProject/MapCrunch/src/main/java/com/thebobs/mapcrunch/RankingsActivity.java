package com.thebobs.mapcrunch;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class RankingsActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Rankings");
        final ListView lstRankings = (ListView) findViewById(R.id.lstRankings);

        Ranking[] samplerankings = {new Ranking("Ben", 100.00),
                                    new Ranking("Alexei", 83.90),
                                    new Ranking("Sophia", 78.12),
                                    new Ranking("Tim", 12.03)};

        ArrayAdapter adapter = new RankingArrayAdapter(this,
                android.R.layout.simple_list_item_1, samplerankings);
        lstRankings.setAdapter(adapter);
        //lstRankings.setOnItemClickListener(new Listener());
    }
}
package com.thebobs.mapcrunch;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class RankingsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rankings);

        setTitle("Rankings");

        final ListView lstRankings = (ListView) findViewById(R.id.lstRankings);

        ScoreDataSource datasource = new ScoreDataSource(this);
        datasource.open();

        ArrayList <Ranking> samplerankings = datasource.getTopScores(20);

        //Get font from assets to pass into adapter
        Typeface tfNevis = Typeface.createFromAsset(getAssets(), "fonts/nevis.ttf");
        ArrayAdapter adapter = new RankingArrayAdapter(this,
                R.layout.activity_rankings,samplerankings, tfNevis);

        lstRankings.setAdapter(adapter);
    }
}
package com.thebobs.mapcrunch;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        //Get typeface from assets
        Typeface tfNevis = Typeface.createFromAsset(getAssets(), "fonts/nevis.ttf");

        //set banner image
        final ImageView imgBanner = (ImageView) findViewById(R.id.imgBanner);
        imgBanner.setImageResource(R.drawable.ic_full_scoutt);

        //Get buttons from view
        final Button btnStart = (Button) findViewById(R.id.btnStart);
        final Button btnSettings = (Button) findViewById(R.id.btnSettings);
        final Button btnRankings = (Button) findViewById(R.id.btnRankings);
        final Button btnGameTest = (Button) findViewById(R.id.btnGameTest);
        final Button btnInser = (Button) findViewById(R.id.btnInser);

        btnStart.setTypeface(tfNevis);
        btnSettings.setTypeface(tfNevis);
        btnRankings.setTypeface(tfNevis);

        //Set onclick listeners for all buttons
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intSettings = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intSettings);
            }
        });
        btnRankings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intRankings = new Intent(MainActivity.this, RankingsActivity.class);
                MainActivity.this.startActivity(intRankings);
            }
        });

        btnStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intMode = new Intent(MainActivity.this, ModeActivity.class);
                MainActivity.this.startActivity(intMode);
            }
        });

        btnInser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intMode = new Intent(MainActivity.this, ScorePromptActivity.class);
                MainActivity.this.startActivity(intMode);
            }
        });

        btnGameTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intMode = new Intent(MainActivity.this, GameActivity.class);
                intMode.putExtra("latStart", 42.345573);
                intMode.putExtra("longStart", -71.098326);
                intMode.putExtra("latEnd", 42.345032);
                intMode.putExtra("longEnd", -71.098053);
                intMode.putExtra("timeLimit", 100);
                MainActivity.this.startActivity(intMode);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}

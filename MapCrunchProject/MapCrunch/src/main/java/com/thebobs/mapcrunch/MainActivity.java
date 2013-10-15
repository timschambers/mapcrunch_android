package com.thebobs.mapcrunch;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnSettings = (Button) findViewById(R.id.btnSettings);
        btnSettings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intSettings = new Intent(MainActivity.this, SettingsActivity.class);
                MainActivity.this.startActivity(intSettings);
            }
        });

        final Button btnRankings = (Button) findViewById(R.id.btnRankings);
        btnRankings.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                Intent intRankings = new Intent(MainActivity.this, RankingsActivity.class);
                MainActivity.this.startActivity(intRankings);
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

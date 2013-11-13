package com.thebobs.mapcrunch;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by ben on 11/9/13.
 */
public class GameFinishActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_finish);

        //Get typeface from assets
        Typeface tfNevis = Typeface.createFromAsset(getAssets(), "fonts/nevis.ttf");

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String victory = extras.getString("victory");
            String time = extras.getString("time");
            String steps = extras.getString("steps");
            //TODO: String distance = extras.getString("distance");

            final TextView txtWin = (TextView) findViewById(R.id.txtWin);
            final TextView txtTime = (TextView) findViewById(R.id.txtTime);
            final TextView txtSteps = (TextView) findViewById(R.id.txtSteps);

            txtWin.setTypeface(tfNevis);
            txtTime.setTypeface(tfNevis);
            txtSteps.setTypeface(tfNevis);

            if (victory.equals("true")){
                txtWin.setText("You win!");
                //Calculate score and add to DB here
            } else {
                txtWin.setText("You lose!");
            }
            txtTime.setText((time));
            txtSteps.setText((steps));
        }


    }
}
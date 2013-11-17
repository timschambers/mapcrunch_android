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
            int time = Integer.parseInt(extras.getString("time"));
            int steps = Integer.parseInt(extras.getString("steps"));
            int timelimit = Integer.parseInt(extras.getString("timelimit"));
            int timeelapsed = timelimit - time;

            final TextView txtWin = (TextView) findViewById(R.id.txtWin);
            final TextView txtTime = (TextView) findViewById(R.id.txtTime);
            final TextView txtSteps = (TextView) findViewById(R.id.txtSteps);
            final TextView txtScore = (TextView) findViewById(R.id.txtScore);

            txtWin.setTypeface(tfNevis);
            txtTime.setTypeface(tfNevis);
            txtSteps.setTypeface(tfNevis);
            txtScore.setTypeface(tfNevis);

            if (victory.equals("true")){
                txtWin.setText("You win!");
                double score = (steps*180) / timeelapsed;
                txtTime.setText("Time Elapsed: " + timeelapsed + " seconds");
                txtSteps.setText("Steps: " + steps);
                txtScore.setText("Your score: " + score);
                
                //Alex - add score to database here. Maybe show a message about whether or not
                //they made the top ten and what their position is if they did?
            } else {
                txtWin.setText("You lose!");
                txtTime.setText("Time Elapsed: " + timeelapsed + " seconds");
                txtSteps.setText("Steps: " + steps);
                txtScore.setText("Press back to try again!");
            }


        }


    }
}
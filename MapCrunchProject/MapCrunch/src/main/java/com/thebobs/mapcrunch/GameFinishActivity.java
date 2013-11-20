package com.thebobs.mapcrunch;

import android.app.Activity;
import android.app.AlertDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

            final ScoreDataSource datasource = new ScoreDataSource(this);

            final TextView txtWin = (TextView) findViewById(R.id.txtWin);
            final TextView txtTime = (TextView) findViewById(R.id.txtTime);
            final TextView txtSteps = (TextView) findViewById(R.id.txtSteps);
            final TextView txtScore = (TextView) findViewById(R.id.txtScore);
            final EditText txtName = (EditText) findViewById(R.id.txtName);
            final TextView txtNamePrompt = (TextView) findViewById(R.id.txtView);
            final Button doneBtn = (Button) findViewById(R.id.btnDone);

            txtWin.setTypeface(tfNevis);
            txtTime.setTypeface(tfNevis);
            txtSteps.setTypeface(tfNevis);
            txtScore.setTypeface(tfNevis);

            if (victory.equals("true")){
                txtWin.setText(getString(R.string.GameFinishWin));
                final double score = (steps*180) / timeelapsed;
                txtTime.setText(getString(R.string.GameFinishTime) + timeelapsed + getString(R.string.GameFinishSeconds));
                txtSteps.setText(getString(R.string.GameFinishSteps) + steps);
                txtScore.setText(getString(R.string.GameFinishScore) + score);

                doneBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        datasource.open();
                        datasource.insertScore(txtName.getText().toString(), score);
                        int rank = datasource.isHighScore(txtName.getText().toString(), score, 20);
                        if ( rank > -1){
                            new AlertDialog.Builder(GameFinishActivity.this)
                                    .setIcon(android.R.drawable.ic_dialog_alert)
                                    .setTitle("Congratulations!")
                                    .setMessage("Congratulations on your high score! You are ranked player number: " + rank )
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        @Override //finish when ok is clicked
                                        public void onClick(DialogInterface dialog, int which) {
                                            finish();
                                        }
                                    })
                                    .show();
                        }
                        else{
                            finish();
                        }
                    }
                });

            } else {
                txtWin.setText(getString(R.string.GameFinishLose));
                txtTime.setText(getString(R.string.GameFinishTime) + timeelapsed + getString(R.string.GameFinishSeconds));
                txtSteps.setText(getString(R.string.GameFinishSteps) + steps);
                txtScore.setText(getString(R.string.GameFinishTryAgain));
                txtName.setVisibility(4);
                txtNamePrompt.setVisibility(4);
                doneBtn.setVisibility(4);
            }


        }


    }
}
package com.thebobs.mapcrunch;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.view.View.OnClickListener;

import java.util.Random;


public class ScorePromptActivity extends Activity {
    private EditText editTextName;
    private Button button;

    ScoreDataSource datasource = new ScoreDataSource(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_prompt);

        setTitle("High Score!");

        editTextName = (EditText) findViewById(R.id.editText);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                datasource.open();
                Random ran = new Random();
                datasource.insertScore(editTextName.getText().toString(), ran.nextDouble()*100);
                finish();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.score_prompt, menu);
        return true;
    }
    
}

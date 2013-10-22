package com.thebobs.mapcrunch;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ModeActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        //Get typefaces from assets
        Typeface tfNevis = Typeface.createFromAsset(getAssets(), "fonts/nevis.ttf");
        Typeface tfChunk = Typeface.createFromAsset(getAssets(), "fonts/Chunk.ttf");

        //Get elements from view
        final Button btnMode1 = (Button) findViewById(R.id.btnMode1);
        final Button btnMode2 = (Button) findViewById(R.id.btnMode2);
        final TextView txtModeHeader = (TextView) findViewById(R.id.txtModeHeader);

        btnMode1.setTypeface(tfNevis);
        btnMode2.setTypeface(tfNevis);
        txtModeHeader.setTypeface(tfChunk);
    }
}
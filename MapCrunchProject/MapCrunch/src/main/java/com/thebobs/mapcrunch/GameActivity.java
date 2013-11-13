package com.thebobs.mapcrunch;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;

/**
 * Created by ben on 10/30/13.
 */
public class GameActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set orientation to landscape
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        // Set window to full screen; code borrrowed from (http://www.androidsnippets.com/how-to-make-an-activity-fullscreen)
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_game);

        //Get webview, create client, enable javascript and load URL
        WebView gameView = (WebView) findViewById(R.id.webvwMainGame);

//        final String url1 = "javascript:(function() { " +
//                "window.latStart = " + latStart  + "; " +
//                "window.longStart = "  + longStart + ";" +
//                "window.latEnd =" + latEnd + ";" +
//                "window.longEnd =" + longEnd + ";" +
//                "window.timeLimit =" + timeLimit + ";" +
//                "window.initialize(); })()";
//        gameView.setWebViewClient(new WebViewClient() {
//            @Override
//            public void onPageFinished(WebView view, String url) {
//                view.loadUrl(url1);
//            }
//
//        });
        gameView.getSettings().setJavaScriptEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            InGameInterface inGame = new InGameInterface(this,
                    extras.getDouble("latStart"),
                    extras.getDouble("longStart"),
                    extras.getDouble("latEnd"),
                    extras.getDouble("longEnd"),
                    extras.getInt("timeLimit"),
                    this);
            gameView.addJavascriptInterface(inGame, "Android");
            gameView.loadUrl("file:///android_asset/html/in_game.html");
        }

    }

    public void finishGame(String victory, String time, String steps) {
        Intent intWin = new Intent(GameActivity.this, GameFinishActivity.class);
        intWin.putExtra("victory", victory);
        intWin.putExtra("time", time);
        intWin.putExtra("steps", steps);
        GameActivity.this.startActivity(intWin);
        this.finish();
    }
}

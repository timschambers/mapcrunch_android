package com.thebobs.mapcrunch;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        gameView.setWebViewClient(new WebViewClient());
        gameView.getSettings().setJavaScriptEnabled(true);
        gameView.loadUrl("https://maps.google.es/maps?q=barcelona&aq=f&ie=UTF8&hl=es&hq=&hnear=Barcelona,+Catalu%C3%B1a&ll=41.385064,2.173404&spn=0.32884,0.727158&t=h&z=11&layer=c&cbll=41.384233,2.177893&panoid=cHQCwlORibRoxMqj2m9IVg&cbp=12,0,,0,0&source=embed&output=svembed");

    }
}
package com.thebobs.mapcrunch;

import android.content.Context;
import android.webkit.JavascriptInterface;

/**
 * Created by ben on 11/9/13.
 */
public class InGameInterface {
    Context mContext;
    private double latStart, longStart, latEnd, longEnd;
    GameActivity game;

    @JavascriptInterface
    public int getTimeLimit() {
        return timeLimit;
    }

    @JavascriptInterface
    public double getLatStart() {
        return latStart;
    }

    @JavascriptInterface
    public double getLongStart() {
        return longStart;
    }

    @JavascriptInterface
    public double getLatEnd() {
        return latEnd;
    }

    @JavascriptInterface
    public double getLongEnd() {
        return longEnd;
    }

    @JavascriptInterface
    public void finishGame(String victory, String time, String timelimit, String steps) {
        game.finishGame(victory, time, timelimit, steps);
    }

    private int timeLimit;
    /** Instantiate the interface and set the context */
    InGameInterface(Context c, double latStart, double longStart, double latEnd, double longEnd, int timeLimit, GameActivity game) {
        mContext = c;
        this.latStart = latStart;
        this.longStart = longStart;
        this.latEnd = latEnd;
        this.longEnd = longEnd;
        this.timeLimit = timeLimit;
        this.game = game;
    }

}
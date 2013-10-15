package com.thebobs.mapcrunch;

/**
 * Created by ben on 10/15/13.
 */
public class Ranking {
    private String name;
    private double score;

    public Ranking(String n, double s) {
        name = n;
        score = s;
    }

    public void setScore(double s) { score = s; }

    public double getScore() { return score; }

    public void setName(String n) { name = n; }

    public String getName() { return name; }
}

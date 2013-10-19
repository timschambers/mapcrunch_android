package com.thebobs.mapcrunch;

/**
 * Created by ben on 10/15/13.
 */
public class Ranking {
    private String name;
    private double score;
    private int place;

    public Ranking(String n, double s, int p) {
        name = n;
        score = s;
        place = p;
    }

    public void setScore(double s) { score = s; }

    public double getScore() { return score; }

    public void setName(String n) { name = n; }

    public String getName() { return name; }

    public void setPlace(int p) { place = p; }

    public int getPlace() { return place; }
}

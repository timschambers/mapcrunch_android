package com.thebobs.mapcrunch;

//another class to handle item's id and name
public class RankingItem {

    public String name;
    public double score;

    // constructor
    public RankingItem(Ranking r) {
        this.name = r.getName();
        this.score = r.getScore();
    }

}
package com.thebobs.mapcrunch;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by abulazel on 10/26/13.
 */
public class ScoreDataSource {
    private SQLiteDatabase db;
    private ScoreDatabase dbhelper;

    public ScoreDataSource(Context context){
        dbhelper = new ScoreDatabase(context);
    }

    public void open() throws SQLException{
        db = dbhelper.getWritableDatabase();
    }

    public void close(){
        dbhelper.close();
    }

    public void insertScore(String name, double score){
        ContentValues values = new ContentValues();
        values.put(ScoreDatabase.NAME_COL, name);
        values.put(ScoreDatabase.SCORE_COL, score);
        db.insert(ScoreDatabase.TABLE_SCORE, null, values);
    }

    public int isHighScore(String name, double score, int limit){
        Cursor cursor = db.rawQuery("SELECT * FROM " + ScoreDatabase.TABLE_SCORE +
                " ORDER BY score DESC LIMIT " + Integer.toString(limit), null);
        cursor.moveToFirst();
        int i = 1;
        while(!cursor.isAfterLast()){
           if (cursor.getString(1) == name && cursor.getDouble(2) == score){
               return i;
           }
           cursor.moveToNext();

        }
        return -1;

    }

     public ArrayList <Ranking> getTopScores(int limit){
        ArrayList<Ranking> hscores = new ArrayList<Ranking>();
        Cursor cursor = db.rawQuery("SELECT * FROM " + ScoreDatabase.TABLE_SCORE +
                " ORDER BY score DESC LIMIT " + Integer.toString(limit), null);
        cursor.moveToFirst();
        int i = 1;
        while(!cursor.isAfterLast()){
            Ranking h = cursorToScore(cursor, i);
            hscores.add(h);
            cursor.moveToNext();
            i++;
        }
        cursor.close();
        return hscores;
    }

    private Ranking cursorToScore(Cursor cursor, int index){
        return new Ranking(cursor.getString(1), cursor.getDouble(2), index);
    }

    public void DropTable( ){
        dbhelper.drop(db);
    }
}

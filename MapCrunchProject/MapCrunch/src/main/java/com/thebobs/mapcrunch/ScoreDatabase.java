package com.thebobs.mapcrunch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLClientInfoException;

/**
 * Created by abulazel on 10/23/13.
 *
 * http://www.vogella.com/articles/AndroidSQLite/article.html
 */
public class ScoreDatabase extends SQLiteOpenHelper {

    public static final String TABLE_SCORE = "hiscores";
    public static final String NAME_COL = "name";
    public static final String SCORE_COL = "score";

    private static final String DATABASE_CREATE = "CREATE TABLE " + TABLE_SCORE +
            " (hi_id integer primary key autoincrement, " + NAME_COL + " text not null, " +
            SCORE_COL + " float not null);";

    //constructor
    public ScoreDatabase(Context context){
        super(context, TABLE_SCORE, null, 1);
    }

    //db creation, necessary for SQLite
    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);
    }

    //db wipe and restart, necessary for SQLite
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        drop(db);
    }

    public void drop(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCORE);
        onCreate(db);
    }
}

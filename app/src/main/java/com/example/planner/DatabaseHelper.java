package com.example.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbname ="STUDY_TABLE";
    public static final String EVENT_ID = "ID";
    public static final String EVENT_TYPE = "TYPE";
    public static final String EVENT_TITLE = "TITLE";
    public static final String EVENT_DESCRIPTION = "DESCRIPTION";
    public static final String EVENT_DATE = "DATE";
    public static final String EVENT_TIME = "TIME";
    public static final String EVENT_TABLE = "EVENT_TABLE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "events.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "";
        db.execSQL("CREATE TABLE " + EVENT_TABLE + " (" + EVENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + EVENT_TYPE + " TEXT, " + EVENT_TITLE + " TEXT, " + EVENT_DESCRIPTION + " TEXT, " + EVENT_DATE + " TEXT, " + EVENT_TIME + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(design Design){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(EVENT_TYPE, Design.getEvent_type());
        cv.put(EVENT_TITLE, Design.getTitle());
        cv.put(EVENT_DESCRIPTION, Design.getDescription());
        cv.put(EVENT_DATE, Design.getDate());
        cv.put(EVENT_TIME, Design.getTime());
        long insert = db.insert(EVENT_TABLE, null, cv);
        if(insert==-1) {return false;}
        else {return true;}
    }

}

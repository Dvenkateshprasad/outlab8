package com.example.planner;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String dbname ="app.db";
    public static final String TABLE_NAME = "TASK_TABLE";
    public static final String TITLE = "TITLE";
    public static final String DATE = "DATE";
    public static final String TIME = "TIME";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String TYPE = "TYPE";

    public DatabaseHelper(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatment= "CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT ," + TITLE + " TEXT, " + DATE + " TEXT, " + TIME + " TEXT, " + DESCRIPTION + " TEXT, " + TYPE + " TEXT)";
        db.execSQL(createTableStatment);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addOne(design item,int index){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("ID",item.getItemid());
        cv.put(TITLE,item.getTitle());
        cv.put(DATE,item.getDate());
        cv.put(TIME,item.getTime());
        cv.put(DESCRIPTION,item.getDescription());
        switch (index){
            case 1:
                cv.put(TYPE,"study");
                break;
            case 2:
                cv.put(TYPE,"assignments");
                break;
            case 3:
                cv.put(TYPE,"exams");
                break;
            case 4:
                cv.put(TYPE,"lectures");
                break;
        }
        long insert = db.insert(TABLE_NAME,null,cv);
        if(insert==-1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean DeleteOne(design item){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString  = "DELETE FROM "+TABLE_NAME+" WHERE ID = "+item.getItemid();
        Cursor cursor = db.rawQuery(queryString,null);
        db.close();
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }
    public int maxId(){
        SQLiteDatabase db = this.getReadableDatabase();
        String queryString = "SELECT MAX(ID) FROM "+TABLE_NAME;
        Cursor cursor = db.rawQuery(queryString,null);
        if(cursor!=null){
            cursor.moveToFirst();
            int id = cursor.getInt(0);
            return id+1;
        }
        return 1;
    }
    public List<design> data(int index){
        List<design>arrayList = new ArrayList<>();
        String queryString1  = "SELECT * FROM "+TABLE_NAME+" WHERE TYPE = 'study';";
        String queryString2  = "SELECT * FROM "+TABLE_NAME+" WHERE TYPE = 'assignments';";
        String queryString3  = "SELECT * FROM "+TABLE_NAME+" WHERE TYPE = 'exams';";
        String queryString4  = "SELECT * FROM "+TABLE_NAME+" WHERE TYPE = 'lectures';";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        switch (index){
            case 1:
                cursor = db.rawQuery(queryString1,null);
                break;
            case 2:
                cursor = db.rawQuery(queryString2,null);
                break;
            case 3:
                cursor = db.rawQuery(queryString3,null);
                break;
            case 4:
                cursor = db.rawQuery(queryString4,null);
                break;
            default:
                cursor = db.rawQuery(queryString1,null);
        }

        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String title = cursor.getString(1);
                String date = cursor.getString(2);
                String time = cursor.getString(3);
                String description = cursor.getString(4);
                design newdesign = new design(id,title,date,description,time);
                arrayList.add(newdesign);
            }while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return arrayList;
    }
}

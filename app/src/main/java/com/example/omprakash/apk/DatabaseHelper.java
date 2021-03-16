package com.example.omprakash.apk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String TABLE_NAME1 = "student_table1";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";
    public static final String COL_5 = "col1";
    public static final String COL_6 = "col2";
    public static final String COL_7 = "col3";
    public static final String COL_8 = "col4";
    public static final String COL_9 = "mop1";
    public static final String COL_10 = "mop2";
    public static final String COL_11 = "mop3";
    public static final String COL_12 = "mop4";
    public static final String COL_13 = "total";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS INTEGER,col1 INTEGER,col2 INTEGER,col3 INTEGER,col4 INTEGER,mop1 INTEGER,mop2 INTEGER,mop3 INTEGER,mop4 INTEGER, total INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        onCreate(db);
    }

    public boolean insertData(String name, String surname, String marks,String col1, String col2, String col3, String col4,String mop1,String mop2,String mop3,String mop4,String total) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        contentValues.put(COL_5, col1);
        contentValues.put(COL_6, col2);
        contentValues.put(COL_7, col3);
        contentValues.put(COL_8, col4);
        contentValues.put(COL_9, mop1);
        contentValues.put(COL_10, mop2);
        contentValues.put(COL_11, mop3);
        contentValues.put(COL_12, mop4);
        contentValues.put(COL_13, total);

        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }


    public boolean updateData(String id, String name, String surname, String marks, String col1, String col2, String col3, String col4) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, id);
        contentValues.put(COL_2, name);
        contentValues.put(COL_3, surname);
        contentValues.put(COL_4, marks);
        contentValues.put(COL_5, col1);
        contentValues.put(COL_6, col2);
        contentValues.put(COL_7, col3);
        contentValues.put(COL_8, col4);


        db.update(TABLE_NAME, contentValues, "ID = ?", new String[]{id});
        return true;
    }


    public Integer deleteData(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?", new String[]{id});
    }


}
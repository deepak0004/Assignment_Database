package com.example.lenovo.assignment_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String D_NAME = "College.db", T_NAME = "College_table", col_1 = "Name", col_2 = "Roll_No", col_3 = "Semester";

    public DataBase(Context context) {
        super(context, D_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase data_ba) {
        data_ba.execSQL( "create table " + T_NAME + " ( NAME TEXT, Roll_No INTEGER PRIMARY KEY, Semester TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase data_ba, int oldVersion, int newVersion) {
        data_ba.execSQL("DROP TABLE IF EXISTS " + T_NAME);
        onCreate(data_ba);
    }

    public boolean insertData(String name, String roll_no, String semester) {
        SQLiteDatabase data_ba = this.getWritableDatabase();
        ContentValues valu = new ContentValues();
        valu.put(col_1, name);
        valu.put(col_2, roll_no);
        valu.put(col_3, semester);
        long anss2 = data_ba.insert(T_NAME, null, valu);

        if(anss2 == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase data_ba = this.getWritableDatabase();
        Cursor anss = data_ba.rawQuery("select * from " + T_NAME, null);

        return anss;
    }

    public boolean updateData(String name, String roll_no, String semester) {
        SQLiteDatabase data_ba = this.getWritableDatabase();
        ContentValues valu = new ContentValues();
        valu.put(col_1, name);
        valu.put(col_2, roll_no);
        valu.put(col_3, semester);
        data_ba.update(T_NAME, valu, "Roll_No = ?", new String[] { roll_no });

        return true;
    }

    public Integer deleteData (String roll_no) {
        SQLiteDatabase data_ba = this.getWritableDatabase();

        return data_ba.delete(T_NAME, "Roll_No = ?", new String[] { roll_no } );
    }
}
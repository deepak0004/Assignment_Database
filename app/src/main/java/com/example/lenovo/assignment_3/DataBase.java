package com.example.lenovo.assignment_3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String D_NAME = "Student.db", T_NAME = "student_table", col_1 = "Name", col_2 = "Roll_No", col_3 = "Semester";
    public DataBase(Context context) {
        super(context, D_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( "create table " + T_NAME + " ( NAME TEXT, Roll_No INTEGER PRIMARY KEY, Semester TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + T_NAME);
        onCreate(db);
    }

    public boolean insertData(String name, String roll_no, String semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valu = new ContentValues();
        valu.put(col_1, name);
        valu.put(col_2, roll_no);
        valu.put(col_3, semester);
        long result = db.insert(T_NAME, null, valu);
        if(result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + T_NAME, null);
        return res;
    }

    public boolean updateData(String name, String roll_no, String semester) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues valu = new ContentValues();
        valu.put(col_1, name);
        valu.put(col_2, roll_no);
        valu.put(col_3, semester);
        db.update(T_NAME, valu, "Roll_No = ?", new String[] { roll_no });
        return true;
    }

    public Integer deleteData (String roll_no) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(T_NAME, "Roll_No = ?",new String[] { roll_no } );
    }
}
package com.jaloliddinabdullaevv.bridge.DBHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.SavolNomer;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class DBHelper extends SQLiteAssetHelper {
    private static final String DB_NAME = "hackathonSampleTest.db";
    private static final int DB_VER = 1;

    @SuppressLint("StaticFieldLeak")
    private static DBHelper instance;

    public static synchronized DBHelper getInstance(Context context) {
        if (instance == null)
            instance = new DBHelper(context);
        return instance;
    }

    public DBHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }


    public ArrayList<SavolNomer> getQuestion() {
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery(String.format("SELECT * FROM MultipleChoice WHERE qText is NOT NULL ORDER BY RANDOM() LIMIT 25;"), null);
        ArrayList<SavolNomer> savolNomers = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                SavolNomer savolNomer = new SavolNomer(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("qText")),
                        cursor.getString(cursor.getColumnIndex("optionA")),
                        cursor.getString(cursor.getColumnIndex("optionB")),
                        cursor.getString(cursor.getColumnIndex("optionC")),
                        cursor.getString(cursor.getColumnIndex("key")));
                Common.togriJavoblarDatabasedan.add(cursor.getString(cursor.getColumnIndex("key")));
                savolNomers.add(savolNomer);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return savolNomers;
    }
}
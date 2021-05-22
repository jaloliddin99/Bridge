package com.jaloliddinabdullaevv.bridge.DBHelper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.jaloliddinabdullaevv.bridge.Common.Common;
import com.jaloliddinabdullaevv.bridge.Model.QuestionNumber;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;

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


    public ArrayList<QuestionNumber> getQuestion() {
        SQLiteDatabase db = instance.getWritableDatabase();
        Cursor cursor = db.rawQuery(String.format("SELECT * FROM MultipleChoice WHERE qText is NOT NULL ORDER BY RANDOM() LIMIT 25;"), null);
        ArrayList<QuestionNumber> questionNumbers = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                QuestionNumber questionNumber = new QuestionNumber(cursor.getInt(cursor.getColumnIndex("id")),
                        cursor.getString(cursor.getColumnIndex("qText")),
                        cursor.getString(cursor.getColumnIndex("optionA")),
                        cursor.getString(cursor.getColumnIndex("optionB")),
                        cursor.getString(cursor.getColumnIndex("optionC")),
                        cursor.getString(cursor.getColumnIndex("key")));
                Common.correctAnswersFromDb.add(cursor.getString(cursor.getColumnIndex("key")));
                questionNumbers.add(questionNumber);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return questionNumbers;
    }
}
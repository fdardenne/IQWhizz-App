package com.example.iqwhizz;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import java.util.Random;

public class QuestionDAO {
    private QuestionDAO() {}

    private static Question cursorToQuestion (Cursor cursor) {
        int id = cursor.getInt(0);
        int difficulty = cursor.getInt(1);
        String cat = cursor.getString(2);
        byte[] image = cursor.getBlob(3);
        String txt = cursor.getString(4);
        Question q = new Question(id, cat, image, txt, difficulty);
        return q;
    }

    public static Question getQuestion(int id) {
        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(AppContextProvider.getContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Questions WHERE questionID = " + id, null);
        cursor.moveToFirst();
        Question q = cursorToQuestion(cursor);
        db.close();
        return q;
    }

    public static Question getRandomQuestion (String category) {
        Log.d("MyTest", "getRandomQuestion begins ...");
        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(AppContextProvider.getContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Random rand = new Random();
        Cursor cursor = db.rawQuery("SELECT count(questionID) FROM Questions WHERE category = \"" + category + "\"", null);
        cursor.moveToFirst();
        int nQuestions = cursor.getInt(0);
        int n = rand.nextInt(nQuestions);
        cursor = db.rawQuery("SELECT * FROM Questions WHERE category = \"" + category + "\"", null);
        cursor.moveToFirst();
        for (int i=0; i<n; i++) {
            cursor.moveToNext();
        }
        Question q = cursorToQuestion(cursor);
        db.close();
        Log.d("MyTest", "getRandomQuestion is OK");
        return q;
    }
}

package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iqwhizz.Classes.Question;

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
        //DatabaseHelper helper = DatabaseHelper.getDbHelper();
        //SQLiteDatabase db = helper.getReadableDatabase();
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Questions WHERE questionID = " + id, null);
        cursor.moveToFirst();
        Question q = cursorToQuestion(cursor);
        return q;
    }

    public static Question getRandomQuestion (String category) {
        Log.d("Hadrien's Tests", "getRandomQuestion begins ...");
        //DatabaseHelper helper = DatabaseHelper.getDbHelper();
        //SQLiteDatabase db = helper.getReadableDatabase();
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Random rand = new Random();
        Cursor cursor = db.rawQuery("SELECT * FROM Questions WHERE category = \"" + category + "\"", null);
        int nQuestions = cursor.getCount();
        int n = rand.nextInt(nQuestions);
        cursor.moveToPosition(n);
        Question q = cursorToQuestion(cursor);
        Log.d("Hadrien's Tests", "getRandomQuestion is OK");
        return q;
    }
}

package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iqwhizz.Objects.Answer;
import com.example.iqwhizz.Objects.Question;

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
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Questions WHERE questionID = " + id, null);
        cursor.moveToFirst();
        Question q = cursorToQuestion(cursor);
        return q;
    }

    public static Question getQuestionFromAnswer(int answerID){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("Select Q.* FROM Questions Q, PossibleAnswers P WHERE P.answerID = " + answerID + " AND P.questionID = Q.questionID", null);
        cursor.moveToFirst();
        Question q = cursorToQuestion(cursor);
        return q;
    }

    public static Question getRandomQuestion (String category) {
        Log.d("Hadrien's Tests", "getRandomQuestion begins ...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Random rand = new Random();
        Cursor cursor = db.rawQuery("SELECT * FROM Questions WHERE category = \"" + category + "\"", null);
        cursor.moveToFirst();
        int nQuestions = cursor.getCount();
        int n = rand.nextInt(nQuestions);
        cursor.moveToPosition(n);
        Question q = cursorToQuestion(cursor);
        Log.d("Hadrien's Tests", "getRandomQuestion is OK");
        return q;
    }

    public static Answer[] getAnswers(int questionID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT answerID, image, text, score FROM PossibleAnswers WHERE questionID="+questionID, null);
        cursor.moveToFirst();
        int size = cursor.getCount();
        Answer answers[] = new Answer[size];
        for (int i=0; i<size; i++) {
            answers[i] = new Answer(cursor.getInt(0), cursor.getBlob(1), cursor.getString(2), cursor.getInt(3));
            cursor.moveToNext();
        }
        return answers;
    }
}

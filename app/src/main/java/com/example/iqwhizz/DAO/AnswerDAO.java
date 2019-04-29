package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Answer;

public class AnswerDAO {
    private AnswerDAO() {}
    // TODO : à corriger.
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

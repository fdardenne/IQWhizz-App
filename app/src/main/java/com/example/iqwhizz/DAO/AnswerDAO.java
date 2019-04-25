package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Answer;

public class AnswerDAO {
    private AnswerDAO() {}

    // TODO : getAnswers() à tester !
    public static Answer[] getAnswers(int questionID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT answerID, score, image, text FROM PossibleAnswers WHERE questionID="+questionID, null);
        int size = cursor.getCount();
        Answer answers[] = new Answer[size];
        for (int i=0; i<size; i++) {
            answers[i] = new Answer(cursor.getInt(0), cursor.getBlob(3), cursor.getString(4), cursor.getInt(2));
        }
        return answers;
    }
}

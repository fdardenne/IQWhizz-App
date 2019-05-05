package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Answer;

public class AnswerDAO {
    private AnswerDAO() {}

    public static Answer getAnswer(int answerID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT answerID, image, text, score FROM PossibleAnswers WHERE answerID="+answerID, null);
        cursor.moveToFirst();
        return (cursor.getCount()==0) ?
        null : new Answer(cursor.getInt(0), cursor.getBlob(1), cursor.getString(2), cursor.getInt(3));
    }
}

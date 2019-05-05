package com.example.iqwhizz.DAO;

import android.content.ContentValues;
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
        Cursor cursor = db.rawQuery("SELECT answerID FROM PossibleAnswers WHERE questionID="+questionID, null);
        cursor.moveToFirst();
        int size = cursor.getCount();
        Answer answers[] = new Answer[size];
        for (int i=0; i<size; i++) {
            answers[i] = AnswerDAO.getAnswer(cursor.getInt(0));
            cursor.moveToNext();
        }
        return answers;
    }

    public static void createQuestion(String question, String goodAnswer, String answer2, String answer3, String answer4, int difficulty, String category){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        ContentValues value = new ContentValues();
        value.put("text", question);
        value.put("difficulty", difficulty);
        value.put("category", category);
        value.put("image", "");

        long questionID = db.insert("Questions", null, value);

        ContentValues value2 = new ContentValues();
        value2.put("questionID", questionID);
        value2.put("score", 200);
        value2.put("image", "");
        value2.put("text", goodAnswer);
        db.insert("PossibleAnswers", null, value2);

        ContentValues value3 = new ContentValues();
        value3.put("questionID", questionID);
        value3.put("score", 0);
        value3.put("image", "");
        value3.put("text", answer2);
        db.insert("PossibleAnswers", null, value3);

        ContentValues value4 = new ContentValues();
        value4.put("questionID", questionID);
        value4.put("score", 0);
        value4.put("image", "");
        value4.put("text", answer3);
        db.insert("PossibleAnswers", null, value4);

        ContentValues value5 = new ContentValues();
        value5.put("questionID", questionID);
        value5.put("score", 0);
        value5.put("image", "");
        value5.put("text", answer4);
        db.insert("PossibleAnswers", null, value5);

    }
}

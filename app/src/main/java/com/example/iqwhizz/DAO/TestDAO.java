package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iqwhizz.Classes.Question;
import com.example.iqwhizz.Classes.Test;

import java.util.Random;

public class TestDAO {
    private TestDAO() {}

    private static boolean isQuestionAlreadyChosen(Question[] questions, Question q) {
        boolean already = false;
        for (int i=0; i<questions.length && questions[i] != null && !already; i++) {
            if (questions[i].getID() == q.getID()) {
                already=true;
            }
        }
        return already;
    }

    public static Test getTest (int testID) {
        Log.d("TestDAO - getTest", "Getting the test ...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT type FROM Tests WHERE testID = " + testID, null);
        cursor.moveToFirst();
        String type = cursor.getString(0);
        Test test = new Test(testID, getCategory(testID), type, loadQuestions(testID, (type.equals("court")) ? 5 : 40));
        Log.d("TestDAO - getTest", "Test successfully obtained");
        return test;
    }

    private static String getCategory(int testID) {
        Log.d("TestDAO - getTest", "Getting the category...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT (CASE WHEN count(DISTINCT Q.Category)!= 1 THEN \"Multiple\" ELSE Q.Category END) AS Category FROM TestQuestions TQ, Questions Q WHERE Q.questionID=TQ.questionID AND TQ.testID = " + testID, null);
        cursor.moveToFirst();
        String cat = cursor.getString(0);
        Log.d("TestDAO - getTest", "Category successfully obtained");
        return cat;
    }

    private static Question[] loadQuestions(int testID, int nQuestions) {
        Log.d("TestDAO - getTest", "Loading the questions...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT questionID FROM TestQuestions WHERE testID = " + testID, null);
        cursor.moveToFirst();
        Question[] questions = new Question[nQuestions];
        for (int i=0; i<nQuestions; i++) {
            int questionID = cursor.getInt(0);
            questions[i] = QuestionDAO.getQuestion(questionID);
            cursor.moveToNext();
        }
        Log.d("TestDAO - getTest", "Questions successfully obtained...");
        return questions;
    }

    public static Test generateTest(String category, String type) {
        if (type.equals("long")) {
            Log.d("TestDAO - generateTest", "Long test creation begins ...");
            Question[] questions = loadQuestions(category, 40);
            int testID = saveTest(category, type, questions);
            Log.d("TestDAO - generateTest", "Long test -> OK");
            return new Test(testID, category, type, questions);
        }
        else {
            Log.d("TestDAO - generateTest", "Short test creation begins ...");
            Question[] questions = loadQuestions(category, 5);
            int testID = saveTest(category, type, questions);
            Log.d("TestDAO - generateTest", "Short test -> OK");
            return new Test(testID, category, type, questions);
        }
    }

    private static Question[] loadQuestions(String category, int nQuestions) {
        if (category.equals("random")) {
            String[] categories = {"reflexion", "logique", "calcul mental"};
            Random rand = new Random();
            int nRand = rand.nextInt(categories.length);
            return loadQuestions(categories[nRand], nQuestions);
        } else {
            Log.d("TestDAO - generateTest", "loadQuestion begins ...");
            Question[] questions = new Question[nQuestions];
            for (int i = 0; i < nQuestions; i++) {
                Question randomQuestion = QuestionDAO.getRandomQuestion(category);
                while (isQuestionAlreadyChosen(questions, randomQuestion)) {
                    randomQuestion = QuestionDAO.getRandomQuestion(category);
                }
                questions[i] = randomQuestion;
            }
            Log.d("TestDAO - generateTest", "loadQuestions is finished");
            return questions;
        }
    }

    private static int saveTest(String category, String type, Question[] questions) {
        Log.d("TestDAO - generateTest", "saveTest begins ...");
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues testValues = new ContentValues();
        testValues.put("type", type);
        int testID = (int)(db.insert("Tests", null, testValues));
        //ContentValues testQuestionsValues = new ContentValues();
        //db = DatabaseHelper.getReadableDb();
        //Cursor cursor = db.rawQuery("SELECT testID FROM Tests WHERE rowid=" + rowID, null);
        //cursor.moveToFirst();
        //int testID = cursor.getInt(0);
        for (int i=0; i<questions.length; i++) {
            ContentValues testsTableValues = new ContentValues();
            testsTableValues.put("testID", testID);
            testsTableValues.put("questionID", questions[i].getID());
            long rowID = db.insert("TestQuestions", null, testsTableValues);
            if (rowID<0) {
                Log.d("TestDAO - saveTest","fail");
            }
        }
        Log.d("TestDAO - generateTest", "saveTest is finished");
        return testID;
    }
}

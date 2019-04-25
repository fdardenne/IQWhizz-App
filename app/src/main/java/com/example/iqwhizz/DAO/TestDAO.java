package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iqwhizz.Objects.Question;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

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
        
        Log.d("TestDAO - getTest", "insertion in TestExecutions table");
        ContentValues executionValues = new ContentValues();
        executionValues.put("testID", testID);
        executionValues.put("username", User.currentUser.getUsername());
        executionValues.put("execution_date", System.currentTimeMillis()/1000);
        int executionID = (int) db.insert("TestExecutions", null, executionValues);

        Test test = new Test(testID, executionID, getCategory(testID), type, loadQuestions(testID, (type.equals("court")) ? 5 : 40));
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
        int nQuestions = (type.equals("long")) ? 40 : 5 ;
        Log.d("TestDAO - generateTest", type + " test creation begins ...");
        Question[] questions = loadQuestions(category, nQuestions);
        int IDs[] = saveTest(category, type, questions);
        Log.d("TestDAO - generateTest", type + " test -> OK");
        return new Test(IDs[0], IDs[1], category, type, questions);
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

    private static int[] saveTest(String category, String type, Question[] questions) {
        Log.d("TestDAO - saveTest", "saveTest begins ...");
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues testValues = new ContentValues();

        Log.d("TestDAO - saveTest", "insertion in Tests table");
        testValues.put("type", type);
        int testID = (int)(db.insert("Tests", null, testValues));

        Log.d("TestDAO - saveTest", "insertion in TestQuestions table");
        for (int i=0; i<questions.length; i++) {
            ContentValues testsTableValues = new ContentValues();
            testsTableValues.put("testID", testID);
            testsTableValues.put("questionID", questions[i].getID());
            long rowID = db.insert("TestQuestions", null, testsTableValues);
            if (rowID<0) {
                Log.d("TestDAO - saveTest","fail");
            }
        }

        Log.d("TestDAO - saveTest", "insertion in TestExecutions table");
        ContentValues executionValues = new ContentValues();
        executionValues.put("testID", testID);
        executionValues.put("username", User.currentUser.getUsername());
        executionValues.put("execution_date", System.currentTimeMillis()/1000);
        int executionID = (int) db.insert("TestExecutions", null, executionValues);

        Log.d("TestDAO - generateTest", "saveTest is finished");
        return new int[] {testID, executionID};
    }


    // TODO : à complèter !
    public static boolean answerToQuestion(Test test, int answerID, int time) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        ContentValues value = new ContentValues();
        value.put("executionID", test.getExecutionID());
        value.put("testID", test.getTestID());
        value.put("questionID", test.getCurrentQuestionID());
        value.put("answerID", answerID);
        value.put("time", time);
        long row = db.insert("SelectedAnswers", null, value);
        if (row>0) {
            return true;
        }
        else {
            return false;
        }
    }
}

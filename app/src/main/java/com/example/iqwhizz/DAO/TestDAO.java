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
        Test test = new Test(testID, getCategory(testID), type, loadQuestions(testID));
        Log.d("TestDAO - getTest", "Test successfully obtained");
        return test;
    }

    public static boolean executeTest(Test test) {
        Log.d("TestDAO - getTest", "executeTest ...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT type FROM Tests WHERE testID = " + test.getTestID(), null);
        cursor.moveToFirst();
        ContentValues executionValues = new ContentValues();
        executionValues.put("testID", test.getTestID());
        executionValues.put("username", User.currentUser.getUsername());
        executionValues.put("execution_date", System.currentTimeMillis()/1000);
        int executionID = (int) db.insert("TestExecutions", null, executionValues);
        Log.d("TestDAO - getTest", "executeTest has finished with id : "+executionID);
        if (executionID>0) {
            test.setExecutionID(executionID);
            return true;
        }
        else {
            return false;
        }
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

    private static Question[] loadQuestions(int testID) {
        Log.d("TestDAO - getTest", "Loading the questions from the test "+testID+" ...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT questionID FROM TestQuestions WHERE testID = " + testID, null);
        cursor.moveToFirst();
        int nQuestions = cursor.getCount();
        Question[] questions = new Question[nQuestions];
        for (int i=0; i<nQuestions; i++) {
            int questionID = cursor.getInt(0);
            questions[i] = QuestionDAO.getQuestion(questionID);
            cursor.moveToNext();
        }
        Log.d("TestDAO - getTest", "Questions successfully obtained...");
        return questions;
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

    public static boolean generateTest(String category, String type) {
        int nQuestions = (type.equals("long")) ? 40 : 5 ;
        Log.d("TestDAO - generateTest", type + " test creation begins ...");
        Question[] questions = loadQuestions(category, nQuestions);
        int testID = saveTest(category, type, questions);
        Log.d("TestDAO - generateTest", type + " test -> OK");
        return (testID > 0);
    }

    private static int saveTest(String category, String type, Question[] questions) {
        Log.d("TestDAO - saveTest", "saveTest begins ...");
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues testValues = new ContentValues();

        Log.d("TestDAO - saveTest", "insertion in Tests table");
        testValues.put("type", type);
        int testID = (int)(db.insert("Tests", null, testValues));
        if (testID<0) {
            Log.d("TestDAO - saveTest","fail when inserting in Tests");
            //return new int[] {-1, -1};
            return -1;
        }

        Log.d("TestDAO - saveTest", "insertion in TestQuestions table");
        for (int i=0; i<questions.length; i++) {
            ContentValues testsTableValues = new ContentValues();
            testsTableValues.put("testID", testID);
            testsTableValues.put("questionID", questions[i].getID());
            long rowID = db.insert("TestQuestions", null, testsTableValues);
            if (rowID<0) {
                Log.d("TestDAO - saveTest","fail when inserting in TestQuestions");
                //return new int[] {-1, -1};
                return -1;
            }
        }

        /*
        Log.d("TestDAO - saveTest", "insertion in TestExecutions table");
        ContentValues executionValues = new ContentValues();
        executionValues.put("testID", testID);
        executionValues.put("username", User.currentUser.getUsername());
        executionValues.put("execution_date", System.currentTimeMillis()/1000);
        int executionID = (int) db.insert("TestExecutions", null, executionValues);
        if (executionID<0) {
            Log.d("TestDAO - saveTest","fail when inserting in TestExecutions");
            return new int[] {-1, -1};
        }
        */

        Log.d("TestDAO - generateTest", "saveTest is finished");
        //return new int[] {testID, executionID};
        return testID;
    }


    public static int answerToQuestion(Test test, int answerID, int time) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        ContentValues value = new ContentValues();
        value.put("executionID", test.getExecutionID());
        value.put("testID", test.getTestID());
        value.put("questionID", test.getCurrentQuestionID());
        value.put("answerID", answerID);
        value.put("time", time);
        long rowID = db.insert("SelectedAnswers", null, value);
        return (int) rowID;
    }


    /**
     * donne tous les tests réalisés par l'utilisateur username
     * @param username
     * @return la liste des testIDs des tests réalisés
     */
    public static int[] getAllExecutedTest(String username)
    {
        int[] testIDs;
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT testID FROM TestExecutions WHERE username = \""+username+"\"", null);
        if(cursor.moveToFirst())
        {
            int longueur = cursor.getCount();
            testIDs = new int[longueur];
            for (int i = 0; i < longueur; i++)
            {
                testIDs[i] = cursor.getInt(0);
                cursor.moveToNext();
            }
            return testIDs;
        }
        return null;
    }
}

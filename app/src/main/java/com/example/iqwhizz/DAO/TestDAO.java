package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.iqwhizz.Objects.Answer;
import com.example.iqwhizz.Objects.Question;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import java.util.Arrays;
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

    public static Test startTest(int testID) {
        Test test = getTest(testID, 0);
        boolean bool = executeTest(test);
        return (bool) ? test : null ;
    }

    private static Test resumeTest(String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT testID, max(execution_date) FROM TestExecutions WHERE username = \"" + username + "\" GROUP BY testID", null);
        cursor.moveToFirst();
        if (cursor.getCount()==0) {
            return null;
        }
        else {
            int testID = cursor.getInt(0);
            int question_index = getNextQuestionIndex(testID, username);
            return getTest(testID, question_index);
        }
    }

    public static Test resumeTest(int testID, int executionID, int pos) {
        Test test = getTest(testID, pos);
        test.setExecutionID(executionID);
        return test;
    }

    public static int[] hasTestToResume(String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery(
                "SELECT testID, executionID, max(execution_date) FROM TestExecutions WHERE username = \"" + username + "\"",
                null);
        cursor.moveToFirst();
        if (cursor.getCount()!=1) {
            return null;
        }
        else {
            int testID = cursor.getInt(0);
            int executionID = cursor.getInt(1);
            int pos = getNextQuestionIndex(testID, username);
            String type = TestDAO.getTest(testID, 0).getType();
            int nQuestions = (type.equals("court")) ? 5 : 40;
            return (pos+1 < nQuestions) ? new int[] {testID, executionID, pos} : null;
        }
    }

    private static int getNextQuestionIndex(int testID, String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT count(*) FROM SelectedAnswers SA, TestExecutions TE WHERE SA.testID="+testID+" AND TE.executionID=SA.executionID AND TE.username=\""+username+"\"", null);
        cursor.moveToFirst();
        if (cursor.getCount()==0) {
            return cursor.getCount();
        }
        else {
            return cursor.getInt(0);
        }
    }

    public static Test getTest (int testID, int nextQuestion) {
        Log.d("TestDAO - getTest", "Getting the test ...");
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT type FROM Tests WHERE testID = " + testID, null);
        cursor.moveToFirst();
        String type = cursor.getString(0);
        Test test = new Test(testID, getCategory(testID), type, loadQuestions(testID), nextQuestion);
        Log.d("TestDAO - getTest", "Test successfully obtained");
        return test;
    }

    private static boolean executeTest(Test test) {
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

    public static String[] getPossibleCategories(int minimumQuestion){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT DISTINCT Category FROM Questions GROUP BY Category HAVING COUNT(Category) >= " + minimumQuestion, null);
        cursor.moveToFirst();
        int nCategory = cursor.getCount();
        if(nCategory > 0){
            String[] categories = new String[nCategory+1];
            categories[0] = "random";
            for(int i=1; i<nCategory+1; i++){
                String cursorString = cursor.getString(0);
                categories[i] = cursorString;
                cursor.moveToNext();
            }

            return categories;
        }
        return new String[0];

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
            String[] categoriesWithRandom = getPossibleCategories(nQuestions);
            String[] categories = Arrays.copyOfRange(categoriesWithRandom, 1, categoriesWithRandom.length);
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

    public static int generateTest(String category, String type) {
        int nQuestions = (type.equals("long")) ? 40 : 5 ;
        Log.d("TestDAO - generateTest", type + " test creation begins ...");
        Question[] questions = loadQuestions(category, nQuestions);
        int testID = saveTest(category, type, questions);
        Log.d("TestDAO - generateTest", type + " test -> OK");
        return testID;
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

        Log.d("TestDAO - generateTest", "saveTest is finished");
        return testID;
    }


    public static int answerToQuestion(Test test, int answerID, int time) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        ContentValues value = new ContentValues();
        value.put("executionID", test.getExecutionID());
        value.put("testID", test.getTestID());
        value.put("questionID", test.getNextQuestionID());
        value.put("answerID", answerID);
        value.put("time", time);
        long rowID = db.insert("SelectedAnswers", null, value);
        return (int) rowID;
    }


    /**
     * donne tous les tests réalisés par l'utilisateur username
     * @param username
     * @return la liste des executionID (entrées paires) des tests réalisés et leur date d'execution (entrées impaires)
     */
    public static int[] getAllExecutedTest(String username)
    {
        int[] execIDs;
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT executionID,execution_date FROM TestExecutions WHERE username = \""+username+"\"", null);
        if(cursor.moveToFirst())
        {
            int longueur = 2*cursor.getCount();
            execIDs = new int[longueur];
            for (int i = 0; i < longueur; i = i+2)
            {
                execIDs[i] = cursor.getInt(0);
                execIDs[i+1] = cursor.getInt(1);
                cursor.moveToNext();
            }
            return execIDs;
        }
        return null;
    }

    public static int getTestIDAssociatedTestExec(int execID){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT testID FROM TestExecutions WHERE executionID = "+execID, null);
        cursor.moveToFirst();
        return cursor.getInt(0);

    }

    public static Answer[] getSelectedAnswers(int executionID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT answerID FROM SelectedAnswers WHERE executionID="+executionID, null);
        cursor.moveToFirst();
        int size = cursor.getCount();
        Log.d("TESTFLO2", size + "");
        if (size==0) {
            return null;
        }
        Answer[] answers = new Answer[size];
        answers[0] = AnswerDAO.getAnswer(cursor.getInt(0));
        for (int i=1; cursor.moveToNext(); i++) {
            answers[i] = AnswerDAO.getAnswer(cursor.getInt(0));
        }
        return answers;
    }
}

package com.example.iqwhizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class TestDAO {
    private TestDAO() {}

    private static boolean isQuestionAlreadyChosen(Question[] questions, Question q) {
        Log.d("MyTest", "isQuestionAlreadyChosen begins ...");
        boolean already = false;
        for (int i=0; i<questions.length && questions[i] != null && !already; i++) {
            if (questions[i].getID() == q.getID()) {
                already=true;
            }
        }
        Log.d("MyTest", "isQuestionAlreadyChosen is OK");
        return already;
    }

    public static Test generateTest(String category, String type) {
        if (type.equals("long")) {
            Log.d("MyTest", "Long test creation begins ...");
            Question[] questions = loadQuestions(category, 40);
            int testID = saveTest(category, type, questions);
            Log.d("MyTest", "Long test is OK");
            return new Test(testID, category, type, questions);
        }
        else {
            Log.d("MyTest", "Short test creation begins ...");
            Question[] questions = loadQuestions(category, 5);
            int testID = saveTest(category, type, questions);
            Log.d("MyTest", "Short test is OK");
            return new Test(testID, category, type, questions);
        }
    }

    private static Question[] loadQuestions(String category, int nQuestions) {
        Log.d("MyTest", "loadQuestion begins ...");
        Question[] questions = new Question[nQuestions];
        for (int i=0; i<nQuestions; i++) {
            Question randomQuestion = QuestionDAO.getRandomQuestion(category);
            while (isQuestionAlreadyChosen(questions, randomQuestion)) {
                randomQuestion = QuestionDAO.getRandomQuestion(category);
            }
            questions[i] = randomQuestion;
        }
        Log.d("MyTest", "loadQuestions is OK");
        return questions;
    }

    private static int saveTest(String category, String type, Question[] questions) {
        Log.d("MyTest", "saveTest begins ...");
        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(AppContextProvider.getContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("type", type);
        long rowID = db.insert("Tests", null, values);
        db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT testID FROM Tests WHERE rowid=" + rowID, null);
        cursor.moveToFirst();
        int testID = cursor.getInt(0);
        db.close();
        Log.d("MyTest", "saveTest is OK");
        return testID;
    }
}

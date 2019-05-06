package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class StatsDAO {
    private StatsDAO() {}
    // TODO : implémenter les catégories multiples.
    public static int getIQ(String username, int testID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery(
                "SELECT round(avg(PA.score * (60-SA.time)/60)) " +
                        "FROM TestExecutions TE, SelectedAnswers SA, PossibleAnswers PA " +
                        "WHERE TE.username=\""+username+"\" " +
                        "AND TE.testID="+testID+" " +
                        "AND TE.executionID=SA.executionID " +
                        "AND SA.answerID=PA.answerID",
                null);
        if(cursor.moveToFirst()) {
            return cursor.getInt(0);
        }
        else {
            return -1;
        }
    }

    //Différent de l'autre car pour celui ci on donne l'ID de testExecution
    //Utilisé pour l'écran result et history qui n'a accès qu'a TestExec
    public static int getIQ(int testExecID) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery(
                "SELECT round(avg(PA.score * (60-SA.time)/60)) " +
                        "FROM TestExecutions TE, SelectedAnswers SA, PossibleAnswers PA " +
                        "WHERE TE.executionID="+testExecID+" " +
                        "AND TE.executionID=SA.executionID " +
                        "AND SA.answerID=PA.answerID",
                null);
        if(cursor.moveToFirst()) {
            return cursor.getInt(0);
        }
        else {
            return -1;
        }
    }

    private static float average(int[] integers) {
        int size = integers.length;
        int total = 0;
        for (int i=0; i<size; i++) {
            total+=integers[i];
        }
        return total/size;
    }

    public static int getAverageIQ(String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT testID FROM TestExecutions WHERE username=\""+username+"\"", null);
        if (cursor.moveToFirst()) {
            int count = cursor.getCount();
            int[] scores = new int[count];
            for (int i=0; i<count; i++) {
                int testID = cursor.getInt(0);
                scores[i]=getIQ(username, testID);
                cursor.moveToNext();
            }
            return Math.round(average(scores));
        }
        else {
            return -1;
        }
    }

    private static int maximum(int[] integers) {
        int max = integers[0];
        for (int i=1; i<integers.length; i++) {
            if (integers[i]>max) {
                max = integers[i];
            }
        }
        return max;
    }

    public static int getBestIQ(String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT testID FROM TestExecutions WHERE username=\""+username+"\"", null);
        if (cursor.moveToFirst()) {
            int count = cursor.getCount();
            int[] scores = new int[count];
            for (int i=0; i<count; i++) {
                int testID = cursor.getInt(0);
                scores[i]=getIQ(username, testID);
                cursor.moveToNext();
            }
            return maximum(scores);
        }
        else {
            return -1;
        }
    }
}

package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Challenge;

public class ChallengeDAO {

    private ChallengeDAO() {}

    /**
     * récupère les défis lancés a username qu'il n'a pas encore réalisés
     * @param username
     * @return la liste des défis
     */
    // TODO : implémenter Challenge et vérifier si ok.
    public static Challenge[] getUnDoneChallenge(String username)
    {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT sender,testID FROM Challenges " +
                "WHERE done=0 AND receiver = \""+username+"\"" ,null);
        if( cursor.moveToFirst())
        {
            int longueur = cursor.getCount();
            Challenge[] defis = new Challenge[longueur];
            for (int i = 0; i < longueur; i++)
            {
                String sender = cursor.getString(0);
                int testID = cursor.getInt(1);
                defis[i] = new Challenge(sender,username,testID);
            }
            return defis;
        }
        return null;
    }

    /**
     *  lance un nouveau challenge a l'utilisateur challenged
     *  sur le test testID
     * @param username
     * @param challenged
     * @param testID
     * @return true si l'insertion a réussi, faux sinon
     */
    public static boolean newChallenge(String username, String challenged, int testID)
    {
        ContentValues values = new ContentValues();
        values.put("sender", username);
        values.put("receiver",challenged);
        values.put("testID", testID);
        values.put("done", 0);
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        long result = db.insert("Challenges", null, values);
        if (result != -1) {
            return true;
        }
        else {
            return false;
        }
    }


}
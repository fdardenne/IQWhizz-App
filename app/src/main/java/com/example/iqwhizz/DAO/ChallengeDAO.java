package com.example.iqwhizz.DAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Challenge;

public class ChallengeDAO {

    private ChallengeDAO() {}

    /**
     * récupère les défis lancés a username qu'il na pas encore réalisés
     * @param username
     * @return la liste des défis
     */
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


}

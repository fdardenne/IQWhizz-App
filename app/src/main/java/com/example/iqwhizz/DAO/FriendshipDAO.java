package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Friendship;

public class FriendshipDAO {

    private FriendshipDAO() {}

    /*
    return true if the request is valid and added to the database
    return false if the request is invalid and not added to the database
    AKA. addFriend()
     */
    public static boolean sendFriendRequest(String sender, String receiver) {
        ContentValues values = new ContentValues();
        values.put("sender", sender);
        values.put("receiver", receiver);
        values.put("request_date", System.currentTimeMillis()/1000);
        values.put("acceptance_date", 0);
        values.put("isAccepted", 0);
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        long result = db.insert("Users", null, values);
        if (result != -1) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
     * Accept the request made by the sender and received by the receiver
     * return false if nothing matched or if the request has already been accepted and true otherwise
     */
    public static boolean acceptFriendRequest(String sender, String receiver) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE sender=\""+sender+"\" AND receiver=\""+receiver+"\"", null);
        cursor.moveToFirst();
        if (cursor.getCount()==0 || cursor.getInt(4)==1) {
            return false;
        }
        else {
            ContentValues updatedValues = new ContentValues();
            updatedValues.put("acceptance_date", System.currentTimeMillis()/1000);
            updatedValues.put("isAccepted", 1);
            db = DatabaseHelper.getWritableDb();
            db.update("Friendships", updatedValues, "sender=? AND receiver=?", new String[] {sender, receiver});
            return true;
        }
    }

    /*
        ajoute un ami a l'utilisateur courant (écrit 1 ligne dans la db)
     */
    public static void addFriend(String username, String currentUser){
        sendFriendRequest(currentUser, username);
    }

    public static Friendship[] getAllSentRequests(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE sender=\""+user+"\"", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; cursor.moveToNext(); i++) {
            requests[i] = new Friendship(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    (cursor.getInt(4)==1) ? true : false
            );
        }
        return requests;
    }

    public static Friendship[] getAllReceivedRequests(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE receiver=\""+user+"\"", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; cursor.moveToNext(); i++) {
            requests[i] = new Friendship(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    (cursor.getInt(4)==1) ? true : false
            );
        }
        return requests;
    }

    public static Friendship[] getFriendList(String user) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE (sender=\""+user+"\" OR receiver=\""+user+"\") AND isAccepted=1", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i = 0; i<cursor.getCount(); i++) {
            requests[i] = new Friendship(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    (cursor.getInt(4)==1) ? true : false
            );
            cursor.moveToNext();
        }
        return requests;
    }

    /*
        récupère la liste des demandes d'ami attendant d'etre acceptées par les amis
     */
    public static Friendship[] getReceivedRequests(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE receiver=\""+user+"\" AND isAccepted=0", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; i<cursor.getCount(); i++) {
            requests[i] = new Friendship(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    (cursor.getInt(4)==1) ? true : false
            );
            cursor.moveToNext();
        }
        return requests;
    }

    /*
        récupère la liste des demandes d'ami attendant d'etre acceptées par currentUser
     */
    public static Friendship[] getSentRequests(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE sender=\""+user+"\" AND isAccepted=0", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; i<cursor.getCount(); i++) {
            requests[i] = new Friendship(
                    cursor.getString(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    cursor.getInt(3),
                    (cursor.getInt(4)==1) ? true : false
            );
            cursor.moveToNext();
        }
        return requests;
    }
}

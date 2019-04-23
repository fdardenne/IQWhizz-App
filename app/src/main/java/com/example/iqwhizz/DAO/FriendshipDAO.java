package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.Friendship;

import java.util.ArrayList;

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
        ajoute un ami a l'utilisateur courant (écrit 1 ligne dans la db)
     */
    public static void addFriend(String username, String currentUser){
        sendFriendRequest(currentUser, username);
    }

    private static Friendship[] getSentRequest(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE sender=\""+user+"\"", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; cursor.moveToNext(); i++) {
            requests[i] = new Friendship(cursor.getString(0), cursor.getString(1), cursor.getInt(2));
        }
        return requests;
    }

    private static Friendship[] getReceivedRequest(String user){
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Friendships WHERE receiver=\""+user+"\"", null);
        cursor.moveToFirst();
        Friendship[] requests = new Friendship[cursor.getCount()];
        for(int i =0; cursor.moveToNext(); i++) {
            requests[i] = new Friendship(cursor.getString(0), cursor.getString(1), cursor.getInt(2));
        }
        return requests;
    }

    /*
        récupère la liste des demandes d'ami attendant d'etre acceptées par les amis
     */
    public static Friendship[] getPendingRequests(String currentUser){
        Friendship[] sent = getSentRequest(currentUser);
        Friendship[] received = getReceivedRequest(currentUser);
        ArrayList<Friendship> pending = new ArrayList<>();
        for (int i=0; i<sent.length; i++) {
            boolean found = false;
            for(int j=0; j<received.length; j++) {
                if (received[j].getSender().equals(sent[i].getReceiver())) {
                    found=true;
                }
            }
            if (!found) {
                pending.add(sent[i]);
            }
        }
        return (Friendship[]) pending.toArray();
    }

    /*
        récupère la liste des demandes d'ami attendant d'etre acceptées par currentUser
     */
    public static Friendship[] getMyPendingRequests(String currentUser){
        Friendship[] sent = getSentRequest(currentUser);
        Friendship[] received = getReceivedRequest(currentUser);
        ArrayList<Friendship> pending = new ArrayList<>();
        for (int i=0; i<received.length; i++) {
            boolean found = false;
            for(int j=0; j<sent.length; j++) {
                if (received[i].getSender().equals(sent[j].getReceiver())) {
                    found=true;
                }
            }
            if (!found) {
                pending.add(received[i]);
            }
        }
        return (Friendship[]) pending.toArray();
    }
}

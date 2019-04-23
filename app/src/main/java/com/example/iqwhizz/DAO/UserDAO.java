package com.example.iqwhizz.DAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.iqwhizz.Objects.User;

public class UserDAO {
    private UserDAO() {}

    public static User getUser(String username, String password) {
        //DatabaseHelper helper = DatabaseHelper.getDbHelper();
        //SQLiteDatabase db = helper.getReadableDatabase();
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username = \"" + username + "\"", null);

        if (cursor.moveToFirst()) {
            String name = cursor.getString(0);
            String pwd = cursor.getString(1);
            String lang = cursor.getString(2);
            int birth_d = cursor.getInt(3);
            String mail = cursor.getString(4);
            int reg_d = cursor.getInt(5);
            int last_connection = cursor.getInt(6);
            byte[] profile_pic = cursor.getBlob(7);
            if (password.equals(pwd)) {
                return new User(name, pwd, lang, mail, birth_d, profile_pic, last_connection, reg_d);
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }

    public static boolean userExists(String username) {
        SQLiteDatabase db = DatabaseHelper.getReadableDb();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username = \"" + username + "\"", null);
        if (cursor.moveToFirst()) {
            return true;
        }
        else {
            return false;
        }
    }

    /*
    return the newly created User or null if a problem occured
     */
    public static boolean createUser(String name, String pwd, String mail, String lang, int birth_d, int reg_d, int last_co, byte[] profile_pic) {
        ContentValues values = new ContentValues();
        values.put("username", name);
        values.put("password", pwd);
        values.put("language", lang);
        values.put("birth_date", birth_d);
        values.put("mail", mail);
        values.put("registration_date", reg_d);
        values.put("last_connection", last_co);
        values.put("profile_picture", profile_pic);
        //DatabaseHelper helper = DatabaseHelper.getDbHelper();
        //SQLiteDatabase db = helper.getWritableDatabase();
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        long result = db.insert("Users", null, values);
        if (result != -1) {
            return true;
        }
        else {
            return false;
        }
    }

}

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

    public static boolean disconnectUser(String username) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues values = new ContentValues();
        values.put("last_connection", System.currentTimeMillis()/1000);
        int rows = db.update("Users", values, "username=?", new String[]{username});
        return rows==1;
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
        return true if the creation succeeds and false otherwise
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
    return a list conatining all the users in the db
    */

    public static boolean updatePassword(String username, String newPwd) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("password", newPwd);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean updateEmail(String username, String mail) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("mail", mail);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean updateLanguage(String username, String lang) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("language", lang);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean updateBirthDate(String username, int birth_date) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("birth_date", birth_date);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }

    public static boolean updateProfilePicture(String username, byte[] profile_pic) {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("profile_picture", profile_pic);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }


    public static boolean updateLatCoDate(String username, int date)
    {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        ContentValues value = new ContentValues();
        value.put("last_connection", date);
        int rows = db.update("Users", value, "username=?", new String[]{username});
        if (rows!=1) {
            return false;
        }
        else {
            return true;
        }
    }

}

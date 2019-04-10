package com.example.iqwhizz;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsersDAO {
    private UsersDAO() {}

    public static User getUser(String username, String password, Context context) {
        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(context);
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Users WHERE username = '" + username + "'", null);

        if (cursor.moveToFirst()) {
            String usern = cursor.getString(0);
            String pwd = cursor.getString(1);
            String lang = cursor.getString(2);
            int birth_date = cursor.getInt(3);
            String mail = cursor.getString(4);
            int registration_date = cursor.getInt(5);
            String profile_picture = cursor.getString(6);
            if (password.equals(pwd)) {
                return new User(usern, pwd, lang);
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    public static User createUser(String usern, String pwd, String mail, String lang, int birth_d, int insc_d, int last_co, String pp, Context context) {
        ContentValues values = new ContentValues();
        values.put("username", usern);
        values.put("password", pwd);
        values.put("language", lang);
        values.put("birth_date", birth_d);
        values.put("mail", mail);
        values.put("registration_date", insc_d);
        //values.put("last_connection", last_co);
        values.put("profile_picture", pp);
        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(context);
        SQLiteDatabase db = helper.getWritableDatabase();
        db.insert("Users", null, values);
        return UsersDAO.getUser(usern,pwd, context);
    }
}

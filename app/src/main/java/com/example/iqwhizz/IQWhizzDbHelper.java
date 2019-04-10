package com.example.iqwhizz;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.IOException;
import java.io.InputStream;

public class IQWhizzDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "IQWhizz.db";
    private static final int DATABASE_VERSION = 1;
    private static String[] SQL_scripts = new String[3];
    private static IQWhizzDbHelper dbHelper = null;
    private static final String SQL_CREATION =
            "create table Users(username char(25) not null primary key," +
                    " password char(16) not null," +
                    " language char(25) not null," +
                    " birth_date int not null," +
                    " mail char(25) not null," +
                    " registration_date int not null," +
                    " profile_picture blob)";
    private static final String SQL_INSERTION =
            "insert into Users values ('name', 'pwd', 'en', 915000000, 'mail@mail.be', 915000000, 'img.png')";
    private static final String SQL_DROPS =
            "drop table if exists Users";


    private IQWhizzDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        //SQLinit(context);
    }
    public static IQWhizzDbHelper getDbHelper(Context context) {
        if (dbHelper == null) {
            dbHelper = new IQWhizzDbHelper(context);
        }
        return dbHelper;
    }

    private void SQLinit(Context context) {
        String[] files = {"IQWhizz_database_creation.sql", "IQWhizz_database_insertion.sql", "IQWhizz_database_drops.sql"};
        //String[] vars = {SQL_CREATION, SQL_INSERT, SQL_DROPS};
        for(int i=0; i<files.length; i++) {
            try {
                AssetManager am = context.getAssets();
                InputStream is = am.open(files[i]);
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                SQL_scripts[i] = new String(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SQL_scripts[0] = "PRAGMA foreign_keys = ON;\n" +
                "CREATE TABLE Users\n" +
                "(\n" +
                "  username         char(25)  not null primary key,\n" +
                "  password         char(255) not null,\n" +
                "  language         char(2)   not null default 'en',\n" +
                "  birth_date       int       not null,\n" +
                "  mail             char(255) not null unique,\n" +
                "  inscription_date int       not null,\n" +
                "  last_connection int not null default current_timestamp,\n" +
                "  profile_picture  char(255) -- normalement c'est un blob\n" +
                ");";
        SQL_scripts[1] = "INSERT INTO Users VALUES ('Hadrien', 'password', 'fr', strftime('%s','1999-08-16'),\n" +
                "'mail@mail.be',strftime('%s','2019-02-18'), strftime('%s', 'now'), 'image.png');";
        SQL_scripts[2] = "DROP TABLE IF EXISTS Users;";
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATION);
        db.execSQL(SQL_INSERTION);
        //db.execSQL(SQL_scripts[0]);
        //db.execSQL(SQL_scripts[1]);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DROPS);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

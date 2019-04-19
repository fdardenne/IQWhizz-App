package com.example.iqwhizz.DAO;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.iqwhizz.AppContextProvider;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "IQWhizz.db";
    private static final int DATABASE_VERSION = 1;
    private static DatabaseHelper dbHelper = null;
    private static final String[] SQLfiles = {
            "IQWhizzDB_creation.sql",
            "IQWhizzDB_insertion.sql",
            "IQWhizzDB_drops.sql"
    };

    private DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    private static DatabaseHelper getDbHelper() {
        if (dbHelper == null) {
            dbHelper = new DatabaseHelper(AppContextProvider.getContext());
        }
        return dbHelper;
    }

    public static SQLiteDatabase getWritableDb() {
        DatabaseHelper helper = getDbHelper();
        return helper.getWritableDatabase();
    }

    public static SQLiteDatabase getReadableDb() {
        DatabaseHelper helper = getDbHelper();
        return helper.getReadableDatabase();
    }



    private void execSQLfile(int file, SQLiteDatabase db) {
        try {
            AssetManager am = AppContextProvider.getContext().getAssets();
            Scanner scan = new Scanner(am.open(SQLfiles[file]));
            scan.useDelimiter(Pattern.compile(";\n"));
            while (scan.hasNext()) {
                String SQL = scan.next();
                SQL = SQL.replace("\n", "");
                db.execSQL(SQL);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void recreateDB() {
        SQLiteDatabase db = DatabaseHelper.getWritableDb();
        DatabaseHelper helper = getDbHelper();
        helper.dropAllTables(db);
        helper.onCreate(db);
    }

    private void dropAllTables(SQLiteDatabase db) {
        execSQLfile(2,db);
    }

    private static void deletedDB() {
        AppContextProvider.getContext().deleteDatabase(DATABASE_NAME);
        Log.d("Hadrien's Tests", "The DB has been successfully deleted.");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        execSQLfile(0,db);
        execSQLfile(1,db);
        Log.d("Hadrien's Tests", "DB creation -> OK");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        execSQLfile(2, db);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

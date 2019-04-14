package com.example.iqwhizz;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class IQWhizzDbHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "IQWhizz.db";
    private static final int DATABASE_VERSION = 1;
    private static IQWhizzDbHelper dbHelper = null;
    private static final String[] SQLfiles = {
            "IQWhizzDB_creation.sql",
            "IQWhizzDB_insertion.sql",
            "IQWhizzDB_drops.sql"
    };

    private IQWhizzDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public static IQWhizzDbHelper getDbHelper(Context context) {
        if (dbHelper == null) {
            dbHelper = new IQWhizzDbHelper(context);
        }
        return dbHelper;
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

    @Override
    public void onCreate(SQLiteDatabase db) {
        execSQLfile(0,db);
        execSQLfile(1,db);
        Log.d("MyTest", "DB creation is OK");
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

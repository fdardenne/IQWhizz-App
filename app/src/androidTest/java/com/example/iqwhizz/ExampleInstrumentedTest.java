package com.example.iqwhizz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.iqwhizz.DAO.DatabaseHelper;
import com.example.iqwhizz.DAO.TestDAO;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private SQLiteDatabase db;

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.iqwhizz", appContext.getPackageName());
    }


    @Test
    public void generateTest() {
        try {
            DatabaseHelper.recreateDB();
            com.example.iqwhizz.Objects.Test test1 = TestDAO.generateTest("logique", "court");
            com.example.iqwhizz.Objects.Test test2 = TestDAO.generateTest("reflexion", "court");
            com.example.iqwhizz.Objects.Test test3 = TestDAO.getTest(7);
            com.example.iqwhizz.Objects.Test test4 = TestDAO.getTest(8);


            SQLiteDatabase db = DatabaseHelper.getReadableDb();
            Cursor cursor = db.rawQuery("SELECT * FROM Tests WHERE testID = " + test1.getTestID() + " OR testID = " + test2.getTestID(), null);
            assertEquals(2,cursor.getCount());
            cursor.moveToFirst();
            Log.d("Database Tests - Login Activity", "ID test1 via DB : "+cursor.getInt(0));
            Log.d("Hadrien's Tests", "ID test1 via Obj : "+test1.getTestID());
            Log.d("Hadrien's Tests", "ID test1 via getTest : "+test3.getTestID());
            assertEquals(test1.getTestID(), cursor.getInt(0));
            assertEquals(test1.getTestID(), test3.getTestID());
            cursor.moveToNext();
            Log.d("Hadrien's Tests", "ID test2 via DB : "+cursor.getString(0));
            Log.d("Hadrien's Tests", "ID test2 via Obj : "+test2.getTestID());
            Log.d("Hadrien's Tests", "ID test2 via getTest : "+test4.getTestID());
            assertEquals(test2.getTestID(), cursor.getInt(0));
            assertEquals(test2.getTestID(), test4.getTestID());
        }
        catch(SQLiteException e) {
            assert(false);
        }
    }
}

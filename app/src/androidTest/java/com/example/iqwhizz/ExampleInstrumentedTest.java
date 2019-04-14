package com.example.iqwhizz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private SQLiteDatabase db;
    private SQLiteOpenHelper helper;
    /*
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.iqwhizz", appContext.getPackageName());
    }
    */

    @Before
    public void createDb() {
        helper = IQWhizzDbHelper.getDbHelper(AppContextProvider.getContext());
        db = helper.getReadableDatabase();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void generateTest() {
        try {
            com.example.iqwhizz.Test test1 = TestDAO.generateTest("Logique", "court");
            com.example.iqwhizz.Test test2 = TestDAO.generateTest("Reflexion", "court");

            Cursor cursor = db.rawQuery("SELECT * FROM Tests WHERE testID = " + test1.getTestID() + " OR testID = " + test2.getTestID(), null);
            cursor.moveToFirst();
            Log.d("UnitTests", "ID test1 via DB : "+cursor.getString(0));
            Log.d("UnitTests", "ID test1 via Obj : "+test1.getTestID());
            cursor.moveToNext();
            Log.d("UnitTests", "ID test2 via DB : "+cursor.getString(0));
            Log.d("UnitTests", "ID test2 via Obj : "+test2.getTestID());
            assertNotNull(db);
        }
        catch(SQLiteException e) {
            assert(false);
        }
    }
}

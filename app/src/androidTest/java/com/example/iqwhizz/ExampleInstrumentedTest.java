package com.example.iqwhizz;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

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
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.iqwhizz", appContext.getPackageName());
    }

    @Test
    public void onCreateDb() {
        try {
            //InstrumentationRegistry.getContext().deleteDatabase(IQWhizzDbHelper.DATABASE_NAME);
            IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(InstrumentationRegistry.getTargetContext());
            SQLiteDatabase db = helper.getReadableDatabase();

            assertNotNull(db);
        }
        catch(SQLiteException e) {
            assert(false);
        }
    }
}

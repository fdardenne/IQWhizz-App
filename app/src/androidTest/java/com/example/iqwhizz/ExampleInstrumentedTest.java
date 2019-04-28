package com.example.iqwhizz;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.iqwhizz.DAO.DatabaseHelper;
import com.example.iqwhizz.DAO.FriendshipDAO;
import com.example.iqwhizz.DAO.QuestionDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.DAO.UserDAO;
import com.example.iqwhizz.Objects.Answer;
import com.example.iqwhizz.Objects.Friendship;
import com.example.iqwhizz.Objects.Question;
import com.example.iqwhizz.Objects.User;

import org.junit.After;
import org.junit.Before;
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

    @Before
    public void beforeMethod() {
        DatabaseHelper.recreateDB();
        User.connectUser("Hadrien", "lutinPlop");
        generatingTest();
    }

    public void generatingTest() {
        try {
            boolean boolTest1 = TestDAO.generateTest("logique", "court");
            boolean boolTest2 = TestDAO.generateTest("reflexion", "court");
            com.example.iqwhizz.Objects.Test test1 = TestDAO.getTest(1);
            com.example.iqwhizz.Objects.Test test2 = TestDAO.getTest(2);
            boolean[] bools = {boolTest1, boolTest2};
            for (boolean bool : bools) {
                assertTrue(bool);
            }

            db = DatabaseHelper.getReadableDb();
            Cursor cursor = db.rawQuery("SELECT * FROM Tests WHERE testID = " + test1.getTestID() + " OR testID = " + test2.getTestID(), null);
            assertEquals(2,cursor.getCount());
            cursor.moveToFirst();
            Log.d("Testing generateTest", "ID test1 via DB : "+cursor.getInt(0));
            Log.d("Testing generateTest", "ID test1 via Obj : "+test1.getTestID());
            assertEquals(test1.getTestID(), cursor.getInt(0));
            cursor.moveToNext();
            Log.d("Testing generateTest", "ID test2 via DB : "+cursor.getString(0));
            Log.d("Testing generateTest", "ID test2 via Obj : "+test2.getTestID());
            assertEquals(test2.getTestID(), cursor.getInt(0));
        }
        catch(SQLiteException e) {
            assert(false);
        }
    }

    @After
    public void afterMethod() {
        User.disconnectUser();
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.iqwhizz", appContext.getPackageName());
    }


    @Test
    public void getTest() {
        try {

            com.example.iqwhizz.Objects.Test test1 = TestDAO.getTest(1);
            com.example.iqwhizz.Objects.Test test2 = TestDAO.getTest(2);
            boolean exeTest1 = TestDAO.executeTest(test1);
            boolean exeTest2 = TestDAO.executeTest(test2);
            boolean[] bools = {exeTest1, exeTest2};
            for (boolean bool : bools) {
                assertTrue(bool);
            }

            db = DatabaseHelper.getReadableDb();

            Log.d("TestDAO testing", "Testing test1 ...");
            assertEquals(1,test1.getTestID());
            assertEquals(1,test1.getExecutionID());
            //assertEquals(2, test1.getCurrentQuestionID());
            Answer answer = QuestionDAO.getQuestion(test1.getCurrentQuestionID()).getAnswers()[0];
            Answer rightAns = QuestionDAO.getQuestion(test1.getCurrentQuestionID()).getRightAnswer();
            boolean succeed = test1.answerToQuestion(answer.getAnswerID(), 30);
            if (succeed) {
                assertEquals(answer.getAnswerID(), rightAns.getAnswerID());
            }
            else {
                assertNotEquals(answer.getAnswerID(), rightAns.getAnswerID());
            }
            Cursor cursor = db.rawQuery("SELECT * FROM SelectedAnswers WHERE executionID="+test1.getExecutionID(),null);
            cursor.moveToFirst();
            assertEquals(1, cursor.getCount());
            Log.d("TestDAO testing", "answerID of the answer that has been given : "+cursor.getInt(3));
            Question question = test1.nextQuestion();
            cursor = db.rawQuery("SELECT * FROM TestExecutions", null);
            cursor.moveToFirst();
            try {
                Thread.sleep(5000);
            }
            catch (Exception e) {
                Log.d("Sleep", "failed");
            }
            Log.d("TestDAO testing", "Testing finished for test1.");

        }
        catch(SQLiteException e) {
            assert(false);
        }
    }

    @Test
    public void answerToQuestions() {

    }

    @Test
    public void createUser() {
        Log.d("User creation testing", "Creating the user ...");
        boolean succeeded = UserDAO.createUser("test_usr", "test_pwd", "test_mail", "test_lang", 0, 0, 0, new byte[]{0, 0});
        assertTrue(succeeded);
        User test_usr = UserDAO.getUser("test_usr", "test_pwd");
        assertNotNull(test_usr);
        Log.d("User creation testing", "The creation was successful.");
    }


    @Test
    public void getFriendList() {
        try {
            Friendship friendlistFromDB[] = FriendshipDAO.getFriendList("Hadrien");
            Friendship pendingsFromDB[] = FriendshipDAO.getSentRequests("Florent");
            Friendship myPendingsFromDB[] = FriendshipDAO.getReceivedRequests("Florent");
            Log.d("Database Tests - FriendshipDAO", "getFriendList()");
            for(Friendship friendship : friendlistFromDB) {
                Log.d("Database Tests - FriendshipDAO",
                        "Sender : " + friendship.getSender() +
                                " Receiver : " + friendship.getReceiver() +
                                " Request date : " + friendship.getRequest_date() +
                                " is Accepeted ? " + ((friendship.isAccepted()) ? "True" : "False") +
                                ((friendship.isAccepted()) ? (" Accepance date : " + friendship.getAcceptance_date()) : "")
                );
            }
            Log.d("Database Tests - FriendshipDAO", "getPendingRequests()");
            for(Friendship friendship : myPendingsFromDB) {
                Log.d("Database Tests - FriendshipDAO",
                        "Sender : " + friendship.getSender() +
                                " Receiver : " + friendship.getReceiver() +
                                " Request date : " + friendship.getRequest_date() +
                                " is Accepeted ? " + ((friendship.isAccepted()) ? "True" : "False") +
                                ((friendship.isAccepted()) ? (" Accepance date : " + friendship.getAcceptance_date()) : "")
                );
            }
            Log.d("Database Tests - FriendshipDAO", "getMyPendingRequests()");
            for(Friendship friendship : pendingsFromDB) {
                Log.d("Database Tests - FriendshipDAO",
                        "Sender : " + friendship.getSender() +
                                " Receiver : " + friendship.getReceiver() +
                                " Request date : " + friendship.getRequest_date() +
                                " is Accepeted ? " + ((friendship.isAccepted()) ? "True" : "False") +
                                ((friendship.isAccepted()) ? (" Accepance date : " + friendship.getAcceptance_date()) : "")
                );
            }
            Log.d("Database Tests - FriendshipDAO", "Finished !");

        }
        catch(SQLiteException e) {
            assert(false);
        }
    }
}

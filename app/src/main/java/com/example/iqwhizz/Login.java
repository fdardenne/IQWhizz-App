package com.example.iqwhizz;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Login extends AppCompatActivity {

    //Pour avoir accès aux composants sans les instancier a chaque fois
    private TextView errormessage;

    private Button login;
    private TextView register;

    private TextView username;
    private TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
        NE PAS SUPPRIMER -> TEST DE LA DB

        //db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "IQWhizz").allowMainThreadQueries().build();
        User user = new User("name", "pwd", "lang");
        //db.userDao().insertUser(user);
        db.userDao().getUser("name").observe(this, new android.arch.lifecycle.Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {

            }
        });
        User user2 = db.userDao().getUser("name").getValue();
        Log.d("USER", user2.username);
        User user1 = UsersDAO.createUser("test", "testPwd","mail@mail.be", "en",1000000000,1000000000,1000000000,"profile picture", getApplicationContext());
        User user2 = UsersDAO.getUser("name", "pwd", getApplicationContext());
        */
        com.example.iqwhizz.Test test1 = TestDAO.generateTest("Logique", "court");
        com.example.iqwhizz.Test test2 = TestDAO.generateTest("Reflexion", "court");

        IQWhizzDbHelper helper = IQWhizzDbHelper.getDbHelper(this.getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Tests WHERE testID = " + test1.getTestID() + " OR testID = " + test2.getTestID(), null);
        cursor.moveToFirst();
        Log.d("UnitTests", "ID test1 via DB : "+cursor.getString(0));
        Log.d("UnitTests", "ID test1 via Obj : "+test1.getTestID());
        cursor.moveToNext();
        Log.d("UnitTests", "ID test2 via DB : "+cursor.getString(0));
        Log.d("UnitTests", "ID test2 via Obj : "+test2.getTestID());

        setContentView(R.layout.login);

        errormessage = findViewById(R.id.error_message);
        login = findViewById(R.id.login);
        register = findViewById(R.id.register);

        setUpListener();
    }

    private void setUpListener(){

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                register();
            }
        });

        //Action a faire quand on clique sur le bouton
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connectUser();
            }
        });
    }

    private void connectUser(){
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        //TODO: Créer la classe User
        //TODO: Verifier dans la DB si le login est bon
        //TODO: Si le login est bon: Stocker le username dans le singleton User
        if(username.getText().toString().equals("") && password.getText().toString().equals("")){
            Intent intentMenu = new Intent(this, Menu.class);
            Log.i("TEST", username.getText() + " connected");
            errormessage.setText("");
            startActivity(intentMenu);
            this.finish();
        }else{
            errormessage.setText("Vos identifiants ne correspondant pas à notre base de donnée");
            Log.i("TEST", username.getText() + " login failed");
        }
    }

    private void register(){
        Intent intentRegister = new Intent(this, Register.class);
        startActivity(intentRegister);


    }
}

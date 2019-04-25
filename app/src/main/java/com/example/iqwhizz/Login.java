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

import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.DAO.DatabaseHelper;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.User;


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

        String userStr = username.getText().toString();
        String pwdStr = password.getText().toString();
        if(User.connectUser(userStr, pwdStr)){
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

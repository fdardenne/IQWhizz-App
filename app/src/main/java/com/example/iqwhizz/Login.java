package com.example.iqwhizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

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

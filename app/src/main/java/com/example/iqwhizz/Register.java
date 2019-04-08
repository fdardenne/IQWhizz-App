package com.example.iqwhizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.util.Calendar;
import java.util.Date;

public class Register extends AppCompatActivity {

    EditText username;
    EditText password;
    EditText confirmPassword;
    EditText email;
    EditText birthdate;
    TextView errormessage;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        register = findViewById(R.id.register);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }

    private void registerUser(){

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.password_confirm);
        email = findViewById(R.id.email);
        birthdate = findViewById(R.id.birthday);
        errormessage = findViewById(R.id.error_message);
        String[] birthdate_array = birthdate.getText().toString().split("/");

        //A utilier pour les verifications et l'insertion
        String username_str = username.getText().toString().toLowerCase();


        //TODO vérifier si l'utilisateur existe déjà dans la db
        if(username.getText().toString().equals("fdardenne")){
            errormessage.setText("L'utilisateur existe déjà");
        }

        //Vérification ok, ne pas toucher
        else if(!confirmPassword.getText().toString().equals(password.getText().toString())){
            errormessage.setText("Les deux mot de passe ne correspondent pas");
        }
        else if(password.length() < 6){
            errormessage.setText("Le mot de passe doit comporter plus de 5 caractère");
        }
        else if(birthdate_array.length != 3 || !(Integer.parseInt(birthdate_array[0]) <= 31) || !(Integer.parseInt(birthdate_array[0]) >= 1) || !(Integer.parseInt(birthdate_array[1]) <= 12) ||  !(Integer.parseInt(birthdate_array[1]) >= 1) || !(Integer.parseInt(birthdate_array[2]) >= 1900) || !(Integer.parseInt(birthdate_array[2]) <  2019 )){
            errormessage.setText("La date n'est pas dans un bon format: dd/mm/yyyy");
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            errormessage.setText("L'email n'est pas dans un bon format: user@domain.be");

        }
        else{
            //TODO: Ici tout a été vérifié, introduire l'user dans la DB
            Intent intentMenu = new Intent(this, Menu.class);
            Log.i("TEST", username_str + " connected");
            errormessage.setText("");
            startActivity(intentMenu);
            this.finish();

        }


    }
}

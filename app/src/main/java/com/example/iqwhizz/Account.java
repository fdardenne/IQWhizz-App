package com.example.iqwhizz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iqwhizz.DAO.UserDAO;
import com.example.iqwhizz.Objects.User;

import java.util.Date;

public class Account extends AppCompatActivity {

    TextView username;
    EditText password;
    EditText confirmPassword;
    EditText email;
    EditText birthdate;
    TextView errormessage;
    Button modify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.language_account);
        //create a list of items for the spinner.
        String[] items = new String[]{"Francais", "English"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        User user = User.currentUser;
        Log.i("erreur",user.getMail());

        email = findViewById(R.id.email_account);
        email.setText(user.getMail());

        Log.i("erreur",user.getUsername());
        username = findViewById(R.id.username_account);
        username.setText(user.getUsername());

        birthdate = findViewById(R.id.birthday_account);
        birthdate.setText(Integer.toString(user.getBirthdate()));


        modify = findViewById(R.id.modify);
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifyUser();
            }
        });
    }

    private void modifyUser() {
        password = findViewById(R.id.password_account);
        confirmPassword = findViewById(R.id.password_confirm_account);
        email = findViewById(R.id.email_account);
        birthdate = findViewById(R.id.birthday_account);
        errormessage = findViewById(R.id.error_message_account);
        String[] birthdate_array = birthdate.getText().toString().split("/");

        User user = User.currentUser;

        //A utilier pour les verifications et l'insertion
        String username_str = username.getText().toString();
        String password_str = password.getText().toString();
        String email_str = email.getText().toString();
        String lang_str = "en"; //TODO
        int birth_d = 0; //TODO
        int reg_d = 0; //TODO
        int last_co = 0; //TODO
        byte[] profile_pic = null; //TODO


        //Vérification ok, ne pas toucher
        if(!confirmPassword.getText().toString().equals(password.getText().toString())){
            errormessage.setText("Les deux mot de passe ne correspondent pas");
        }
        else if(!(password.length() >= 6) && !(password.length() == 0)){
            errormessage.setText("Le mot de passe doit comporter plus de 5 caractère");
        }
        else if(birthdate_array.length != 3 || !(Integer.parseInt(birthdate_array[0]) <= 31) || !(Integer.parseInt(birthdate_array[0]) >= 1) || !(Integer.parseInt(birthdate_array[1]) <= 12) ||  !(Integer.parseInt(birthdate_array[1]) >= 1) || !(Integer.parseInt(birthdate_array[2]) >= 1900) || !(Integer.parseInt(birthdate_array[2]) <  2019 )){
            errormessage.setText("La date n'est pas dans un bon format: dd/mm/yyyy");
        }else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()){
            errormessage.setText("L'email n'est pas dans un bon format: user@domain.be");

        }
        else{
            int duration = Toast.LENGTH_SHORT;
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "Modifié !", duration);
            toast.show();

            if(!password_str.equals("")){
                UserDAO.updateBirthDate(username_str,birth_d);
                UserDAO.updateEmail(username_str,email_str);
                UserDAO.updateLanguage(username_str,lang_str);
                UserDAO.updateProfilePicture(username_str,profile_pic);

            }else{
                UserDAO.updateBirthDate(username_str,birth_d);
                UserDAO.updateEmail(username_str,email_str);
                UserDAO.updateLanguage(username_str,lang_str);
                UserDAO.updateProfilePicture(username_str,profile_pic);
                UserDAO.updatePassword(username_str,password_str);
            }
    



            errormessage.setText("");
            Intent refresh = new Intent(this, Account.class);
            startActivity(refresh);
            this.finish();

        }
    }
}

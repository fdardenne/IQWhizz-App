package com.example.iqwhizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import com.example.iqwhizz.Objects.User;
public class Menu extends AppCompatActivity {

    CardView play;
    CardView resume;
    CardView stats;
    CardView friends;
    CardView account;
    CardView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        play = findViewById(R.id.play);
        resume = findViewById(R.id.resume);
        stats = findViewById(R.id.stats);
        friends = findViewById(R.id.friends);
        account = findViewById(R.id.account);
        logout = findViewById(R.id.logout);

        setupListener();

    }

    private void setupListener(){

        stats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                statsIntent();
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutIntent();
            }
        });

        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountIntent();
            }
        });



    }

    private void statsIntent(){
        Intent intentStats = new Intent(this, Stats.class);
        startActivity(intentStats);
    }

    private void accountIntent(){
        Intent intentAccount = new Intent(this, Account.class);
        startActivity(intentAccount);
    }

    private void logoutIntent(){
        Intent intentLogin = new Intent(this, Login.class);
        User.currentUser = null;
        startActivity(intentLogin);
        this.finish();
    }
}

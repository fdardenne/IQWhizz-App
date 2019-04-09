package com.example.iqwhizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

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


    }

    private void statsIntent(){
        Intent intentStats = new Intent(this, Stats.class);
        startActivity(intentStats);
    }

    private void logoutIntent(){
        Intent intentLogin = new Intent(this, Login.class);
        //TODO: Déconnecter l'User, vider le Singleton pour la préparation d'une possible nouvelle connection
        startActivity(intentLogin);
        this.finish();
    }
}

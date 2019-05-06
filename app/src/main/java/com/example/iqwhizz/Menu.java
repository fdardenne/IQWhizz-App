package com.example.iqwhizz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;
public class Menu extends AppCompatActivity {

    CardView play;
    CardView resume;
    CardView stats;
    CardView friends;
    CardView account;
    CardView logout;
    CardView insert;
    CardView duel;

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
        insert = findViewById(R.id.insert_question);
        duel = findViewById(R.id.challengeCard);


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
        friends.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                friendsIntent();
            }
        });
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accountIntent();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playIntent();
            }
        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertIntent();
            }
        });
        duel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duelIntent();
            }
        });

        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resumeIntent();
            }
        });



    }

    private void resumeIntent(){
        Intent resumeIntent = new Intent(this, Challenge.class);
        startActivity(resumeIntent);
    }
    private void duelIntent(){
        Intent intentDuel = new Intent(this, Duel.class);
        startActivity(intentDuel);
    }


    private void insertIntent(){
        Intent intentInsert = new Intent(this, AddQuestion.class);
        startActivity(intentInsert);
    }

    private void playIntent(){
            Intent intentPlay = new Intent(this, ChallengeInit.class);
            startActivity(intentPlay);
        }

    private void statsIntent(){
        Intent intentStats = new Intent(this, Stats.class);
        startActivity(intentStats);
    }

    private void accountIntent(){
        Intent intentAccount = new Intent(this, Account.class);
        startActivity(intentAccount);
    }

    private void friendsIntent(){
        Intent intentFriends = new Intent(this, Friends.class);
        startActivity(intentFriends);
    }

    private void logoutIntent(){
        Intent intentLogin = new Intent(this, Login.class);
        User.currentUser = null;
        startActivity(intentLogin);
        this.finish();
    }
}

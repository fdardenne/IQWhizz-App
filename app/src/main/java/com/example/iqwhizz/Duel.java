package com.example.iqwhizz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.iqwhizz.DAO.ChallengeDAO;
import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Challenge;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Duel extends AppCompatActivity implements DuelAdapter.OnDuelListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Challenge[] list_challenge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duel);

        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Cliquer sur une partie pour avoir plus de détails !", duration);
        toast.show();

        String username = User.currentUser.getUsername();
        list_challenge = ChallengeDAO.getChallenge(username);


        if(list_challenge == null){
            list_challenge = new Challenge[0];
        }

        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_duel);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new DuelAdapter(list_challenge, this));


    }

    @Override
    public void onDuelClick(int position) {
        Challenge chal = list_challenge[position];
        Test t = TestDAO.getTest(chal.getTestID(), 0);

        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();


        if(chal.isDone()){
            Toast toast = Toast.makeText(context, "La partie est finie !", duration);
            toast.show();
            return;
        }
        if(chal.getChallenger().equals(User.currentUser.getUsername())){
            Toast toast = Toast.makeText(context, "En attente de l'adversaire...", duration);
            toast.show();
            return;
        }else{
            Intent challengeIntent = new Intent(this, com.example.iqwhizz.Challenge.class);
            challengeIntent.putExtra("testID", t.getTestID());
            challengeIntent.putExtra("type", t.getType());
            ChallengeDAO.doChallenge(User.currentUser.getUsername(), chal.getChallenger());
            Toast toast = Toast.makeText(context, "Bon jeu !", duration);
            toast.show();
            startActivity(challengeIntent);
            this.finish();
        }
    }
}

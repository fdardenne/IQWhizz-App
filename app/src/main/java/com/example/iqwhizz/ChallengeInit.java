package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class ChallengeInit extends AppCompatActivity {

    Spinner category;
    Spinner type;
    Switch switch_friend;
    EditText username_friend;
    Button play;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_init);

        category = findViewById(R.id.category);
        type = findViewById(R.id.type);
        switch_friend = findViewById(R.id.switch_friend);
        username_friend = findViewById(R.id.friend_username);
        username_friend.setInputType(InputType.TYPE_NULL);
        username_friend.setFocusable(false);
        play = findViewById(R.id.new_challenge);

        String[] items = new String[]{"Aléatoire", "Math", "Puzzle", "Culture générale"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        category.setAdapter(adapter);

        String[] items2 = new String[]{"Court (5 questions)", "Long (40 questions)"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items2);
        type.setAdapter(adapter2);

        switch_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username_friend.setInputType(InputType.TYPE_CLASS_TEXT);
                username_friend.setFocusableInTouchMode(true);
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                play_game();
            }
        });
    }

    private void play_game() {

    }
}

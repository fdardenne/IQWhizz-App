package com.example.iqwhizz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Challenge extends AppCompatActivity {

    private TextView title;
    private TextView textQuestion;
    private TextView textAnswer1;
    private TextView textAnswer2;
    private TextView textAnswer3;
    private TextView textAnswer4;

    private CardView cardAnswer1;
    private CardView cardAnswer2;
    private CardView cardAnswer3;
    private CardView cardAnswer4;

    private byte maxNbQuestion;
    private byte currentNbQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //WIP
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge);
        String type = getIntent().getStringExtra("type");
        if(type.equals("Long (40 questions)")){
            maxNbQuestion = 40;
        }else{
            maxNbQuestion = 5;

        }


        currentNbQuestion = 1;
        String category = getIntent().getStringExtra("category");

        title = findViewById(R.id.questionNb);
        title.setText("Question #" + currentNbQuestion +"/" + maxNbQuestion );
        textQuestion = findViewById(R.id.question_text);
        textAnswer1 = findViewById(R.id.answer_text1);
        textAnswer2 = findViewById(R.id.answer_text2);
        textAnswer3 = findViewById(R.id.answer_text3);
        textAnswer4 = findViewById(R.id.answer_text4);

        cardAnswer1 = findViewById(R.id.answer_card1);
        cardAnswer2 = findViewById(R.id.answer_card2);
        cardAnswer3 = findViewById(R.id.answer_card3);
        cardAnswer4 = findViewById(R.id.answer_card4);

        textQuestion.setText("Question " + currentNbQuestion);
        textAnswer1.setText("réponse 1");
        textAnswer2.setText("réponse 2");
        textAnswer3.setText("réponse 3");
        textAnswer4.setText("réponse 4");

        setupListener();

    }

    private void setupListener(){

        cardAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(textAnswer1.getText().toString());
            }
        });
        cardAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(textAnswer2.getText().toString());
            }
        });
        cardAnswer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(textAnswer3.getText().toString());
            }
        });
        cardAnswer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answered(textAnswer4.getText().toString());
            }
        });

    }

    private void answered(String answer){
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, answer, duration);
        toast.show();

        next();

    }

    private void next() {
        currentNbQuestion++;
        title.setText("Question #" + currentNbQuestion +"/" + maxNbQuestion );

        if(currentNbQuestion>5){

            title.setText("WIP Résultat");
        }
    }
}

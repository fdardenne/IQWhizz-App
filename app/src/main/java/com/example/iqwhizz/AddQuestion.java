package com.example.iqwhizz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iqwhizz.DAO.QuestionDAO;
import com.example.iqwhizz.DAO.TestDAO;

import java.lang.reflect.Array;

public class AddQuestion extends AppCompatActivity {

    TextView error_message;
    EditText question;
    EditText answer1;
    EditText answer2;
    EditText answer3;
    EditText answer4;
    AutoCompleteTextView category;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        String[] categories = TestDAO.getPossibleCategories(0);

        error_message = findViewById(R.id.error_message_insert);
        question = findViewById(R.id.question_insert);
        answer1 = findViewById(R.id.answer_insert1);
        answer2 = findViewById(R.id.answer_insert2);
        answer3 = findViewById(R.id.answer_insert3);
        answer4 = findViewById(R.id.answer_insert4);

        category = findViewById(R.id.category_insert_a);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        category.setAdapter(adapter);
        insert = findViewById(R.id.insert);




        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertQuestion();
            }
        });
    }

    private void insertQuestion(){
        String question_str = question.getText().toString();
        String answer1_str = answer1.getText().toString();
        String answer2_str = answer2.getText().toString();
        String answer3_str = answer3.getText().toString();
        String answer4_str = answer4.getText().toString();
        String category_str = category.getText().toString();

        if(question_str.equals("") || answer1_str.equals("") || answer2_str.equals("") || answer3_str.equals("") || answer4_str.equals("") || category_str.equals("")){
            error_message.setText("Erreur : Aucun champ ne doit être vide");
            return;
        }

        QuestionDAO.createQuestion(question_str, answer1_str, answer2_str, answer3_str, answer4_str, 1, category_str);
        error_message.setText("");

        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "La question a été inséré !", duration);
        toast.show();


    }
}

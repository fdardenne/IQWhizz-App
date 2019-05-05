package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.iqwhizz.DAO.QuestionDAO;
import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Answer;
import com.example.iqwhizz.Objects.Question;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Result extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private Answer[] list_answer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int executedTestID = getIntent().getIntExtra("TestExecutionID", -1);
        list_answer = TestDAO.getSelectedAnswers(executedTestID);
        Log.d("TEST FLORENTT", list_answer.length + "");
        for(Answer a: list_answer){
            Log.d("TEST FLORENTT", a.getText() + "");
        }

        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_result);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new ResultAdapter(list_answer));


    }
}

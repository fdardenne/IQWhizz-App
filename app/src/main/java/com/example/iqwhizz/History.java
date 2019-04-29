package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.iqwhizz.DAO.TestDAO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class History extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<HashMap<String, String>> list_history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        list_history = new ArrayList<>();
        //TODO: DAO, faire comme en bas, pour chaque Test fait, il faut call add_history()

        add_history("24/04/19", "Random", "Long", "120");
        add_history("25/04/19", "Math", "Court", "110");




        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_history);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new HistoryAdapter(list_history));


    }

    private void add_history(String date, String category,String type, String score_QI ) {
        HashMap<String,String> temp = new HashMap<>();
        temp.put("date", date);
        temp.put("category", category);
        temp.put("type", "type: " + type);
        temp.put("score", "score: " + score_QI);
        list_history.add(temp);
    }
}

package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
        String username = User.currentUser.getUsername();
        if(TestDAO.getAllExecutedTest(username) != null) {
            int[] testIDs = TestDAO.getAllExecutedTest(username);
            int longueur = testIDs.length;
            for (int i = 0; i < longueur; i = i + 2) {
                Test letest = TestDAO.getTest(testIDs[i]);
                int date = testIDs[i + 1];
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String date1 = dateFormat.format(date);
                add_history(date1, letest.getCategory(), letest.getType(), Integer.toString(StatsDAO.getIQ(username, testIDs[i])));
            }
        }
        //add_history("24/04/19", "Random", "Long", "120");
        //add_history("25/04/19", "Math", "Court", "110");




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

package com.example.iqwhizz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class History extends AppCompatActivity implements HistoryAdapter.OnHistoryListener {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<HashMap<String, String>> list_history;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        int duration = Toast.LENGTH_LONG;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, "Cliquer sur une partie pour avoir plus de détails !", duration);
        toast.show();

        list_history = new ArrayList<>();
        String username = User.currentUser.getUsername();
        if(TestDAO.getAllExecutedTest(username) != null) {
            int[] execIDs = TestDAO.getAllExecutedTest(username);
            int longueur = execIDs.length;
            for (int i = 0; i < longueur; i = i + 2)
            {
                Test letest = TestDAO.getTest(execIDs[i], 0);
                long date = ( (long)execIDs[i + 1]*1000); // Bizarre non ?
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                String date1 = dateFormat.format(date);
                add_history(date1, letest.getCategory(), letest.getType(), Integer.toString(StatsDAO.getIQ(execIDs[i])), Integer.toString(execIDs[i]));
            }
        }

        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_history);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new HistoryAdapter(list_history, this));


    }

    private void add_history(String date, String category,String type, String score_QI, String execID) {
        HashMap<String,String> temp = new HashMap<>();
        temp.put("date", date);
        temp.put("category", category);
        temp.put("type", "type: " + type);
        temp.put("score", "score: " + score_QI);
        temp.put("execID", execID);
        list_history.add(temp);
    }

    @Override
    public void onHistoryClick(int position) {
        int execID = Integer.parseInt(list_history.get(position).get("execID"));

        Intent intent = new Intent(this, Result.class);
        intent.putExtra("TestExecutionID", execID);
        startActivity(intent);
    }
}

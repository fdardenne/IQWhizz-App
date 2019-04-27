package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class Friends extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> list_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        list_friend = new ArrayList<>();
        //TODO: DAO, faire comme en bas, pour chaque ami
        list_friend.add("Jean");
        list_friend.add("Pierre");


        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_friend);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new FriendAdapter(list_friend));
    }
}

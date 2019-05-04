package com.example.iqwhizz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.Objects.Friendship;
import com.example.iqwhizz.Objects.User;

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

        list_friend = Friendship.getFriendsUsername(User.currentUser.getUsername());
        for(String name: list_friend){
            Log.d("NAME", name);
        }
        Log.d("NAME", "" + list_friend.size());


        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_friend);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new FriendAdapter(list_friend));
    }
}

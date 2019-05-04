package com.example.iqwhizz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.iqwhizz.DAO.FriendshipDAO;
import com.example.iqwhizz.DAO.UserDAO;
import com.example.iqwhizz.Objects.Friendship;
import com.example.iqwhizz.Objects.User;

import java.util.ArrayList;

public class Friends extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> list_friend;
    private Button add_friend;
    private TextView text_friend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        add_friend = findViewById(R.id.add_friend);

        list_friend = Friendship.getFriendsUsername(User.currentUser.getUsername());

        add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });

        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler_friend);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new FriendAdapter(list_friend));
    }

    private void addFriend(){
        text_friend = findViewById(R.id.text_friend);
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();

        if(!UserDAO.userExists(text_friend.getText().toString())){

            Toast toast = Toast.makeText(context, "Cet utilisateur n'existe pas !", duration);
            toast.show();
            return;

        }else{
            Friendship[] friends = FriendshipDAO.getFriendList(User.currentUser.getUsername());
            Toast toast;
            for(Friendship f: friends){
                if((f.getReceiver().equals(text_friend.getText().toString()) || f.getSender().equals(text_friend.getText().toString())) ) {
                    //Friend found
                    if(f.isAccepted()){
                        toast = Toast.makeText(context, "Cet utilisateur est déjà dans vos amis !", duration);
                        toast.show();
                        return;
                    }else{
                        toast = Toast.makeText(context, "La requête a déjà été envoyé !", duration);
                        toast.show();
                        return;
                    }
                }
            }

            toast = Toast.makeText(context, "Une requête a été envoyé à " + text_friend.getText() + " !", duration);
            toast.show();
        }

    }
}

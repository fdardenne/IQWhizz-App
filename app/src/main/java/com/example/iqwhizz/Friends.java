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
    private ArrayList<String> friend_list;
    private ArrayList<String> sent_req;
    private ArrayList<String> received_req;
    private Button add_friend;
    private TextView text_friend;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private RecyclerView rv3;
    private FriendAdapter rv1_adapt;
    private FriendAdapter rv2_adapt;
    private FriendAdapter rv3_adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);

        add_friend = findViewById(R.id.add_friend);

        friend_list = Friendship.getFriendsUsername(User.currentUser.getUsername());
        sent_req = Friendship.getSentUsername(User.currentUser.getUsername());
        received_req = Friendship.getReceivedUsername(User.currentUser.getUsername());

        add_friend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFriend();
            }
        });
        /**
        rv1 = (RecyclerView) findViewById(R.id.recycler_result);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1_adapt = new FriendAdapter(friend_list);
        rv1.setAdapter(rv1_adapt);**/

        rv2 = (RecyclerView) findViewById(R.id.sent_requests);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2_adapt = new FriendAdapter(sent_req);
        rv2.setAdapter(rv2_adapt);

        rv3 = (RecyclerView) findViewById(R.id.received_requests);
        rv3.setLayoutManager(new LinearLayoutManager(this));
        rv3_adapt = new FriendAdapter(received_req);
        rv3.setAdapter(rv3_adapt);
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
            ArrayList<String> sent = Friendship.getSentUsername(User.currentUser.getUsername());
            ArrayList<String> received = Friendship.getReceivedUsername(User.currentUser.getUsername());
            ArrayList<String> friends = Friendship.getFriendsUsername(User.currentUser.getUsername());
            Toast toast;
            for(String f: friends){
                if((f.equals(text_friend.getText().toString()) || f.equals(text_friend.getText().toString())) ) {
                    toast = Toast.makeText(context, "Cet utilisateur est déjà dans vos amis !", duration);
                    toast.show();
                    return;
                }
            }

            for(String f: sent){
                if(f.equals(text_friend.getText().toString())) {
                    toast = Toast.makeText(context, "Vous avez déjà envoyé un requête à cette personne !", duration);
                    toast.show();
                    return;
                }
            }

            for(String f: received){
                if((f.equals(text_friend.getText().toString()) || f.equals(text_friend.getText().toString())) ) {
                    toast = Toast.makeText(context, "Cet utilisateur vous a déjà envoyé une invitation !", duration);
                    toast.show();
                    return;
                }
            }

            toast = Toast.makeText(context, "Une requête a été envoyé à " + text_friend.getText() + " !", duration);
            FriendshipDAO.addFriend(text_friend.getText().toString(), User.currentUser.getUsername());
            toast.show();
            rv1_adapt.updateData(Friendship.getSentUsername(User.currentUser.getUsername()));
        }

    }
}

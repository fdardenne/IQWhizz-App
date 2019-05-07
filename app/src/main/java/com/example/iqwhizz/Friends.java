package com.example.iqwhizz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
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
    private SentAdapter rv2_adapt;
    private ReceivedAdapter rv3_adapt;

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

        rv1 = (RecyclerView) findViewById(R.id.friends_recycler);
        rv1.setLayoutManager(new LinearLayoutManager(this));
        rv1_adapt = new FriendAdapter(friend_list);
        rv1.setAdapter(rv1_adapt);

        rv2 = (RecyclerView) findViewById(R.id.sent_requests);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2_adapt = new SentAdapter(sent_req);
        rv2.setAdapter(rv2_adapt);

        rv3 = (RecyclerView) findViewById(R.id.received_requests);
        rv3.setLayoutManager(new LinearLayoutManager(this));
        rv3_adapt = new ReceivedAdapter(received_req, rv1_adapt);
        rv3.setAdapter(rv3_adapt);
    }

    private void addFriend() {
        text_friend = findViewById(R.id.text_friend);
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, "A Toast ...", duration);
        toast.setGravity(Gravity.CENTER| Gravity.CENTER, 0, 0);
        toast.setMargin(0,(float)0.08);


        if (!UserDAO.userExists(text_friend.getText().toString())) {

            toast.setText("Cet utilisateur n'existe pas !");
            toast.show();
            return;

        } else {
            ArrayList<String> sent = Friendship.getSentUsername(User.currentUser.getUsername());
            ArrayList<String> received = Friendship.getReceivedUsername(User.currentUser.getUsername());
            ArrayList<String> friends = Friendship.getFriendsUsername(User.currentUser.getUsername());
            for (String f : friends) {
                if ((f.equals(text_friend.getText().toString()) || f.equals(text_friend.getText().toString()))) {
                    toast.setText("Cet utilisateur est déjà dans vos amis !");
                    toast.show();
                    return;
                }
            }

            for (String f : sent) {
                if (f.equals(text_friend.getText().toString())) {
                    toast.setText("Vous avez déjà envoyé un requête à cette personne !");
                    //toast = Toast.makeText(context, "Vous avez déjà envoyé un requête à cette personne !", duration);
                    toast.show();
                    return;
                }
            }

            for (String f : received) {
                if ((f.equals(text_friend.getText().toString()) || f.equals(text_friend.getText().toString()))) {
                    toast.setText("Cet utilisateur vous a déjà envoyé une invitation !");
                    toast.show();
                    return;
                }
            }

            toast.setText("Une requête a été envoyé à " + text_friend.getText() + " !");
            boolean bool = FriendshipDAO.addFriend(text_friend.getText().toString(), User.currentUser.getUsername());
            if (bool) {
                //rv2_adapt.updateData(Friendship.getSentUsername(User.currentUser.getUsername()));
                rv2_adapt.addItem(text_friend.getText().toString());
            }
            else {
                toast.setText("An error occured while inserting in the DB.");
            }
            toast.show();
            return;
        }
    }
}

package com.example.iqwhizz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.iqwhizz.DAO.StatsDAO;
import com.example.iqwhizz.DAO.TestDAO;
import com.example.iqwhizz.Objects.Challenge;
import com.example.iqwhizz.Objects.Test;
import com.example.iqwhizz.Objects.User;

import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class DuelAdapter extends RecyclerView.Adapter<DuelAdapter.MyViewHolder> {

    private Challenge[] to_display;
    private OnDuelListener onDuelListener;

    public DuelAdapter(Challenge[] to_display, OnDuelListener onDuelListener){
        super();
        this.to_display = to_display;
        this.onDuelListener = onDuelListener;
    }

    @Override
    public int getItemCount() {
        return to_display.length;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_duel, parent, false);
        return new MyViewHolder(view, onDuelListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Challenge elem = to_display[position];
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView friend_username;
        private final TextView category;
        private final TextView done;
        private final TextView type;
        private final TextView myIQ;
        private final TextView opposantIQ;


        private Challenge current;

        OnDuelListener onHistoryListener;

        public MyViewHolder(final View itemView, OnDuelListener onHistoryListener)  {
            super(itemView);

            friend_username = ((TextView) itemView.findViewById(R.id.friend_username_duel));
            category = ((TextView) itemView.findViewById(R.id.category_duel));
            done = ((TextView) itemView.findViewById(R.id.done));
            type = ((TextView) itemView.findViewById(R.id.type_duel));
            myIQ = ((TextView) itemView.findViewById(R.id.myQI_duel));
            opposantIQ = ((TextView) itemView.findViewById(R.id.opposantIQ_duel));

            this.onHistoryListener = onHistoryListener;

        }

        public void display(Challenge elem) {
            current = elem;

            Test t = TestDAO.getTest(elem.getTestID(),0);
            category.setText("Catégorie: " + t.getCategory());
            type.setText("Type de test: " + t.getType());
            done.setText(elem.isDone() + "");

            if(elem.getChallenger().equals(User.currentUser.getUsername())){
                friend_username.setText("Défi pour " + elem.getChallenged());
                myIQ.setText("Mon score: " + StatsDAO.getIQ(User.currentUser.getUsername(), t.getTestID()));
                if(elem.isDone()){
                    opposantIQ.setText("Opposant: " +StatsDAO.getIQ(elem.getChallenged(), t.getTestID()));
                    done.setText("Le défi est finis");
                    done.setTextColor(Color.parseColor("#00cc00"));
                }else{
                    opposantIQ.setText("Opposant: En attente ");
                    done.setText("En attente de l'opposant");
                    done.setTextColor(Color.parseColor("#077187"));
                }

            }else{
                friend_username.setText("Défi de " + elem.getChallenger());
                opposantIQ.setText("Opposant: " +StatsDAO.getIQ(elem.getChallenger(), t.getTestID()));

                if(elem.isDone()){
                    myIQ.setText("Mon score: " + StatsDAO.getIQ(User.currentUser.getUsername(), t.getTestID()));
                    done.setText("Le défi est finie");
                    done.setTextColor(Color.parseColor("#00cc00"));

                }else{
                    myIQ.setText("Mon score: En attente ");
                    done.setText("A votre tour... Cliquer ici pour jouer !");
                    done.setTextColor(Color.parseColor("#C44C35"));
                }
            }




            itemView.setOnClickListener(this);




        }


        @Override
        public void onClick(View v) {
            onDuelListener.onDuelClick(getAdapterPosition());
        }
    }
    public interface OnDuelListener{
        void onDuelClick(int position);
    }

}
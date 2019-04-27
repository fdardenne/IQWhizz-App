package com.example.iqwhizz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.MyViewHolder> {

    //Chaque Tableau a comme contenu ["la date formaté", "La catégorie", "Le type de test", "Le score en QI"]
    private ArrayList<HashMap<String,String>> to_display;

    public HistoryAdapter(ArrayList<HashMap<String, String>> to_display){
        super();
        this.to_display = to_display;


    }

    @Override
    public int getItemCount() {
        return to_display.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_history, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HashMap<String,String> elem = to_display.get(position);
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView date;
        private final TextView category;
        private final TextView type;
        private final TextView score;

        private HashMap<String,String> current;

        public MyViewHolder(final View itemView) {
            super(itemView);

            date = ((TextView) itemView.findViewById(R.id.date_cell));
            category = ((TextView) itemView.findViewById(R.id.category_cell));
            type = ((TextView) itemView.findViewById(R.id.type_cell));
            score = ((TextView) itemView.findViewById(R.id.iq_cell));

        }

        public void display(HashMap<String,String> elem) {
            current = elem;
            date.setText(elem.get("date"));
            category.setText(elem.get("category"));
            type.setText(elem.get("type"));
            score.setText(elem.get("score"));
        }
    }

}
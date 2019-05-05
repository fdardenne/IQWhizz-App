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
    private OnHistoryListener onHistoryListener;

    public HistoryAdapter(ArrayList<HashMap<String, String>> to_display, OnHistoryListener onHistoryListener){
        super();
        this.to_display = to_display;
        this.onHistoryListener = onHistoryListener;
    }

    @Override
    public int getItemCount() {
        return to_display.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_history, parent, false);
        return new MyViewHolder(view, onHistoryListener);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        HashMap<String,String> elem = to_display.get(position);
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView date;
        private final TextView category;
        private final TextView type;
        private final TextView score;

        private HashMap<String,String> current;

        OnHistoryListener onHistoryListener;

        public MyViewHolder(final View itemView, OnHistoryListener onHistoryListener)  {
            super(itemView);

            date = ((TextView) itemView.findViewById(R.id.date_cell));
            category = ((TextView) itemView.findViewById(R.id.category_cell));
            type = ((TextView) itemView.findViewById(R.id.type_cell));
            score = ((TextView) itemView.findViewById(R.id.iq_cell));
            this.onHistoryListener = onHistoryListener;

        }

        public void display(HashMap<String,String> elem) {
            current = elem;
            date.setText(elem.get("date"));
            category.setText(elem.get("category"));
            type.setText(elem.get("type"));
            score.setText(elem.get("score"));
            itemView.setOnClickListener(this);


        }


        @Override
        public void onClick(View v) {
            onHistoryListener.onHistoryClick(getAdapterPosition());
        }
    }
    public interface OnHistoryListener{
        void onHistoryClick(int position);
    }

}
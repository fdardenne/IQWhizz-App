package com.example.iqwhizz;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.MyViewHolder> {

    private ArrayList<String> to_display;

    public FriendAdapter(ArrayList<String> to_display){
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
        View view = inflater.inflate(R.layout.list_friend, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String elem = to_display.get(position);
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView username;

        private String current;

        public MyViewHolder(final View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.friendname);

        }

        public void display(String elem) {
            current = elem;
            username.setText(current);
        }
    }

    public void updateData(ArrayList<String> newElements) {
        to_display.clear();
        to_display.addAll(newElements);
        notifyDataSetChanged();
    }
}

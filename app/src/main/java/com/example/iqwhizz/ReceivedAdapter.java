package com.example.iqwhizz;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.iqwhizz.DAO.FriendshipDAO;
import com.example.iqwhizz.Objects.User;

import java.util.ArrayList;

public class ReceivedAdapter extends RecyclerView.Adapter<ReceivedAdapter.MyViewHolder> {

    private ArrayList<String> items;
    private FriendAdapter friend_list;

    public ReceivedAdapter(ArrayList<String> to_display, FriendAdapter friend_list){
        super();
        this.items = to_display;
        this.friend_list = friend_list;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_received, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String elem = items.get(position);
        holder.display(elem);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView username;
        private final Button accept_btn;
        private final Button delete_btn;

        private String current;

        public MyViewHolder(final View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.received_name);
            delete_btn = (Button) itemView.findViewById(R.id.received_delete_btn);
            accept_btn = (Button) itemView.findViewById(R.id.received_accept_btn);
            delete_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean bool = FriendshipDAO.deleteFriendship(username.getText().toString(), User.currentUser.getUsername());
                    if (bool) {
                        removeItem(username.getText().toString());
                    }
                    else {
                        Log.d("Friends", "Error while refusing request");
                    }
                }
            });
            accept_btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d("Friends", "Accepting the request");
                    boolean bool = FriendshipDAO.acceptFriendRequest(username.getText().toString(), User.currentUser.getUsername());
                    if (bool) {
                        friend_list.addItem(username.getText().toString());
                        removeItem(username.getText().toString());
                    }
                }
            });
        }

        public void display(String elem) {
            current = elem;
            username.setText(current);
        }
    }


    public void updateData(ArrayList<String> newElements) {
        clear();
        /*for (String s : items) {
            removeItem(items.indexOf(s));
        }*/
        items.addAll(newElements);
        notifyDataSetChanged();
    }

    public void addItem(String str) {
        items.add(0, str);
        notifyItemInserted(0);
    }

    private void clear() {
        final int size = items.size();
        items.clear();
        notifyItemRangeRemoved(0, size);
    }

    public void removeItem(String str) {
        int position = items.indexOf(str);
        items.remove(position);
        this.notifyItemRemoved(position);
        this.notifyItemRangeChanged(position, items.size());
    }
}

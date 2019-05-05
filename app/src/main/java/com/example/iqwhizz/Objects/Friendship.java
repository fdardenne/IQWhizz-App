package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.FriendshipDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Friendship {
    private String sender;
    private String receiver;
    private int request_date;
    private int acceptance_date;
    private boolean isAccepted;

    public Friendship(String sender, String receiver, int request_date, int acceptance_date, boolean isAccepted) {
        this.sender=sender;
        this.receiver=receiver;
        this.request_date=request_date;
        this.acceptance_date=acceptance_date;
        this.isAccepted=isAccepted;

    }

    public Friendship(String sender, String receiver) {
        this.sender=sender;
        this.receiver=receiver;
        Date date = new Date();
        this.request_date=Math.round(date.getTime()/1000);
        this.acceptance_date=0;
        this.isAccepted=false;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public int getRequest_date() {
        return request_date;
    }

    public void setRequest_date(int request_date) {
        this.request_date = request_date;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public int getAcceptance_date() {
        return acceptance_date;
    }

    public void setAcceptance_date(int acceptance_date) {
        this.acceptance_date = acceptance_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Friendship that = (Friendship) o;
        return request_date == that.request_date &&
                acceptance_date == that.acceptance_date &&
                isAccepted == that.isAccepted &&
                sender.equals(that.sender) &&
                receiver.equals(that.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sender, receiver, request_date, acceptance_date, isAccepted);
    }

    public static ArrayList<String> getFriendsUsername(String username) {
        ArrayList<String> list_friend = new ArrayList<>();
        Friendship[] user_friendship = FriendshipDAO.getFriendList(username);
        for(int i = 0; i<user_friendship.length; i++){
            if(user_friendship[i].getSender().equals(username)){
                list_friend.add(user_friendship[i].getReceiver());
            }
            else {
                list_friend.add(user_friendship[i].getSender());
            }
        }

        return list_friend;
    }

    public static ArrayList<String> getSentUsername(String username) {
        ArrayList<String> sent = new ArrayList<>();
        Friendship[] sent_fr = FriendshipDAO.getSentRequests(username);
        for(int i = 0; i<sent_fr.length; i++){
            sent.add(sent_fr[i].getReceiver());
        }

        return sent;
    }

    public static ArrayList<String> getReceivedUsername(String username) {
        ArrayList<String> received = new ArrayList<>();
        Friendship[] received_fr = FriendshipDAO.getReceivedRequests(username);
        for(int i = 0; i<received_fr.length; i++){
            received.add(received_fr[i].getReceiver());
        }

        return received;
    }
}

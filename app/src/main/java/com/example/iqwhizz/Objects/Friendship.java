package com.example.iqwhizz.Objects;

import java.util.Date;

public class Friendship {
    private String sender;
    private String receiver;
    private int request_date;

    public Friendship(String sender, String receiver, int request_date) {
        this.sender=sender;
        this.receiver=receiver;
        this.request_date=request_date;
    }

    public Friendship(String sender, String receiver) {
        this.sender=sender;
        this.receiver=receiver;
        Date date = new Date();
        this.request_date=Math.round(date.getTime()/1000);
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
}

package com.example.iqwhizz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    @NonNull
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "language")
    public String language;

    public User(String u, String p, String l) {
        username = u;
        password = p;
        language = l;
    }
    public User() {}
}

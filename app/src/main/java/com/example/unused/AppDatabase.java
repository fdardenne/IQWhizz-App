package com.example.unused;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.iqwhizz.User;
import com.example.unused.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}

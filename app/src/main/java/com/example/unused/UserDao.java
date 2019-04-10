package com.example.unused;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.iqwhizz.User;

@Dao
public interface UserDao {
    @Query("SELECT * FROM Users WHERE username LIKE :username")
    LiveData<User> getUser(String username);

    @Insert
    void insertUser(User user);
}

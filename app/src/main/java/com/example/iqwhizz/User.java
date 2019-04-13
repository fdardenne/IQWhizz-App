package com.example.iqwhizz;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;


import java.util.Date;


@Entity(tableName = "Users")
public class User {
    @PrimaryKey
    @NonNull
    public String username;

    @ColumnInfo(name = "password")
    public String password;

    @ColumnInfo(name = "language")
    public String language;

    @ColumnInfo(name = "mail")
    public String mail;

    @ColumnInfo(name = "birthdate")
    public int birthdate;

    @ColumnInfo(name = "picture")
    public String picture;

    /*
    /  Crée un Usser sur base de toutes ses données,
    /  et rajoute une ligne dans la base de données
    */
    public User(String u, String p, String l, String m, int bd, String pic) {
        username = u;
        password = p;
        language = l;
        mail = m;
        birthdate = bd;
        picture = pic;
        // donne l'heure d'inscription (a vérifier)
        int insc_d = (int) new Date().getTime();
        // a changer si implémenté
        int last_co = 0;
        UsersDAO.createUser(u,p,l,m,bd,insc_d,last_co,pic,AppContextProvider.getContext());
    }
    public User(String username, String password, String language) {
        if(UsersDAO.getUser(username,password,AppContextProvider.getContext()) != null ) {
            this.username = username;
            this.password = password;
            this.language = language;
        }
        else{
            throw new IllegalArgumentException("Username or password incorrect");
        }
    }
}

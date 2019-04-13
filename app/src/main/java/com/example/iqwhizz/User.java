package com.example.iqwhizz;

import java.util.Date;

public class User {

    public String username;
    public String password;
    public String language;
    public String mail;
    public int birthdate;
    public String picture;
    public int registrationDate;

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
        registrationDate = (int) new Date().getTime();
        // a changer si implémenté
        int last_co = 0;
        UserDAO.createUser(u,p,l,m,bd,registrationDate,last_co,pic,AppContextProvider.getContext());
    }
    public User(String username, String password, String language) {
        if(UserDAO.getUser(username,password,AppContextProvider.getContext()) != null ) {
            this.username = username;
            this.password = password;
            this.language = language;
        }
        else{
            throw new IllegalArgumentException("Username or password incorrect");
        }
    }
}

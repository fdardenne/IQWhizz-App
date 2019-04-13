package com.example.iqwhizz;

import java.util.Date;

public class User {

    public String username;
    public String password;
    public String language;
    public String mail;
    public String picture;
    public int last_connexion;
    public int birthdate;

    /*
    /  Crée un Usser sur base de toutes ses données,
    /  et rajoute une ligne dans la base de données
    */
    public User(String u, String p, String l, String m, int bd, String pic, int last_co)
    {
        if( UserDAO.getUser(username,password) == null )
        {
            username = u ;
            password = p;
            language = l;
            mail = m;
            birthdate = bd;
            picture = pic;
            last_connexion = last_co;
            //last_connexion = (int) (Date().getTime()/1000);
            // mettre les bons arguments quand ce sera ok
            //UserDAO.createUser(u,p,l,m,bd,last_co,pic,AppContextProvider.getContext());
        }
        else
            {
                throw new IllegalArgumentException("User or password already exists");
            }
    }

    public User(String username, String password) {
        if(UserDAO.getUser(username,password) != null ) {
            this.username = username;
            this.password = password;
            this.language = language;
        }
        else{
            throw new IllegalArgumentException("Username or password incorrect");
        }
    }

    /*
        retourne la liste des amis de this.
        DAO : donner la table Friendship
    */
    public String[] getFriendList()
    {

        return new String[0];
    }

    /*
       True si this est ami avec l'user dont l'username est donné
       DAO : donner la table Friendship
    */
    public boolean isFriend(String username)
    {

        return false;
    }

    /*
        ajoute une ligne dans la db
        DAO : ajouter une ligne dans Friendship
     */
    public void addFriend(String username)
    {
        return;
    }

    /*
        liste des demandes d'amis qui n'ont pas encore été acceptées par this
        DAO : donner table Friendship
     */
    public String[] getPendingFriendRequest()
    {

        return new String[0];
    }

    /*
        liste des demandes d'amis faites par this qui ne sont pas encore acceptées
        par les autres User
        DAO : donner table Friendship
     */
    public String[] getFriendRequest()
    {

        return new String[0];
    }

    /*
        ajoute une ligne à la db
        DAO : ajouter ligne dans FriendShip
     */
    public void acceptFriendRequest(String username)
    {
        return;
    }

    /*
        true si this existe dans la db, false sinon
        DAO : donner la liste des user
     */
    boolean exist(String username)
    {

        return false;
    }

    /*
        true si le mot de passe correspond bien a l'utilisateur,
        false sinon en faisant une recherche dans la db
        DAO : Donner la liste des user avec leur mot de passe (ou toute la table mais ca
        risque d'être chargé non ? :/ )
     */
    boolean checkPassword(String username, String password)
    {

        return false;
    }
}

package com.example.iqwhizz;

public class User {

    public String username;
    public String password;
    public String language;
    public String mail;
    public String picture;
    public int last_connexion;
    public int registration_date;
    public int birthdate;

    /*
      Crée un Usser sur base de toutes ses données si celui ci n'existe pas encore
      et rajoute une ligne dans la base de données
    */
    public User(String u, String p, String l, String m, int bd, String pic, int last_co, int reg_date)
    {
        // ou User.exists() ??
        if( UserDAO.userExists(username) == false )
        {
            username = u ;
            password = p;
            language = l;
            mail = m;
            birthdate = bd;
            picture = pic;
            last_connexion = last_co;
            registration_date = reg_date;
            //last_connexion = (int) (Date().getTime()/1000);
            // mettre les bons arguments quand ce sera ok
            UserDAO.createUser(u,p,l,m,bd,reg_date,last_co,pic);
        }
        else {
                throw new IllegalArgumentException("User with username "+u+" already exists");
        }
    }


    public User(String username, String password)
    {
        User user = UserDAO.getUser(username,password);
        if(user != null )
        {
            this.registration_date = user.registration_date;
            this.last_connexion = user.last_connexion;
            this.language = user.language;
            this.password = user.password;
            this.birthdate = user.birthdate;
            this.mail = user.mail;
            this.picture = user.picture;
            this.username = user.username;
        }
        else {
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

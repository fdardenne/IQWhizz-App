package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.FriendshipDAO;
import com.example.iqwhizz.DAO.UserDAO;

public class User {

    private String username;
    private String password;
    private String language;
    private String mail;
    private byte[] picture;
    private int last_connexion;
    private int registration_date;
    private int birthdate;

    //Doit être publique pour que chaque vues puissent accéder a l'utilisateur actuel
    public static User currentUser;

    /*
      Crée un User sur base de toutes ses données si celui ci n'existe pas encore
      et rajoute une ligne dans la base de données
    */
    public User(String u, String p, String l, String m, int bd, byte[] pic, int last_co, int reg_date)
    {
        username = u ;
        password = p;
        language = l;
        mail = m;
        birthdate = bd;
        picture = pic;
        last_connexion = last_co;
        registration_date = reg_date;
    }

    /*
        crée un objet user lors du login d'un utilisateur ==> très étrange comme constructeur
     */
    private User(String username, String password)
    {
        User user = UserDAO.getUser(username,password);
        this.registration_date = user.getRegistration_date();
        this.last_connexion = user.getLast_connexion();
        this.language = user.getLanguage();
        this.password = user.getPassword();
        this.birthdate = user.getBirthdate();
        this.mail = user.getMail();
        this.picture = user.getPicture();
        this.username = user.getUsername();
    }

    public static boolean connectUser(String username, String password) {
        if (currentUser!=null) {
            if (currentUser.getUsername().equals(username)) {
                return true;
            }
            else {
                currentUser=null;
                return connectUser(username, password);
            }
        }
        else {
            User user = UserDAO.getUser(username, password);
            if (user==null) return false;
            currentUser=user;
            return true;
        }
    }

    // TODO : à complèter !
    public static boolean disconnectUser() {
        return true;
    }

    /*
        retourne la liste des amis de this.
        DAO : donner la table Friendship
    */
    public Friendship[] getFriendList()
    {
        return FriendshipDAO.getFriendList(this.username);
    }

    /*
       True si this est ami avec l'user dont l'username est donné.
       DAO : donner la table Friendship
    */
    public boolean isFriend(String username)
    {
        Friendship[] lesZamis = FriendshipDAO.getFriendList(this.username);
        for(int i = 0; i < lesZamis.length ; i++ )
        {
            Friendship amitié = lesZamis[i];
            String sender = amitié.getSender();
            String receiver = amitié.getReceiver();
            if (sender.equals(username) || receiver.equals(username))
            {
                return true;
            }
        }
        return false;
    }

    /*
        ajoute une ligne dans la db.
        DAO : ajouter une ligne dans Friendship
     */
    public void addFriend(String username)
    {
        FriendshipDAO.addFriend(this.getUsername(), username);
    }

    /*
        liste des demandes d'amis qui n'ont pas encore été acceptées par this
        DAO : donner table Friendship
     */
    public Friendship[] getPendingFriendRequest()
    {
        return FriendshipDAO.getSentRequests(this.username);
    }

    /*
        liste des demandes d'amis faites par this qui ne sont pas encore acceptées
        par les autres User
        DAO : donner table Friendship
     */
    public Friendship[] getFriendRequest()
    {

        return FriendshipDAO.getReceivedRequests(this.username);
    }

    /*
        ajoute une ligne à la db
        DAO : ajouter ligne dans FriendShip
     */
    public void acceptFriendRequest(String username)
    {
        FriendshipDAO.addFriend(this.getUsername(),username);
    }

    /*
        true si this existe dans la db, false sinon
        DAO : donner la liste des user
     */
    boolean exist(String username)
    {
        return UserDAO.userExists(this.username);
    }

    /*
        true si le mot de passe correspond bien a l'utilisateur,
        false sinon en faisant une recherche dans la db
        DAO : Donner la liste des user avec leur mot de passe (ou toute la table mais ca
        risque d'être chargé non ? :/ )
     */
    boolean checkPassword(String username,String password)
    {
        User user = UserDAO.getUser(username,password);
        if(user == null)
        {
            return false;
        }
        return true;
    }

    // getters
    public String getUsername()
    {
        return this.username;
    }

    public byte[] getPicture()
    {
        return this.picture;
    }

    public String getLanguage()
    {
        return this.language;
    }

    public String getMail()
    {
        return this.mail;
    }

    public int getLast_connexion()
    {
        return this.last_connexion;
    }

    public int getBirthdate()
    {
        return this.birthdate;
    }

    public int getRegistration_date()
    {
        return this.registration_date;
    }

    public String getPassword()
    {
        return this.password;
    }
}

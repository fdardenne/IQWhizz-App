package com.example.iqwhizz;

public class User {

    private String username;
    private String password;
    private String language;
    private String mail;
    private byte[] picture;
    private int last_connexion;
    private int registration_date;
    private int birthdate;

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
        crée un objet user lors du login d'un utilisateur
     */
    public User(String username, String password)
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
        return true;
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

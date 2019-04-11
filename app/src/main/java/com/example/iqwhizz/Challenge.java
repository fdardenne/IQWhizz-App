package com.example.iqwhizz;

public class Challenge {

    public String challenger; //username

    public String challenged; //username

    public boolean done;

    public int testID;

    /*
        Constructeur
     */
    Challenge(String challenger, String challenged, int testID)
    {
        this.challenger = challenger;
        this.challenged = challenged;
        this.testID = testID;
        this.done = false;
    }

    /*
        retourne le testID du challenge
        DAO : donner le Test grace au testID de challenger et challenged
     */
    public Test loadTest()
    {

        return null;
    }




}

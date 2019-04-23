package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.TestDAO;

public class Challenge {

    private String challenger; //username

    private String challenged; //username

    private boolean done ;

    private int testID;

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
        return TestDAO.getTest(this.testID);
    }




}

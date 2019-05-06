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
    public Challenge(String challenger, String challenged, int testID, boolean done)
    {
        this.challenger = challenger;
        this.challenged = challenged;
        this.testID = testID;
        this.done = done;
    }

    /*
        retourne le testID du challenge
        DAO : donner le Test grace au testID de challenger et challenged
     */
    public Test loadTest()
    {
        // Que faire si on a quitté le test en cours d'éxécution ?
        Test test = TestDAO.startTest(this.testID);
        return test;
    }

    public int getTestID() {
        return testID;
    }


    public String getChallenger() {
        return challenger;
    }

    public String getChallenged() {
        return challenged;
    }

    public boolean isDone() {
        return done;
    }
}

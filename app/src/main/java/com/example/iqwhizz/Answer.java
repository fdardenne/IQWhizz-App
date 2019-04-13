package com.example.iqwhizz;

public class Answer {

    private int answerID;

    private String image; //path

    private String text;

    private int score ;

    /*
        Constructeur
     */
    public Answer(int answerID, String image, String text, int score)
    {
        this.answerID=answerID;
        this.image=image;
        this.text=text;
        this.score=score;
    }

    /*
        true si reponse correct false sinon
     */
    public boolean isRight()
    {
        return (this.score!=0);
    }
}

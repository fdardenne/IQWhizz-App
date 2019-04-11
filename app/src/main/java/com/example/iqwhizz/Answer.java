package com.example.iqwhizz;

public class Answer {

    public int answerID;

    public String image; //path

    public String text;

    public int score;

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

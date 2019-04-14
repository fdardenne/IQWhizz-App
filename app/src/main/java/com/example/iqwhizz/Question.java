package com.example.iqwhizz;

public class Question {

    private int questionID;

    private String category;

    private byte[] image;  //path de l'image

    private String text;

    private int difficulty ;

    private Answer[] answers;

    /*
        Constructeur
        DAO : donner la liste des answers possible avec le score pour creer la liste answers
     */
    Question(int questionID, String category, byte[] image, String text, int difficulty)
    {
        this.questionID=questionID;
        this.category=category;
        this.image=image;
        this.text=text;
        this.difficulty=difficulty;
        this.answers=null; //création de la liste avec elements données par DAO
    }

    /*
        donne la reponse correcte parmi les possibleAnswers
        DAO : donner les possibles reponse
     */
    public Answer getRightAnswer()
    {
        return null;
    }

    /*
        Pourquoi mettre un getAnswers si on met la variable en public :/
     */
    public Answer[] getAnswer()
    {
        return null;
    }

    public int getID () {
        return questionID;
    }

}

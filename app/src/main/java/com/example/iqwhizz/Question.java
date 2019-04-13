package com.example.iqwhizz;

public class Question {

    public int questionID;

    public String category;

    public String image;  //path de l'image

    public String text;

    public int difficulty ;

    public Answer[] answers;

    /*
        Constructeur
        DAO : donner la liste des answers possible avec le score pour creer la liste answers
     */
    Question(int questionID, String category, String image, String text, int difficulty)
    {
        this.questionID=questionID;
        this.category=category;
        this.image=image;
        this.text=text;
        this.difficulty=difficulty;
        this.answers=NULL; //création de la liste avec elements données par DAO
    }

    /*
        donne la reponse correcte parmi les possibleAnswers
        DAO : donner les possibles reponse
     */
    public Answer getRightAnswer()
    {
        return NULL;
    }

    /*
        Pourquoi mettre un getAnswers si on met la variable en public :/
     */
    public Answer[] getAnswer()
    {
        return NULL;
    }

}

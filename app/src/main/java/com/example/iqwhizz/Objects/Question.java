package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.AnswerDAO;

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
    public Question(int questionID, String category, byte[] image, String text, int difficulty)
    {
        this.questionID=questionID;
        this.category=category;
        this.image=image;
        this.text=text;
        this.difficulty=difficulty;
        this.answers= AnswerDAO.getAnswers(questionID); //création de la liste avec elements données par DAO
    }

    /*
        donne la reponse correcte parmi les possibleAnswers
        DAO : donner les possibles reponse
     */
    public Answer getRightAnswer()
    {
        for(int i=0; i < answers.length ; i++)
        {
            Answer reponse = answers[i];
            if(reponse.isRight())
            {
                return reponse;
            }
        }
        return null; // attention : ceci ne devrait jamais arriver !!
    }

    /*
        Pourquoi mettre un getAnswers si on met la variable en public :/
     */
    public Answer[] getAnswer()
    {
        return answers;
    }

    public int getID () {
        return questionID;
    }

}

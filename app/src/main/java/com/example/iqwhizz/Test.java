package com.example.iqwhizz;

public class Test {

    public int currentQuestion;

    public int testID;

    public String category;

    public String type; //long ou court

    public Question[] questions;

    /*
        Constructeur
        DAO : donner la liste des questions du test
     */
    Test(int testID, String category, String type, Question[] questions)
    {
        this.testID = testID;
        this.category = category ;
        this.type = type;
        this.questions = questions; //il faudra surement créer cette liste
        this.currentQuestion = -1;
    }

    /*
        true si il questions[currentQuestion+1] existe, false sinon
        DAO : rien
     */
    public boolean hasNext()
    {
        return false;
    }

    /*
        ajoute la réponse dans testExecution
        DAO : ajouter une ligne dans testExecution
     */
    public void answerToQuestion(int answerID, int time)
    {

    }

    /*
        donne la prochaine question dans questions
        DAO : rien
     */
    public Question nextQuestion()
    {
        return null;
    }


    /*
        loadQuestion() et saveSelectedAnswer() je vois pas trop à quoi ca sert
        puisque on fait deja tout ce qu'elles font dans answerToQuestions
     */


}

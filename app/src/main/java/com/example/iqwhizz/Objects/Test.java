package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.AnswerDAO;
import com.example.iqwhizz.DAO.QuestionDAO;
import com.example.iqwhizz.DAO.TestDAO;

public class Test {

    private int currentQuestion;

    private int testID;

    private int executionID;

    private String category;

    private String type; //long ou court

    private Question[] questions;

    /*
        Constructeur
        DAO : donner la liste des questions du test
     */
    public Test(int testID, int executionID ,String category, String type, Question[] questions)
    {
        this.testID = testID;
        this.executionID = executionID;
        this.category = category ;
        this.type = type;
        this.questions = questions; //il faudra surement créer cette liste
        this.currentQuestion = 0;
    }

    /*
        true si il questions[currentQuestion+1] existe, false sinon
        DAO : rien
     */
    public boolean hasNext()
    {
        return  this.questions[currentQuestion+1] != null ;
    }

    /*
        ajoute la réponse dans testExecution (SelectedAnswer??)
        DAO : ajouter une ligne dans testExecution (SelectedAnswer??)
     */
    public boolean answerToQuestion(int answerID, int time)
    {
        int rowID = TestDAO.answerToQuestion(this, answerID, time);
        return (rowID>0) ? true : false ;
    }

    public int getCurrentQuestionID() {
        return questions[currentQuestion].getID();
    }

    /*
        donne la prochaine question dans questions
        DAO : rien
     */
    public Question nextQuestion()
    {
        this.currentQuestion++;
        return this.questions[currentQuestion];
    }


    /*
        loadQuestion() et saveSelectedAnswer() je vois pas trop à quoi ca sert
        puisque on fait deja tout ce qu'elles font dans answerToQuestions
     */
    public int getTestID()
    {
        return testID;
    }

    public int getExecutionID() {
        return executionID;
    }

    public void setExecutionID(int executionID) {
        this.executionID = executionID;
    }
}

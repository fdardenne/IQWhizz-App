package com.example.iqwhizz.Objects;

import com.example.iqwhizz.DAO.TestDAO;

public class Test {

    private int nextQuestion;

    private int testID;

    private int executionID;

    private String category;

    private String type; //long ou court

    private Question[] questions;


    /*
        Constructeur
        DAO : donner la liste des questions du test
     */
    public Test(int testID, String category, String type, Question[] questions, int nextQuestion)
    {
        this.testID = testID;
        //this.executionID = executionID;
        this.category = category ;
        this.type = type;
        this.questions = questions; //il faudra surement créer cette liste
        this.nextQuestion = nextQuestion;
    }

    /*
        true si il questions[nextQuestion+1] existe, false sinon
        DAO : rien
     */
    public boolean hasNext()
    {
        return nextQuestion < this.questions.length;
    }

    /*
        ajoute la réponse dans testExecution (SelectedAnswer??)
        DAO : ajouter une ligne dans testExecution (SelectedAnswer??)
     */
    public boolean answerToQuestion(int answerID, int time)
    {
        int rowID = TestDAO.answerToQuestion(this, answerID, time);
        return rowID>0;
    }

    public int getNextQuestionID() {
        if (this.hasNext()) {
            // NE PAS incrémenter nextQuestion
            return questions[nextQuestion].getID();
        }
        else {
            return -1;
        }
    }

    /*
        donne la prochaine question dans questions et incrémente le pointeur nextQuestion
        DAO : rien
     */
    public Question getNextQuestion()
    {
        if(this.hasNext()) {
            return this.questions[nextQuestion++];
        }
        else {
            return null;
        }
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory(){return this.category;}
}

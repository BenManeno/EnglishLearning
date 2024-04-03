package org.pattersonclippers.englishlearning;

import java.util.ArrayList;

public class ScoreObject {

    private int score;

    private ArrayList<String>wrongAnswers;
    //private String wrongAnswer;
    private String feedback;

    public ScoreObject(){
        score=0;
        feedback="";
       wrongAnswers=new ArrayList<String>();
    }

    public ScoreObject(int score,  ArrayList<String>wrongAnswers, String feedback) {
        this.score = score;
       this.wrongAnswers=wrongAnswers;
        this.feedback = feedback;
    }

    public ArrayList<String> getWrongAnswer() {
        return wrongAnswers;
    }

    public int getScore() {
        return score;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWrongAnswer(ArrayList<String> wrongAnswer) {
        this.wrongAnswers= wrongAnswer;
    }
}

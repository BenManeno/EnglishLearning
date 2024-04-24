package org.pattersonclippers.englishlearning;

import java.util.ArrayList;


public class multScoreObject {

    private int score;
    private ArrayList<String> wrongAnswers;
    private String feedBack;

    public multScoreObject(){
        score=0;
        wrongAnswers = new ArrayList<>();
        feedBack="";
    }


    public multScoreObject(int score, String feedBack, ArrayList<String>wrongAnswers){
        this.score=score;
        this.feedBack=feedBack;
        this.wrongAnswers=wrongAnswers;
    }

    public int getScore() {
        return score;
    }

    public ArrayList<String> getWrongAnswers() {
        return wrongAnswers;
    }

    public String getFeedBack() {
        return feedBack;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setWrongAnswers(ArrayList<String> wrongAnswers) {
        this.wrongAnswers = wrongAnswers;
    }

    public void setFeedBack(String feedBack) {
        this.feedBack = feedBack;
    }

    @Override
    public String toString() {
        return "[score=" + score + "%" + "\n"+
                ", WrongAnswers=" + wrongAnswers + "\n"+
                ", feedBack='" + feedBack + '\'' + "]";
    }
}

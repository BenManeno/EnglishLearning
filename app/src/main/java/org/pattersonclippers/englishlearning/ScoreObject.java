package org.pattersonclippers.englishlearning;


public class ScoreObject {

//    private int score;

    private int tobeScore;
    private int pastTenseScore;

//    private ArrayList<String>wrongAnswers;
//    //private String wrongAnswer;
//    private String feedback;

    public ScoreObject(){
//        score=0;
        tobeScore=0;
        pastTenseScore=0;
    }

    public ScoreObject(int tobeScore, int pastTenseScore) {
//        this.score = score;
       this.tobeScore=tobeScore;
       this.pastTenseScore=pastTenseScore;
    }


//    public int getScore() {
//        return score;
//    }

    public int getTobeScore() {
        return tobeScore;
    }

    public int getPastTenseScore() {
        return pastTenseScore;
    }

    @Override
    public String toString() {
        return "To be score = " + tobeScore + "%"+
                "\n"+
                "\nPast Tense Score = " + pastTenseScore +"%";
    }
}

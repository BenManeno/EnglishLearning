package org.pattersonclippers.englishlearning;

import java.util.Arrays;

public class Question {




    private String question;

    private String[] choices;
//    private String hintWeb;

   private  String correctAnswer;

   private String category;

    public Question(String question, String[] choices, String correctAnswer,String category) {
        this.question = question;
        this.choices = choices;
        this.correctAnswer = correctAnswer;
        this.category=category;
    }

    public Question() {
        question="What";
        choices=new String[]{"is","are"};
        correctAnswer="is";
        category="unknown";
    }

//    public String getHintWeb() {
//        return hintWeb;
//    }

    public String getQuestion() {
        return question;
    }

    public String[] getChoices() {
        return choices;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setChoices(String[] choices) {
        this.choices = choices;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

//    public void setHintWeb(String hintWeb) {
//        this.hintWeb = hintWeb;
//    }

    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", choices=" + Arrays.toString(choices) +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

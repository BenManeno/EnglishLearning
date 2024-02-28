public class Question {



    private int levelOne;
    private int levelTwo;
    private String questionText;
    private String correctAnswer;


    String choiceBxOne,choiceBxTwo;





    public Question(){
        choiceBxOne="";
        choiceBxTwo="";
        questionText="";
        correctAnswer= "";
        levelOne= 0;
        levelTwo=0;

    }

    public Question(int levelOne,int levelTwo,String questionText,String correctAnswer,String choiceBxOne,String choiceBxTwo){
        this.levelOne=levelOne;
        this.levelTwo=levelTwo;
        this.questionText=questionText;
        this.correctAnswer=correctAnswer;
        this.choiceBxOne=choiceBxOne;
        this.choiceBxTwo=choiceBxTwo;
    }


    public int getLevelOne(){
        return levelOne;
    }
    public int getLevelTwo(){
        return levelTwo;
    }
    public String getCorrectAnswer(){
        return correctAnswer;
    }
    public String getQuestionText(){
        return questionText;
    }
    public String getChoiceBxOne(){
        return choiceBxOne;
    }
    public String getChoiceBxTwo(){
        return choiceBxTwo;
    }


    public void setCorrectAnswer(String correctAnswer){
        this.correctAnswer=correctAnswer;

    }
    public void setQuestionText(String questionText){
        this.questionText=questionText;

    }
    public void setChoiceBxOne(String choiceBxOne){
        this.choiceBxOne=choiceBxOne;

    }
    public void setChoiceBxTwo(String choiceBxTwo){
        this.choiceBxTwo=choiceBxTwo;

    }
    @Override
    public String toString(){
        return "questionText:"+questionText+"//"+"correct Answer:"+correctAnswer;
    }
}

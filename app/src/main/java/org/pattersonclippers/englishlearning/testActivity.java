package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class testActivity extends AppCompatActivity {

    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    SharedPreferences.Editor preferencesEditor;
    private final String SCORE_KEY = "Score";
    private final String MULTI_KEY="multi";
    final String TAG ="HHHH";
    LinearLayout backgroundColors;
    MediaPlayer player;


    Question question1,question2,question3,question4,question5,
            question6,question7,question8,question9,question10,question11,question12,question13,question14,question15,question16,question17,question18,
            currentQuestion;
    Question[]questions;



    Button firstChoiceBox,secondChoiceBox,thirdChoice;
    TextView testQuestionText,practiceTV;

    Button nextBTN;
    String text,userName;


    int score;
    ArrayList<String> wrongAnswer;
    String feedback;
    int percentScore;
    int rightIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        firstChoiceBox=(Button) findViewById(R.id.firstChoiceBox);
        secondChoiceBox=(Button) findViewById(R.id.secondChoiceBox);
        nextBTN=(Button) findViewById(R.id.nextBTN);
        testQuestionText=(TextView)findViewById(R.id.testQuestionText);
        practiceTV=(TextView)findViewById(R.id.practiceTV);
     thirdChoice=(Button)findViewById(R.id.thirdChoice);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

        score=0;
   feedback="";
   wrongAnswer = new ArrayList<>();


        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);
        preferencesEditor = myPreferences.edit();



        userName = myPreferences.getString(Name_Key,"");
       practiceTV.setText("Hello " +userName);


        int initialColor = myPreferences.getInt(COLOR_KEY, MODE_PRIVATE);

        if (initialColor == R.color.vanilla) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.vanilla));
        }
        else if (initialColor == R.color.Silver) {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.Silver));
        }
        else if(initialColor==R.color.skyblue){
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.skyblue));
        }
        else if(initialColor==R.color.yellowOrange){
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.yellowOrange));
        }
        else {
            backgroundColors.setBackgroundColor(getResources().getColor(R.color.white));
        }



        question1=new Question(getString(R.string.question1PastTest),new String[]{getString(R.string.NewBoxText1Test),getString(R.string.NewBox1Test),getString(R.string.TNewBoxText1Test)},getString(R.string.correctAnswerBox1Test),getString(R.string.CategoryTwo));
        question2=new Question(getString(R.string.question2PastTest),new String[]{getString(R.string.NewBoxText2Test),getString(R.string.NewBox2Test),getString(R.string.TNewBoxText2Test)},getString(R.string.correctAnswerBox2Test),getString(R.string.CategoryTwo));
        question3=new Question(getString(R.string.question3PastTest),new String[]{getString(R.string.NewBoxText3Test),getString(R.string.NewBox3Test),getString(R.string.TNewBoxText3Test)},getString(R.string.correctAnswerBox3Test),getString(R.string.CategoryTwo));
        question4=new Question(getString(R.string.question4PastTest),new String[]{getString(R.string.NewBoxText4Test),getString(R.string.NewBox4Test),getString(R.string.TNewBoxText4Test)},getString(R.string.correctAnswerBox4Test),getString(R.string.CategoryTwo));
        question5=new Question(getString(R.string.question5PastTest),new String[]{getString(R.string.NewBoxText5Test),getString(R.string.NewBox5Test),getString(R.string.TNewBoxText5Test)},getString(R.string.correctAnswerBox5Test),getString(R.string.CategoryTwo));
        question6=new Question(getString(R.string.question6Text),new String[]{getString(R.string.NewBox6),getString(R.string.NewBoxText6),getString(R.string.TNewBoxText6Practice)},getString(R.string.correctAnswerBox6),getString(R.string.CategoryOne));
        question7=new Question(getString(R.string.question7Text),new String[]{getString(R.string.NewBox7),getString(R.string.NewBoxText7),getString(R.string.TNewBoxText7Practice)},getString(R.string.correctAnswerBox7),getString(R.string.CategoryOne));
        question8=new Question(getString(R.string.question4Text),new String[]{getString(R.string.NewBox4),getString(R.string.NewBoxText4),getString(R.string.TNewBoxText4Practice)},getString(R.string.correctAnswerBox4),getString(R.string.CategoryOne));

        question9=new Question(getString(R.string.question11PastTest),new String[]{getString(R.string.NewBoxText11Test),getString(R.string.NewBox11Test),getString(R.string.TNewBoxText11Test)},getString(R.string.correctAnswerBox11Test),getString(R.string.CategoryTwo));
        question10=new Question(getString(R.string.question12PastTest),new String[]{getString(R.string.NewBoxText12Test),getString(R.string.NewBox12Test),getString(R.string.TNewBoxText12Test)},getString(R.string.correctAnswerBox12Test),getString(R.string.CategoryTwo));

        question11=new Question(getString(R.string.question13PastTest),new String[]{getString(R.string.NewBoxText13Test),getString(R.string.NewBox13Test),getString(R.string.TNewBoxText13Test)},getString(R.string.correctAnswerBox13Test),getString(R.string.CategoryTwo));
        question12=new Question(getString(R.string.question14PastTest),new String[]{getString(R.string.NewBoxText14Test),getString(R.string.NewBox14Test),getString(R.string.TNewBoxText14Test)},getString(R.string.correctAnswerBox14Test),getString(R.string.CategoryTwo));
        question13=new Question(getString(R.string.question15PastTest),new String[]{getString(R.string.NewBoxText15Test),getString(R.string.NewBox15Test),getString(R.string.TNewBoxText15Test)},getString(R.string.correctAnswerBox15Test),getString(R.string.CategoryTwo));
        question14=new Question(getString(R.string.question9Text),new String[]{getString(R.string.NewBox9),getString(R.string.NewBoxText9),getString(R.string.TNewBoxText9Practice)},getString(R.string.correctAnswerBox9),getString(R.string.CategoryOne));
        question15=new Question(getString(R.string.question10Text),new String[]{getString(R.string.NewBox10),getString(R.string.NewBoxText10),getString(R.string.TNewBoxText10Practice)},getString(R.string.correctAnswerBox10),getString(R.string.CategoryOne));
        question16=new Question(getString(R.string.question11Text),new String[]{getString(R.string.NewBox11),getString(R.string.NewBoxText11),getString(R.string.TNewBoxText11Practice)},getString(R.string.correctAnswerBox11),getString(R.string.CategoryOne));


        question17=new Question(getString(R.string.question16PastTest),new String[]{getString(R.string.NewBoxText16Test),getString(R.string.NewBox16Test),getString(R.string.TNewBoxText16Test)},getString(R.string.correctAnswerBox16Test),getString(R.string.CategoryTwo));
        question18=new Question(getString(R.string.question17PastTest),new String[]{getString(R.string.NewBoxText17Test),getString(R.string.NewBox17Test),getString(R.string.TNewBoxText17Test)},getString(R.string.correctAnswerBox17Test),getString(R.string.CategoryTwo));
        // create question 1D array



        questions=new Question[]{question1,question2,question3,question4,
                question5,question6,question7,question8,question9,question10,question11,question12,question13,question14,question15,question16,question17,question18};


        rightIndex=0;

        currentQuestion=questions[rightIndex];

        text="";

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                goToTheNextQuestion();


            }
        });


        firstChoiceBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[0])){
                    text=getString(R.string.correctMessage);
                    score=score+1;


                    player=MediaPlayer.create(testActivity.this,R.raw.correct);
                    player.start();
                }else{
                    String wrongMessage = currentQuestion.getQuestion()+"\n"+"***"+"This is what You choose [" + currentQuestion.getChoices()[0]+"]";
                    wrongAnswer.add(wrongMessage);

                    text=getString(R.string.WrongMsg);
                    player=MediaPlayer.create(testActivity.this,R.raw.wrong);
                    player.start();
                }
                //show the text for right or wrong answer

                int duration = Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();
                goToTheNextQuestion();



            }
        });

        secondChoiceBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[1])){
                    text="Right";
                    score=score+1;

                    player=MediaPlayer.create(testActivity.this,R.raw.correct);
                    player.start();
                }
                else{
                    String wrongMessage = currentQuestion.getQuestion()+"\n"+"***"+"This is what You choose [" + currentQuestion.getChoices()[1]+"]";
                    wrongAnswer.add(wrongMessage);
                    text="Wrong";
                    player=MediaPlayer.create(testActivity.this,R.raw.wrong);
                    player.start();

//                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
//                    player.start();
                }
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();
                goToTheNextQuestion();



            }
        });
        thirdChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[2])){
                    text=getString(R.string.correctMessage);
                    score=score+1;
                    player=MediaPlayer.create(testActivity.this,R.raw.correct);
                    player.start();
                }else{
                    String wrongMessage = currentQuestion.getQuestion()+"\n"+"***"+"This is what You choose [" + currentQuestion.getChoices()[2]+"]";
                    wrongAnswer.add(wrongMessage);
                    text=getString(R.string.WrongMsg);
                    player=MediaPlayer.create(testActivity.this,R.raw.wrong);
                    player.start();
                }
                //show the text for right or wrong answer

                int duration = Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();
                goToTheNextQuestion();

            }
        });



    }
    public void goToTheNextQuestion(){
        if(rightIndex<questions.length-1){
            rightIndex++;
            Log.d(TAG,rightIndex+"");
            currentQuestion=questions[rightIndex];

            Log.d(TAG,currentQuestion.toString());

            testQuestionText.setText(currentQuestion.getQuestion());
            firstChoiceBox.setText(currentQuestion.getChoices()[0]);
            secondChoiceBox.setText(currentQuestion.getChoices()[1]);
            thirdChoice.setText(currentQuestion.getChoices()[2]);

        }
        else{

            Intent myIntent=new Intent(testActivity.this,TestScoreActivity.class);
            Log.d(TAG,myIntent.toString());



            percentScore=score*100/questions.length;

            if(percentScore<50){
                feedback="keep study more please!" ;

            } else if (percentScore<70) {
                feedback="Almost there keep study try again. ";

            }
            else {
                feedback="Great ,you doing amazing.";
            }

            Log.d(TAG, String.valueOf(score));



            //create multiObject after make the feedback  if and  else

            multScoreObject multScoreObjects = new multScoreObject(percentScore,feedback,wrongAnswer);

            Log.d(TAG,multScoreObjects.toString());

            preferencesEditor.putInt(SCORE_KEY,percentScore);
            preferencesEditor.putString(MULTI_KEY,multScoreObjects.toString());
            preferencesEditor.apply();

//                    myIntent.putExtra("Score",score);

            startActivity(myIntent);
        }
    }

}
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

public class testActivity extends AppCompatActivity {

    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    SharedPreferences.Editor preferencesEditor;
    private final String SCORE_KEY = "Score";
    final String TAG ="HHHH";
    LinearLayout backgroundColors;
    MediaPlayer player;


    Question question1,question2,question3,question4,question5,question6,question7,question8,currentQuestion;
    Question[]questions;



    Button firstChoiceBox,secondChoiceBox,thirdChoice;
    TextView testQuestionText,practiceTV;

    Button nextBTN;
    String text,userName;


    int score;
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


        // create question 1D array


        questions=new Question[]{question1,question2,question3,question4,question5};


        rightIndex=0;

        currentQuestion=questions[rightIndex];

        text="";

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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

                    Intent myIntent=new Intent(testActivity.this,scoreActivity.class);
                    Log.d(TAG,myIntent.toString());

                    percentScore=score*100/questions.length;

                    Log.d(TAG, String.valueOf(score));

                    preferencesEditor.putInt(SCORE_KEY,percentScore);
                    preferencesEditor.apply();


//                    myIntent.putExtra("Score",score);
                    startActivity(myIntent);
                }


            }
        });


        firstChoiceBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[0])){
                    text=getString(R.string.correctMessage);
                    score=score+1;
//                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
//                    player.start();
                }else{
                    text=getString(R.string.WrongMsg);
//                    player=MediaPlayer.create(practiceActivity.this,R.raw.wrong);
//                    player.start();
                }
                //show the text for right or wrong answer

                int duration = Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });

        secondChoiceBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[1])){
                    text="Right";
                    score=score+1;

//                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
//                    player.start();
                }
                else{
                    text="Wrong";

//                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
//                    player.start();
                }
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });
        thirdChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[0])){
                    text=getString(R.string.correctMessage);
                    score=score+1;
//                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
//                    player.start();
                }else{
                    text=getString(R.string.WrongMsg);
//                    player=MediaPlayer.create(practiceActivity.this,R.raw.wrong);
//                    player.start();
                }
                //show the text for right or wrong answer

                int duration = Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });



    }

}
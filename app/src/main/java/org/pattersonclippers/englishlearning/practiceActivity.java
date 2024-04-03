package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class practiceActivity extends AppCompatActivity {

    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    SharedPreferences.Editor preferencesEditor;
    private final String SCORE_KEY = "Score";
    final String TAG ="HHHH";
    LinearLayout backgroundColors;


    Question question1,question2,question3,question4,question5,question6,question7,question8,currentQuestion;
    Question[]questions;



    Button firstChoiceBox,secondChoiceBox;
    TextView practiceQTV,practiceTV;

    Button nextBTN;
    String text,userName;


    int score;
    int percentScore;
    int rightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        firstChoiceBox=(Button) findViewById(R.id.firstChoiceBox);
        secondChoiceBox=(Button) findViewById(R.id.secondChoiceBox);
        nextBTN=(Button) findViewById(R.id.nextBTN);
        practiceQTV=(TextView)findViewById(R.id.practiceQTV);
        practiceTV=(TextView)findViewById(R.id.practiceTV);
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






        question1=new Question(getString(R.string.question1Text),getString(R.string.correctAnswerBox1),getString(R.string.NewBox1),getString(R.string.NewBoxText1));
        question2=new Question(getString(R.string.question2Text),getString(R.string.correctAnswerBox2),getString(R.string.NewBox2),getString(R.string.NewBoxText2));
        question3=new Question(getString(R.string.question3Text),getString(R.string.correctAnswerBox3),getString(R.string.NewBox3),getString(R.string.NewBoxText3));
        question4=new Question(getString(R.string.question4Text),getString(R.string.correctAnswerBox4),getString(R.string.NewBox4),getString(R.string.NewBoxText4));
        question5=new Question(getString(R.string.question5Text),getString(R.string.correctAnswerBox5),getString(R.string.NewBox5),getString(R.string.NewBoxText5));
        question6=new Question(getString(R.string.question6Text),getString(R.string.correctAnswerBox6),getString(R.string.NewBox6),getString(R.string.NewBoxText6));
        question7=new Question(getString(R.string.question7Text),getString(R.string.correctAnswerBox7),getString(R.string.NewBox7),getString(R.string.NewBoxText7));
        question8=new Question(getString(R.string.question8Text),getString(R.string.correctAnswerBox8),getString(R.string.NewBox8),getString(R.string.NewBoxText8));

        // create question 1D array


        questions=new Question[]{question1,question2,question3,question4,question5,question6,question7,question8};


        rightIndex=0;

        currentQuestion=questions[rightIndex];

        text="";






        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightIndex<questions.length-1){
                    rightIndex++;
                    Log.d(TAG,rightIndex+"");
                    currentQuestion=questions[rightIndex];

                    Log.d(TAG,currentQuestion.toString());

                    practiceQTV.setText(currentQuestion.getQuestionText());
                    firstChoiceBox.setText(currentQuestion.getChoiceBxOne());
                    secondChoiceBox.setText(currentQuestion.getChoiceBxTwo());

                }
                else{

                    Intent myIntent=new Intent(practiceActivity.this,scoreActivity.class);
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
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoiceBxOne())){
                    text=getString(R.string.correctMessage);
                    score=score+1;
                }else{
                    text=getString(R.string.WrongMsg);
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
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoiceBxTwo())){
                    text="Right";
                    score=score+1;
                }
                else{
                    text="Wrong";
                }
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });
    }
}
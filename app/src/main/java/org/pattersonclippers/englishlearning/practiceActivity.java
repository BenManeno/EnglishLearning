package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
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
    private final String TOBE_SCORE_KEY = "tobeScore";
    private final String PAST_TENSE_SCORE_KEY = "pastTenseScore";
    SharedPreferences.Editor preferencesEditor;
    private final String SCORE_KEY = "Score";
    private final String categoryKey="category";
    final String TAG ="HHHH";
    LinearLayout backgroundColors;
    MediaPlayer player;


    Question question1,question2,question3,question4,question5,
            question6,question7,question8,
            question9,question10,question11,question12,question13,
            currentQuestion;
    Question[]questions;



    Button firstChoiceBox,secondChoiceBox,thirdChoice;
    TextView practiceQTV,practiceTV,total_question;

    Button nextBTN;
    String text,userName;



    int tobeScore;
    int pastTenseScore;
    int percentScore;
    int rightIndex;
    String category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        firstChoiceBox=(Button) findViewById(R.id.firstChoiceBox);
        secondChoiceBox=(Button) findViewById(R.id.secondChoiceBox);
        nextBTN=(Button) findViewById(R.id.nextBTN);
        practiceQTV=(TextView)findViewById(R.id.practiceQTV);
        practiceTV=(TextView)findViewById(R.id.practiceTV);
       thirdChoice=(Button)findViewById(R.id.thirdChoice);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);
       // total_question=(TextView)findViewById(R.id.total_question);

        tobeScore=0;
        pastTenseScore=0;



        Intent myIntent = getIntent();
        category= myIntent.getStringExtra(categoryKey);



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






        question1=new Question(getString(R.string.question1Text),new String[]{getString(R.string.NewBox1),getString(R.string.NewBoxText1),getString(R.string.TNewBoxText1Practice)},getString(R.string.correctAnswerBox1),getString(R.string.CategoryOne));
        question2=new Question(getString(R.string.question2Text),new String[]{getString(R.string.NewBox2),getString(R.string.NewBoxText2),getString(R.string.TNewBoxText2Practice)},getString(R.string.correctAnswerBox2),getString(R.string.CategoryOne));
        question3=new Question(getString(R.string.question3Text),new String[]{getString(R.string.NewBox3),getString(R.string.NewBoxText3),getString(R.string.TNewBoxText3Practice)},getString(R.string.correctAnswerBox3),getString(R.string.CategoryOne));
        question4=new Question(getString(R.string.question4Text),new String[]{getString(R.string.NewBox4),getString(R.string.NewBoxText4),getString(R.string.TNewBoxText4Practice)},getString(R.string.correctAnswerBox4),getString(R.string.CategoryOne));
        question5=new Question(getString(R.string.question5Text),new String[]{getString(R.string.NewBox5),getString(R.string.NewBoxText5),getString(R.string.TNewBoxText5Practice)},getString(R.string.correctAnswerBox5),getString(R.string.CategoryOne));
        question6=new Question(getString(R.string.question6Text),new String[]{getString(R.string.NewBox6),getString(R.string.NewBoxText6),getString(R.string.TNewBoxText6Practice)},getString(R.string.correctAnswerBox6),getString(R.string.CategoryOne));
        question7=new Question(getString(R.string.question7Text),new String[]{getString(R.string.NewBox7),getString(R.string.NewBoxText7),getString(R.string.TNewBoxText7Practice)},getString(R.string.correctAnswerBox7),getString(R.string.CategoryOne));
        question8=new Question(getString(R.string.question8Text),new String[]{getString(R.string.NewBox8),getString(R.string.NewBoxText8),getString(R.string.TNewBoxText8Practice)},getString(R.string.correctAnswerBox8),getString(R.string.CategoryOne));
        question9=new Question(getString(R.string.question6PastTest),new String[]{getString(R.string.NewBoxText6Test),getString(R.string.NewBox6Test),getString(R.string.TNewBoxText6Test)},getString(R.string.correctAnswerBox6Test),getString(R.string.CategoryTwo));
        question10=new Question(getString(R.string.question7PastTest),new String[]{getString(R.string.NewBoxText7Test),getString(R.string.NewBox7Test),getString(R.string.TNewBoxText7Test)},getString(R.string.correctAnswerBox7Test),getString(R.string.CategoryTwo));
        question11=new Question(getString(R.string.question8PastTest),new String[]{getString(R.string.NewBoxText8Test),getString(R.string.NewBox8Test),getString(R.string.TNewBoxText8Test)},getString(R.string.correctAnswerBox8Test),getString(R.string.CategoryTwo));
        question12=new Question(getString(R.string.question9PastTest),new String[]{getString(R.string.NewBoxText9Test),getString(R.string.NewBox9Test),getString(R.string.TNewBoxText9Test)},getString(R.string.correctAnswerBox9Test),getString(R.string.CategoryTwo));
        question13=new Question(getString(R.string.question10PastTest),new String[]{getString(R.string.NewBoxText10Test),getString(R.string.NewBox10Test),getString(R.string.TNewBoxText10Test)},getString(R.string.correctAnswerBox10Test),getString(R.string.CategoryTwo));

        // create question 1D array


        questions=new Question[]{question1,question2,question3,question4,question5,question6,question7,question8,question9,question10,question11,question12,question13};


        rightIndex=0;

        currentQuestion=questions[rightIndex];

        while(!currentQuestion.getCategory().equals(category)){
            rightIndex++;
            currentQuestion=questions[rightIndex];
        }

        practiceQTV.setText(currentQuestion.getQuestion());
        firstChoiceBox.setText(currentQuestion.getChoices()[0]);
        secondChoiceBox.setText(currentQuestion.getChoices()[1]);
        thirdChoice.setText(currentQuestion.getChoices()[2]);

        text="";






        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(rightIndex<questions.length-1){
                    rightIndex++;
                    currentQuestion=questions[rightIndex];
                    Log.d(TAG,rightIndex+"");

                    while(!currentQuestion.getCategory().equals(category) && rightIndex<questions.length-1){
                        rightIndex++;
                        currentQuestion=questions[rightIndex];

                    }
                    if(currentQuestion.getCategory().equals(category)){
                        Log.d(TAG,currentQuestion.toString());

                        practiceQTV.setText(currentQuestion.getQuestion());
                        firstChoiceBox.setText(currentQuestion.getChoices()[0]);
                        secondChoiceBox.setText(currentQuestion.getChoices()[1]);
                        thirdChoice.setText(currentQuestion.getChoices()[2]);
                    }






                }
                else{

                    Intent myIntent=new Intent(practiceActivity.this,scoreActivity.class);
                    Log.d(TAG,myIntent.toString());


                    Log.d(TAG, String.valueOf(tobeScore));

                    preferencesEditor.putInt(TOBE_SCORE_KEY,calculatePercentScore(tobeScore,8));
                    preferencesEditor.putInt(PAST_TENSE_SCORE_KEY,calculatePercentScore(pastTenseScore,5));
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
                    //score=score+1;
                    if(currentQuestion.getCategory().equals(getString(R.string.CategoryOne))){
                        tobeScore++;
                    }
                    else if (currentQuestion.getCategory().equals(getString(R.string.CategoryTwo))){
                        pastTenseScore++;
                    }
                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
                    player.start();
                }else{
                    text=getString(R.string.WrongMsg);
                    player=MediaPlayer.create(practiceActivity.this,R.raw.wrong);
                    player.start();
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
                    if(currentQuestion.getCategory().equals(getString(R.string.CategoryOne))){
                        tobeScore++;
                    }
                    else if (currentQuestion.getCategory().equals(getString(R.string.CategoryTwo))){
                        pastTenseScore++;
                    }

                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
                    player.start();
                }
                else{
                    text="Wrong";

                    player=MediaPlayer.create(practiceActivity.this,R.raw.wrong);
                    player.start();
                }
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });


        thirdChoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentQuestion.getCorrectAnswer().equals(currentQuestion.getChoices()[2])){
                    text="Right";
                    if(currentQuestion.getCategory().equals(getString(R.string.CategoryOne))){
                        tobeScore++;
                    }
                    else if (currentQuestion.getCategory().equals(getString(R.string.CategoryTwo))){
                        pastTenseScore++;
                    }

                    player=MediaPlayer.create(practiceActivity.this,R.raw.correct);
                    player.start();
                }
                else{
                    text="Wrong";

                    player=MediaPlayer.create(practiceActivity.this,R.raw.wrong);
                    player.start();
                }
                int duration=Toast.LENGTH_SHORT;
                Toast t =Toast.makeText(getApplicationContext(),text,duration);
                t.show();

            }
        });
    }
    protected int calculatePercentScore(int numRight,int numTotal){
        return numRight*100/numTotal;
    }




}
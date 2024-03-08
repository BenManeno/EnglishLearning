package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class practiceActivity extends AppCompatActivity {

    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";


    Question question1,question2,currentQuestion;
    Question[]questions;

    CheckBox firstChoiceBox,secondChoiceBox;
    TextView practiceQTV,practiceTV;

    Button nextBTN;
    String text,userName;


    int score;
    int rightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        firstChoiceBox=(CheckBox) findViewById(R.id.firstChoiceBox);
        secondChoiceBox=(CheckBox) findViewById(R.id.secondChoiceBox);
        nextBTN=(Button) findViewById(R.id.nextBTN);
        practiceQTV=(TextView)findViewById(R.id.practiceQTV);
        practiceTV=(TextView)findViewById(R.id.practiceTV);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);



        userName = myPreferences.getString(Name_Key,"");
        practiceTV.setText("Hello " +userName);





        question1=new Question(getString(R.string.question1Text),getString(R.string.correctAnswerBox1),getString(R.string.NewBox1),getString(R.string.NewBoxText1));
        question2=new Question(getString(R.string.question2Text),getString(R.string.correctAnswerBox2),getString(R.string.NewBox2),getString(R.string.NewBoxText2));

        // create question 1D array


        questions=new Question[]{question1,question2};


        rightIndex=0;

        currentQuestion=questions[rightIndex];

        text="";






        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rightIndex<questions.length-1){
                    rightIndex++;
                    currentQuestion=questions[rightIndex];
                    practiceQTV.setText(currentQuestion.getQuestionText());
                    firstChoiceBox.setText(currentQuestion.getChoiceBxOne());
                    secondChoiceBox.setText(currentQuestion.getChoiceBxTwo());

                }
                else{
                    Intent myIntent=new Intent(practiceActivity.this,scoreActivity.class);
                    myIntent.putExtra("Score",score);
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
                    score=score+1;
                }

            }
        });
    }
}
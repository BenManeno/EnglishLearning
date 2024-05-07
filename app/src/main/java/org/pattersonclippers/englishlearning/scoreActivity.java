package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {
    Button openTB;
    TextView scoreTV, greetingTV;
    int score=0;
    Intent incomingIntent;
    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    private final String SCORE = "Score";
    private final String TOBE_SCORE_KEY = "tobeScore";
    private final String PAST_TENSE_SCORE_KEY = "pastTenseScore";
    private final String TEST_SCORE_KEY="testScore";
    LinearLayout backgroundColors;
    String greetingUser;
    String name;
    int testScore;
    int tobeScore;
    int pastTenseScore;
    ScoreObject scoreObject;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        openTB=(Button) findViewById(R.id.openTB);
        scoreTV=(TextView)findViewById(R.id.scoreTV);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);
        greetingTV=(TextView) findViewById(R.id.greetingTV) ;


        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);


        //score for to be and past tense
        tobeScore=myPreferences.getInt(TOBE_SCORE_KEY,0);
        pastTenseScore=myPreferences.getInt(PAST_TENSE_SCORE_KEY,0);

        scoreObject = new ScoreObject(tobeScore,pastTenseScore);

        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hello  " + name +" Here is your score : ";
        greetingTV.setText(greetingUser);



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

        openTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent myIntent = new Intent(scoreActivity.this,progressActivity.class);
                startActivity(myIntent);
            }
        });

        scoreTV.setText(scoreObject.toString());


       // scoreTV.setText("Your score is  "+score +"%");


    }
}
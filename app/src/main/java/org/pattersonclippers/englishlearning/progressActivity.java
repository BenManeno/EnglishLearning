package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressActivity extends AppCompatActivity {

    private int currentProgress=0;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";

    private final String SCORE = "Score";

    private final String TOBE_SCORE_KEY = "tobeScore";
    private final String PAST_TENSE_SCORE_KEY = "pastTenseScore";

    private int score;
    private int tobeScore;
    private int pastTenseScore;
    ProgressBar toBeProgress,simplePastProgressBar;
    private SharedPreferences myPreferences;
    TextView simplePastPercentTV, tobePercentTV;
    Button exitBTN;
;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);




        toBeProgress=(ProgressBar) findViewById(R.id.tobeProgressBar);
        simplePastProgressBar=(ProgressBar) findViewById(R.id.simplePastProgressBar);
        exitBTN=(Button)findViewById(R.id.exitBTN);
        tobePercentTV=(TextView) findViewById(R.id.tobePercentTV);
        simplePastPercentTV=(TextView) findViewById(R.id.simplePastPercentTV);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        score =myPreferences.getInt(SCORE,MODE_PRIVATE);

        tobeScore =myPreferences.getInt(TOBE_SCORE_KEY,MODE_PRIVATE);
        pastTenseScore =myPreferences.getInt(PAST_TENSE_SCORE_KEY,MODE_PRIVATE);



        simplePastProgressBar.setProgress(pastTenseScore);

        simplePastPercentTV.setText(pastTenseScore+"%");

        //
        toBeProgress.setProgress(tobeScore);
        tobePercentTV.setText(tobeScore+"%");


        //tobePercentTV.setText(score);
       // simplePastPercentTV.setText(score);


        exitBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(progressActivity.this,CategoriesActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
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
    private int score;
    ProgressBar toBeProgress,simplePastProgressBar;
    private SharedPreferences myPreferences;
    TextView simplePastPercentTV, tobePercentTV;
    Button exitBTN;
;

    ScoreObject scoreObject;

    CategoriesObject tobe ,pastTense,simplePAst;
    CategoriesObject[] categoriesNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);




        toBeProgress=(ProgressBar) findViewById(R.id.tobeProgressBar);
        simplePastProgressBar=(ProgressBar) findViewById(R.id.simplePastProgressBar);
        exitBTN=(Button)findViewById(R.id.exitBTN);
//        tobePercentTV=(TextView) findViewById(R.id.tobePercentTV);
//        simplePastPercentTV=(TextView) findViewById(R.id.simplePastPercentTV);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        score =myPreferences.getInt(SCORE,MODE_PRIVATE);



        simplePastProgressBar.setProgress(99);



        toBeProgress.setProgress(score);
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
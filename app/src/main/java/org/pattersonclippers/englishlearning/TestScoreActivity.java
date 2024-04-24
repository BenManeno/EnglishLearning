package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TestScoreActivity extends AppCompatActivity {

    TextView testScoreResult;

    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    private final String SCORE_KEY = "Score";
    private final String MULTI_KEY="multi";

    LinearLayout backgroundColors;
    final String TAG ="HHHH";
    String textMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_score);

        testScoreResult=(TextView) findViewById(R.id.testScoreResult);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);


        textMessage=myPreferences.getString(MULTI_KEY,"");


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


        testScoreResult.setText(textMessage);
    }
}
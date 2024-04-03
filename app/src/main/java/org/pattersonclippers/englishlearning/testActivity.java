package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class testActivity extends AppCompatActivity {

    Button firstChoiceBTN,secondChoiceBTN,nextBTN;
    TextView questionText,total_question,usernameTV;
    private SharedPreferences myPreferences;
    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    LinearLayout backgroundColors;
    String greetingUser;
    String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);

        firstChoiceBTN=(Button) findViewById(R.id.firstChoiceBTN);
        secondChoiceBTN=(Button) findViewById(R.id.secondChoiceBTN);
        nextBTN=(Button) findViewById(R.id.nextBTN);
        questionText=(TextView) findViewById(R.id.questionText) ;
        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);


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

        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent=new Intent(testActivity.this,CategoriesActivity.class);
               // myIntent.putExtra("Score",score);
                    startActivity(myIntent);

            }
        });
    }

}
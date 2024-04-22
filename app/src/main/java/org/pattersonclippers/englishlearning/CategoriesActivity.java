package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Objects;

public class CategoriesActivity extends AppCompatActivity {
    Button testBTN, practiceBTN;


    TextView practiceTV,testTV,greetingTV;

    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private SharedPreferences myPreferences;
    private final String Name_Key="name";
    private final String COLOR_KEY="colors";
    LinearLayout backgroundColors;


    String greetingUser;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        //Objects.requireNonNull(getSupportActionBar()).setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.skyblue)));

       testBTN=(Button) findViewById(R.id.testBTN);
        practiceBTN=(Button) findViewById(R.id.practiceBTN);
       greetingTV=(TextView)findViewById(R.id.greetingTV);
//        practiceTV=(TextView)findViewById(R.id.practiceTV);
//        testTV=(TextView) findViewById(R.id.testTV);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);


        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hello  " + name +" Welcome to English Learning App ";
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


        practiceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CategoriesActivity.this,TopicActivity.class);
                startActivity(intent);
            }
        });

        testBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CategoriesActivity.this,testActivity.class);
                startActivity(intent);
            }
        });






    }

}
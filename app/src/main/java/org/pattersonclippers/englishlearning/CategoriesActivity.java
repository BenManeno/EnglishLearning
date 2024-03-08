package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CategoriesActivity extends AppCompatActivity {
    Button testBTN, practiceBTN;


    TextView practiceTV,testTV,greetingTV;

    private String fileName= "org.pattersonclippers.EnglishLearning.App";
    private SharedPreferences myPreferences;
    private final String Name_Key="name";


    String greetingUser;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

//        testBTN=(Button) findViewById(R.id.testBTN);
        practiceBTN=(Button) findViewById(R.id.practiceBTN);
       greetingTV=(TextView)findViewById(R.id.greetingTV);
//        practiceTV=(TextView)findViewById(R.id.practiceTV);
//        testTV=(TextView) findViewById(R.id.testTV);


        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);

        name= myPreferences.getString(Name_Key,"");
        greetingUser = "Hello  " + name +" Welcome to English Learning App ";
        greetingTV.setText(greetingUser);


        practiceBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(CategoriesActivity.this,practiceActivity.class);
                startActivity(intent);
            }
        });






    }

}
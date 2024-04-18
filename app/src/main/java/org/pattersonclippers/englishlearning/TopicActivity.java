package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopicActivity extends AppCompatActivity {

    private String fileName= "org.pattersonclippers.countryquiz.quizApp";
    private SharedPreferences myPreferences;

    private final String categoryKey="category";

    Button tobeBTN,pastTenseBTN;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        tobeBTN=(Button) findViewById(R.id.tobeBTN);
        pastTenseBTN=(Button) findViewById(R.id.pastTenseBTN);

        myPreferences=getSharedPreferences(fileName,MODE_PRIVATE);


        tobeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TopicActivity.this,practiceActivity.class);
                intent.putExtra(categoryKey,getString(R.string.CategoryOne));
                startActivity(intent);


            }
        });

        pastTenseBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TopicActivity.this,practiceActivity.class);
                intent.putExtra(categoryKey,getString(R.string.CategoryTwo));
                startActivity(intent);

            }
        });
    }

}
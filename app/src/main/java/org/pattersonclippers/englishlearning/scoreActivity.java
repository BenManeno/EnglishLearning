package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class scoreActivity extends AppCompatActivity {
    Button openTB;
    TextView scoreTV;
    int score=0;
    Intent incomingIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        openTB=(Button) findViewById(R.id.openTB);
        scoreTV=(TextView)findViewById(R.id.scoreTV);
        score =0;




        openTB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(scoreActivity.this,progressActivity.class);
                startActivity(myIntent);
            }
        });
        incomingIntent=getIntent();
        score=incomingIntent.getIntExtra("Score",0);

        scoreTV.setText("Your score is  "+score);


    }
}
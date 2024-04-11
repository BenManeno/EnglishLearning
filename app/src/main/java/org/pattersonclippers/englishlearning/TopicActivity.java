package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopicActivity extends AppCompatActivity {


    Button toBe,pastTense;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topic);

        toBe =(Button)findViewById(R.id.tobe);
        pastTense=(Button) findViewById(R.id.pastTense);


        toBe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TopicActivity.this,practiceActivity.class);
                startActivity(intent);
            }
        });

        pastTense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(TopicActivity.this,practiceActivity.class);
                startActivity(intent);
            }
        });


    }

}
package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class practiceActivity extends AppCompatActivity {

    CheckBox firstChoiceBox,secondChoiceBox;

    Button nextBTN;

    int score;
    int RightIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);


        firstChoiceBox=(CheckBox) findViewById(R.id.firstChoiceBox);
        secondChoiceBox=(CheckBox) findViewById(R.id.secondChoiceBox);
        nextBTN=(Button) findViewById(R.id.nextBTN);





        nextBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent newIntent =new Intent(practiceActivity.this,CategoriesActivity.class);
                startActivity(newIntent);
            }
        });



        firstChoiceBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
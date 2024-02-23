package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    Button saveBTN, loginBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameET=(EditText) findViewById(R.id.nameTV);
        saveBTN=(Button) findViewById(R.id.saveBTN);
        loginBTN=(Button) findViewById(R.id.loginBTN);



        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CategoriesActivity.class);
                startActivity(intent);
            }
        });

    }



}
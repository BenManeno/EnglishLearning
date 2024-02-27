package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nameET;
    Button saveBTN, loginBTN;
    private SharedPreferences myPreferences;
    private String fileName = "org.pattersonclippers.EnglishLearning.App";
    private final String NAME_KEY = "name";
    SharedPreferences.Editor preferencesEditor;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameET=(EditText) findViewById(R.id.nameTV);
        saveBTN=(Button) findViewById(R.id.saveBTN);
        loginBTN=(Button) findViewById(R.id.loginBTN);
        userName="";


        myPreferences = getSharedPreferences(fileName, MODE_PRIVATE);
        preferencesEditor = myPreferences.edit();





        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,CategoriesActivity.class);
                startActivity(intent);
            }
        });

        saveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName=nameET.getText().toString();
                preferencesEditor.putString(NAME_KEY,userName);
                preferencesEditor.apply();
            }
        });

    }



}
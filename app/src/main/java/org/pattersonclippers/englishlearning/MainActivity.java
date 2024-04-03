package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameET,pwET;
    Button saveBTN, loginBTN;
    RadioButton silver,vanilla,skyBlue,yellow;
    LinearLayout backgroundColors;
    final String TAG ="HHHH";

    private SharedPreferences myPreferences;
    private String fileName = "org.pattersonclippers.EnglishLearning.App";
    private final String NAME_KEY = "name";
    private final String COLOR_KEY = "colors";
    SharedPreferences.Editor preferencesEditor;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nameET=(EditText) findViewById(R.id.nameTV);
        pwET=(EditText) findViewById(R.id.pwET);
        saveBTN=(Button) findViewById(R.id.saveBTN);
        loginBTN=(Button) findViewById(R.id.loginBTN);
        userName="";
        silver=(RadioButton) findViewById(R.id.silver);
        vanilla=(RadioButton) findViewById(R.id.vanilla);
        skyBlue=(RadioButton) findViewById(R.id.skyblue);
        yellow=(RadioButton) findViewById(R.id.yellow);
        backgroundColors=(LinearLayout) findViewById(R.id.backgroundColors);


        myPreferences = getSharedPreferences(fileName, MODE_PRIVATE);
        preferencesEditor = myPreferences.edit();

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





        loginBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d(TAG,"Hello");

                if(pwET.getText().toString().equals("777")){
                    Log.d(TAG,pwET.getText().toString());

                    Toast.makeText(MainActivity.this,"Login Successful  ",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,CategoriesActivity.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(MainActivity.this,"Wrong password try again ",Toast.LENGTH_SHORT).show();
                }


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

        silver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColors.setBackgroundColor(getResources().getColor(R.color.Silver));
                preferencesEditor.putInt(COLOR_KEY,R.color.Silver);
                preferencesEditor.apply();
            }
        });
        vanilla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColors.setBackgroundColor(getResources().getColor(R.color.vanilla));
                preferencesEditor.putInt(COLOR_KEY,R.color.vanilla);
                preferencesEditor.apply();
            }
        });
        skyBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColors.setBackgroundColor(getResources().getColor(R.color.skyblue));
                preferencesEditor.putInt(COLOR_KEY,R.color.skyblue);
                preferencesEditor.apply();
            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backgroundColors.setBackgroundColor(getResources().getColor(R.color.yellowOrange));
                preferencesEditor.putInt(COLOR_KEY,R.color.yellowOrange);
                preferencesEditor.apply();
            }
        });

    }



}
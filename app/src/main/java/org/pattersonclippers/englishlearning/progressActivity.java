package org.pattersonclippers.englishlearning;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class progressActivity extends AppCompatActivity {
    ProgressBar toBeProgress,simplepastprogressBar;
    TextView simplePastTV, tobeTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);


        toBeProgress=(ProgressBar) findViewById(R.id.tobeProgressBar);
        simplepastprogressBar=(ProgressBar) findViewById(R.id.simplepastprogressBar);

        simplepastprogressBar.setProgress(55);
        toBeProgress.setProgress(77);
    }
}
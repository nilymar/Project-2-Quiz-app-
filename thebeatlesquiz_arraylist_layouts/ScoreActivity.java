package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.score;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.userChanges;

public class ScoreActivity extends AppCompatActivity {
    public int mIndex;
    public Button exit;
    public Button startOver;
    public TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.score_layout);
        Intent myIntent = getIntent(); /*restoring data that was saved from intent call*/
        mIndex = myIntent.getIntExtra("index",0);
        exit = (Button) findViewById(R.id.exit_score); //finding the Exit button
        startOver = (Button) findViewById(R.id.start_over); //finding the start over button
        scoreText = (TextView) findViewById(R.id.score_text); //finding the TextView for the score message
        String scoreMessage = printScoreMessage(score, mIndex); // creating the score message using printScoreMessage method
        scoreText.setText(scoreMessage); //putting the score message in the scoreText TextView
        //  what happens when user press exit
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ScoreActivity.this, QuizActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("Exit me", true);
                startActivity(myIntent);
                finish();
            }
        });
        //  what happens when user press start over
        startOver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ScoreActivity.this, QuizActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("Start over", true);
                startActivity(myIntent);
                finish();
            }
        });
    }

    // method for creating the score message
    public String printScoreMessage(int score, int index) {
        String scoreString; //string for the score message
        int count = 0; //counter for the number of answer submitted
        for (int iLocal=0; iLocal<=(index-1); iLocal++) {//counting the number of answers that were submitted
            boolean mSubmit = userChanges.get(iLocal).getDidSubmit();
            if (mSubmit) count +=1;
        }
        if (score >= 80) scoreString = getResources().getString(R.string.score_toast1) +
                getResources().getString(R.string.total_score_text) + score;
        else if (score >= 60)
            scoreString = getResources().getString(R.string.score_toast2) +
                    getResources().getString(R.string.total_score_text) + score;
        else if (score >= 40)
            scoreString = getResources().getString(R.string.score_toast3) +
                    getResources().getString(R.string.total_score_text) + score;
        else scoreString = getResources().getString(R.string.score_toast4) +
                    getResources().getString(R.string.total_score_text) + score;
        scoreString += "\n\n";
        scoreString += getResources().getString(R.string.total_submit_text1);
        scoreString += count;
        scoreString += getResources().getString(R.string.total_submit_text2);
        scoreString += index;
        scoreString += getResources().getString(R.string.total_submit_text3);
        return scoreString;
    }

     // saving data for rotation the device
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("index", mIndex);
    }

    // this method will restore all the data saves in the previous method, when rotating the device
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mIndex = savedInstanceState.getInt("index");
        printScoreMessage(score, mIndex);
    }

    //when the user use backPress here - the app is exited
    @Override
    public void onBackPressed() {
            Intent myIntent = new Intent(this, QuizActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            myIntent.putExtra("Exit me", true);
            startActivity(myIntent);
            finish();
    }
}

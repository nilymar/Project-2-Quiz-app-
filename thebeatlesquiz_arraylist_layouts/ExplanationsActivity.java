package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//  class to display the explanation screen
public class ExplanationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanations);
        Button startQuiz = findViewById(R.id.start_quiz); //after pressing this button the quiz will start
        startQuiz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuizActivity.class);
                startActivity(myIntent);
            }
        });
    }
}

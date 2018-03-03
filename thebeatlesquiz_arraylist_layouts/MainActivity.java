package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

//  class to display the opening screen
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button start = findViewById(R.id.start_button); //pressing this bring you to the explanation screen
        start.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ExplanationsActivity.class);
                startActivity(myIntent);
            }
        });

        /**what happens when the user press the exit button in the score screen*/
        if( getIntent().getBooleanExtra("Exit me", false)){
            super.onBackPressed();
            finish();
            System.exit(0);
            // add this to prevent from doing unnecessary stuffs
            return; // add this to prevent from doing unnecessary stuffs
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        System.exit(0);
    }
}

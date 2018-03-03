package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.displayQuestion;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.score;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.userChanges;

// this class display a RadioGroup question on screen
public class RadioGroupActivity extends AppCompatActivity {
    public TextView question;  //location for displaying the question text
    //  the Radio buttons in display
    public RadioButton rb1;
    public RadioButton rb2;
    public RadioButton rb3;
    public RadioButton rb4;
    public TextView answerText;  //location for the coded answer
    public Button submit; //button for submitting an answer
    public Button next; //button for moving to next question / score screen
    public Button back;  //button for moving to previous question / explanation screen
    private Question mQuestion; //object for current question
    private Answer mAnswer; //object for current answer
    private int mScore = 0; //the score for the questions that were already passed / the score in the beginning
    public int mIndex; //the location in the questions and answers arrays
    public int iLocal; //the size of the question and answer arrays
    private int mWhatAnswer = 0; //what the user chose (0 for no user choice)
    private boolean mDidSubmit = false; //did the user press submit (will go back to false if didn't chose an option)
//    private Context mContext;  //the context for this activity (to use in "displayQuestion" method)
    private String mCodedAnswer = ""; //the coded answer (what will be display in answerText TextView)
    private int mAnswerColor; //the color for that answer - different for right and wrong answers

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_group_question);
        Intent myIntent = getIntent(); //restoring data that was saved from intent call
        String mQuestionText = myIntent.getStringExtra("questionText");
        String mQuesOp1 = myIntent.getStringExtra("quesOp1");
        String mQuesOp2 = myIntent.getStringExtra("quesOp2");
        String mQuesOp3 = myIntent.getStringExtra("quesOp3");
        String mQuesOp4 = myIntent.getStringExtra("quesOp4");
        String mBl1 = myIntent.getStringExtra("bl1");
        String mBl2 = myIntent.getStringExtra("bl2");
        String mBl3 = myIntent.getStringExtra("bl3");
        String mBl4 = myIntent.getStringExtra("bl4");
        String mAnsOp1 = myIntent.getStringExtra("ansOp1");
        String mAnsOp2 = myIntent.getStringExtra("ansOp2");
        String mAnsOp3 = myIntent.getStringExtra("ansOp3");
        String mAnsOp4 = myIntent.getStringExtra("ansOp4");
        mIndex = myIntent.getIntExtra("index", 0);
        iLocal = myIntent.getIntExtra("i", 0);
        /* starting the process of calculating score and displaying the restored data and the text answers for each question*/
        //finding the TextView for the answer text and making it invisible
        answerText = (TextView) findViewById(R.id.answer_text);
        answerText.setVisibility(View.GONE);
        next = (Button) findViewById(R.id.next_button); //finding the Next button
        back = (Button) findViewById(R.id.back_button); //finding the back button
        submit = (Button) findViewById(R.id.submit_button); //finding the Submit button
        //finding the question text TextView and putting the question text in it
        question = (TextView) findViewById(R.id.radio_group_question_text);
        question.setText(mQuestionText);
        //finding all the RadioButtons and putting the right text in each one
        rb1 = findViewById(R.id.rd_op1);
        rb1.setText(mQuesOp1);
        rb2 = findViewById(R.id.rd_op2);
        rb2.setText(mQuesOp2);
        rb3 = findViewById(R.id.rd_op3);
        rb3.setText(mQuesOp3);
        rb4 = findViewById(R.id.rd_op4);
        rb4.setText(mQuesOp4);
        //create a new Question object with the data for current question
        mQuestion = new Question("RadioGroup", mQuestionText, mQuesOp1, mBl1, mQuesOp2, mBl2,
                mQuesOp3, mBl3, mQuesOp4, mBl4);
        //create a new Answer object with the data for current answers
        mAnswer = new Answer(mAnsOp1, mAnsOp2, mAnsOp3, mAnsOp4);
        //if this question was created before - restore the data that was saved
        restoreUserChanges();
        //set onClickListener for the submit button - when it's pressed check the answer using checkAnswer method
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDidSubmit = true;
                checkAnswer();
            }
        });
        //set onClickListener for the next button
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (iLocal == (mIndex - 1)&&(!mDidSubmit))
                    makeScoreToast(); //if it is the last question make a score toast anyway even if didn't submit
                saveUserChanges(); //save the data before moving to next question
                iLocal += 1; //next i
                mQuestion = null; //delete the question object
                mAnswer = null; //delete the answer object
                displayQuestion(RadioGroupActivity.this, iLocal, mIndex);//display next question
                finish(); //finish this activity
            }
        });
        //set onClickListener for the back button
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // use the changed onBackPressed method for the back button
            }
        });
    }

    //local method to check the user answers
    private void checkAnswer() {
        answerText = findViewById(R.id.answer_text);//just in case it didn't go through onCreatedView
        answerText.setVisibility(View.VISIBLE);//now we need the TextView to be shown
        //check the RadioButtons to see if one is clicked - then the buttons are disabled and the answer is checked
        //if the answer is true - add 10 points to the score and write the corresponding answer in the right color
        //if the answer is wrong - write the corresponding answer with the color for wrong answer
        if (rb1.isChecked()) {
            mWhatAnswer = 1; //save the option that was clicked
            //  can't submit anymore
            submit.setVisibility(View.GONE);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            if (mQuestion.getBl1().equals("true")) { //if the option was true
                mScore = 10; //change the local score
                mCodedAnswer = mAnswer.getOp1();
                mAnswerColor = getResources().getColor(R.color.rightAnswer); //put the color for right answer in memory
                answerText.setTextColor(mAnswerColor); //set the color to the TextView
                answerText.setText(mCodedAnswer); //set the codded answer to the TextView
                makeScoreToast(); //make a score toast
            } else {
                mCodedAnswer = mAnswer.getOp1(); //put the right codded option
                mAnswerColor = getResources().getColor(R.color.wrongAnswer);  //put the color for wrong answer in memory
                answerText.setTextColor(mAnswerColor); //set the color to the TextView
                answerText.setText(mCodedAnswer); //set the codded answer to the TextView
                makeScoreToast(); //make a score toast
            }
        } else if (rb2.isChecked()) {
            mWhatAnswer = 2; //save the option that was clicked
            //  can't submit anymore
            submit.setVisibility(View.GONE);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            if (mQuestion.getBl2().equals("true")) {
                mScore = 10;
                mCodedAnswer = mAnswer.getOp2();
                mAnswerColor = getResources().getColor(R.color.rightAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            } else {
                mCodedAnswer = mAnswer.getOp2();
                mAnswerColor = getResources().getColor(R.color.wrongAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            }
        } else if (rb3.isChecked()) {
            mWhatAnswer = 3; //save the option that was clicked
            //  can't submit anymore
            submit.setVisibility(View.GONE);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            if (mQuestion.getBl3().equals("true")) {
                mScore = 10;
                mCodedAnswer = mAnswer.getOp3();
                mAnswerColor = getResources().getColor(R.color.rightAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            } else {
                mCodedAnswer = mAnswer.getOp3();
                mAnswerColor = getResources().getColor(R.color.wrongAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            }
        } else if (rb4.isChecked()) {
            mWhatAnswer = 4; //save the option that was clicked
            //  can't submit anymore
            submit.setVisibility(View.GONE);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            if (mQuestion.getBl4().equals("true")) {
                mScore = 10;
                mCodedAnswer = mAnswer.getOp4();
                mAnswerColor = getResources().getColor(R.color.rightAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            } else {
                mCodedAnswer = mAnswer.getOp4();
                mAnswerColor = getResources().getColor(R.color.wrongAnswer);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                makeScoreToast();
            }
            // if no options was marked
        } else {
            mWhatAnswer = 0; //no choice was made
            mScore = 0; //just to make sure
            mDidSubmit = false; //set submit to false
            //  let the user no he didn't choose anything
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    getString(R.string.no_answer_text), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 240);
            toast.show();
            answerText.setVisibility(View.GONE);
        }
    }

    //  creating a toast message
    private void makeScoreToast() {
        score += mScore;  //update the total score
        if (iLocal < (mIndex - 1)) {
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    getString(R.string.current_score_text) + " " + score, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 240);
            toast.show();
        } else {
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    getString(R.string.total_score_text) + " " + score, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 240);
            toast.show();
        }
    }

    /**
     * saving data for rotation the device
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveUserChanges();
    }

    //  this method will restore all the data saves in the previous method, when rotating the device
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restoreUserChanges();
    }

    //  saving the changes to userChanges array list
    public void saveUserChanges() {
        //checking what (if) the user chose - in case he didn't press submit
        if (rb1.isChecked()) mWhatAnswer = 1;
        else if (rb2.isChecked()) mWhatAnswer = 2;
        else if (rb3.isChecked()) mWhatAnswer = 3;
        else if (rb4.isChecked()) mWhatAnswer = 4;
        else mWhatAnswer = 0;
        int userChangesSize = userChanges.size();
        if (userChangesSize == iLocal) { //no object was saved in the userChanges array
            userChanges.add(new UserChange(mScore, mWhatAnswer,
                    mDidSubmit, mCodedAnswer, mAnswerColor));
        } else { //if there is an object in the array - update it
            userChanges.get(iLocal).putScore(mScore);
            userChanges.get(iLocal).putWhatAnswerRadio(mWhatAnswer);
            userChanges.get(iLocal).putDidSubmit(mDidSubmit);
            userChanges.get(iLocal).putCodedAnswer(mCodedAnswer);
            userChanges.get(iLocal).putAnswerColor(mAnswerColor);
        }
    }

    //  restoring data from userChanges array list
    public void restoreUserChanges() {
        int userChangesSize = userChanges.size();
        if (userChangesSize == iLocal) return; //no data was saved for this question
        else { //restore the data that was saved
            mScore = userChanges.get(iLocal).getScore();
            mWhatAnswer = userChanges.get(iLocal).getWhatAnswerRadio();
            mDidSubmit = userChanges.get(iLocal).getDidSubmit();
            mCodedAnswer = userChanges.get(iLocal).getCodedAnswer();
            mAnswerColor = userChanges.get(iLocal).getAnswerColor();
        }
        answerText = (TextView) findViewById(R.id.answer_text); //finding the TextView for the codded answer
        submit = (Button) findViewById(R.id.submit_button); //finding the Submit button
        //finding all the RadioButtons
        rb1 = findViewById(R.id.rd_op1);
        rb2 = findViewById(R.id.rd_op2);
        rb3 = findViewById(R.id.rd_op3);
        rb4 = findViewById(R.id.rd_op4);
        //putting what (if) the user chose - in the right radio button
        if (mWhatAnswer == 1) rb1.setChecked(true);
        else if (mWhatAnswer == 2) rb2.setChecked(true);
        else if (mWhatAnswer == 3) rb3.setChecked(true);
        else if (mWhatAnswer == 4) rb4.setChecked(true);
        if ((mWhatAnswer==0) && !mDidSubmit) {//in this case the radio buttons can still be pressed
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);
            answerText.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
            answerText.setVisibility(View.GONE);
        } else if ((mWhatAnswer!=0) && !mDidSubmit) {//an answer was marked but wasn't submitted
            //in this case the radio buttons can still be pressed
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);
            answerText.setVisibility(View.GONE);
            submit.setVisibility(View.VISIBLE);
            answerText.setVisibility(View.GONE);
            if (mWhatAnswer == 1) rb1.setChecked(true);
            else if (mWhatAnswer == 2) rb2.setChecked(true);
            else if (mWhatAnswer == 3) rb3.setChecked(true);
            else rb4.setChecked(true);
        } else if (mWhatAnswer==0) {//no answer was marked but the submit button was pressed
            //in this case the radio buttons can still be pressed
            rb1.setEnabled(true);
            rb2.setEnabled(true);
            rb3.setEnabled(true);
            rb4.setEnabled(true);
            submit.setVisibility(View.VISIBLE);
        } else  {//the user chose an answer and submitted it
            if (mWhatAnswer == 1) rb1.setChecked(true);
            else if (mWhatAnswer == 2) rb2.setChecked(true);
            else if (mWhatAnswer == 3) rb3.setChecked(true);
            else rb4.setChecked(true);
            rb1.setEnabled(false);
            rb2.setEnabled(false);
            rb3.setEnabled(false);
            rb4.setEnabled(false);
            answerText.setVisibility(View.VISIBLE);
            answerText.setTextColor(mAnswerColor);
            answerText.setText(mCodedAnswer);
            submit.setVisibility(View.GONE); // don't show the submit button
        }
    }

    //overriding the onBackPressed method to go back to last question if it is not the first question
    @Override
    public void onBackPressed() {
        if (iLocal > 0) {
            saveUserChanges(); //save the changes made by the user before leaving
            iLocal -= 1; //setting the right one
            mQuestion = null; //deleting the question objects data
            mAnswer = null; //deleting the answer object data
            displayQuestion(this, iLocal, mIndex); // moving to the right question
            finish();
        }
        //if it's the first question - it goes back to the explanations screen, but first delete the data to start over
        else {
            Intent myIntent = new Intent(this, QuizActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            myIntent.putExtra("Start over", true);
            startActivity(myIntent);
            finish();
        }
    }
}

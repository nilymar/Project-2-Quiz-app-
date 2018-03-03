package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.displayQuestion;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.score;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.userChanges;

//this class creates a multi-choice question on screen
public class MultiActivity extends AppCompatActivity {
    public TextView question; //location for displaying the question text
    // the check boxes for the possible answers
    public CheckBox cb1;
    public CheckBox cb2;
    public CheckBox cb3;
    public CheckBox cb4;
    public CheckBox cb5;
    public CheckBox cb6;
    public CheckBox cb7;
    public CheckBox cb8;
    public CheckBox cb9;
    public CheckBox cb10;
    public TextView answerText; //location for the coded answer
    public Button submit; //button for submitting an answer
    public Button next; //button for moving to next question / score screen
    public Button back; //button for moving to previous question / explanation screen
    private int mScore = 0; //the score for this questions
    public int mIndex; //the location in the questions and answers arrays
    public int iLocal; //the size of the question and answer arrays
    private Question mQuestion; //object for current question
    private Answer mAnswer; //object for current answer
    //  booleans to show if check box i was already checked in the saved changes
    private boolean mCb1IsChecked = false;
    private boolean mCb2IsChecked = false;
    private boolean mCb3IsChecked = false;
    private boolean mCb4IsChecked = false;
    private boolean mCb5IsChecked = false;
    private boolean mCb6IsChecked = false;
    private boolean mCb7IsChecked = false;
    private boolean mCb8IsChecked = false;
    private boolean mCb9IsChecked = false;
    private boolean mCb10IsChecked = false;
    private int maxCbsChecked = 5; //maximum number of checkboxes that can be checked
    private int mCbCheckedCount = 0; //a counter for the checkboxes that are checked
    private boolean mDidSubmit = false; //did the user made a legal submit (submitted with 5 answers)
//    private Context mContext; //the context for this activity (to use in "displayQuestion" method)
    private String mCodedAnswer = ""; //the coded answer (what will be display in answerText TextView)
    private int mAnswerColor; //the color for that answer - different for right and wrong answers

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.multi_option_question);
        Intent myIntent = getIntent();
        //  restoring data from the intent call
        mIndex = myIntent.getIntExtra("index", 0);
        iLocal = myIntent.getIntExtra("i", 0);
        String mQuestionText = myIntent.getStringExtra("questionText");
        String mQuesOp1 = myIntent.getStringExtra("quesOp1");
        String mQuesOp2 = myIntent.getStringExtra("quesOp2");
        String mQuesOp3 = myIntent.getStringExtra("quesOp3");
        String mQuesOp4 = myIntent.getStringExtra("quesOp4");
        String mQuesOp5 = myIntent.getStringExtra("quesOp5");
        String mQuesOp6 = myIntent.getStringExtra("quesOp6");
        String mQuesOp7 = myIntent.getStringExtra("quesOp7");
        String mQuesOp8 = myIntent.getStringExtra("quesOp8");
        String mQuesOp9 = myIntent.getStringExtra("quesOp9");
        String mQuesOp10 = myIntent.getStringExtra("quesOp10");
        String mBl1 = myIntent.getStringExtra("bl1");
        String mBl2 = myIntent.getStringExtra("bl2");
        String mBl3 = myIntent.getStringExtra("bl3");
        String mBl4 = myIntent.getStringExtra("bl4");
        String mBl5 = myIntent.getStringExtra("bl5");
        String mBl6 = myIntent.getStringExtra("bl6");
        String mBl7 = myIntent.getStringExtra("bl7");
        String mBl8 = myIntent.getStringExtra("bl8");
        String mBl9 = myIntent.getStringExtra("bl9");
        String mBl10 = myIntent.getStringExtra("bl10");
        String mAnsOp1 = myIntent.getStringExtra("ansOp1");
        String mAnsOp2 = myIntent.getStringExtra("ansOp2");
        /* starting the process of displaying the restored data and the text answers for each question*/
        //  finding the TextView for the answer text and making it invisible
        answerText = (TextView) findViewById(R.id.answer_text_multi);
        answerText.setVisibility(View.GONE); //only need to be seen after the user does a legal submit
        next = (Button) findViewById(R.id.next_button_multi); //finding the Next button
        back = (Button) findViewById(R.id.back_button_multi); //finding the back button
        submit = (Button) findViewById(R.id.submit_button_multi); //finding the Submit button
        //  finding the question text TextView and putting the question text in it
        question = (TextView) findViewById(R.id.multi_option_question_text);
        question.setText(mQuestionText);
        //  finding all the CheckBoxes and putting the right text in each one
        cb1 = findViewById(R.id.multi_op1);
        cb1.setText(mQuesOp1);
        cb2 = findViewById(R.id.multi_op2);
        cb2.setText(mQuesOp2);
        cb3 = findViewById(R.id.multi_op3);
        cb3.setText(mQuesOp3);
        cb4 = findViewById(R.id.multi_op4);
        cb4.setText(mQuesOp4);
        cb5 = findViewById(R.id.multi_op5);
        cb5.setText(mQuesOp5);
        cb6 = findViewById(R.id.multi_op6);
        cb6.setText(mQuesOp6);
        cb7 = findViewById(R.id.multi_op7);
        cb7.setText(mQuesOp7);
        cb8 = findViewById(R.id.multi_op8);
        cb8.setText(mQuesOp8);
        cb9 = findViewById(R.id.multi_op9);
        cb9.setText(mQuesOp9);
        cb10 = findViewById(R.id.multi_op10);
        cb10.setText(mQuesOp10);
        //  put the data for current question in the local question object
        mQuestion = new Question("Multi", mQuestionText,
                mQuesOp1, mBl1,
                mQuesOp2, mBl2,
                mQuesOp3, mBl3,
                mQuesOp4, mBl4,
                mQuesOp5, mBl5,
                mQuesOp6, mBl6,
                mQuesOp7, mBl7,
                mQuesOp8, mBl8,
                mQuesOp9, mBl9,
                mQuesOp10, mBl10);
        //  put the data for current answer in the local answer object
        mAnswer = new Answer(mAnsOp1, mAnsOp2);
        //  if the question was created before - restore the data saved
        restoreUserChanges();
        //  creating listener for the check boxes so that only 5 can be checked
        final CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (cb.isChecked() && (mCbCheckedCount == maxCbsChecked)) {
                    cb.setChecked(false);
                } else if (cb.isChecked() && (mCbCheckedCount < maxCbsChecked))
                    mCbCheckedCount += 1;
                else if (!cb.isChecked()) mCbCheckedCount -= 1;
            }
        };
        //  setting the listeners to the checkboxes
        cb1.setOnCheckedChangeListener(checker);
        cb2.setOnCheckedChangeListener(checker);
        cb3.setOnCheckedChangeListener(checker);
        cb4.setOnCheckedChangeListener(checker);
        cb5.setOnCheckedChangeListener(checker);
        cb6.setOnCheckedChangeListener(checker);
        cb7.setOnCheckedChangeListener(checker);
        cb8.setOnCheckedChangeListener(checker);
        cb9.setOnCheckedChangeListener(checker);
        cb10.setOnCheckedChangeListener(checker);
        //  set onClickListener for the submit button - when it's pressed  - check if the number
        //  of options he marked is right if not - make a toast message, otherwise - check the answer
        //  using checkAnswer method
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mCbCheckedCount < 5) {
                    mDidSubmit = false;
                    Toast.makeText(MultiActivity.this, getResources().getString(R.string.qs10_error2), Toast.LENGTH_LONG).show();
                    return;
                } else {
                    submit.setVisibility(View.GONE);
                    mDidSubmit = true;
                    checkAnswer();
                }
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
                displayQuestion(MultiActivity.this, iLocal, mIndex);//display next question
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

    //  local method to check the user answers - only if all the marked answers are true the user get points
    public void checkAnswer() {
        answerText = findViewById(R.id.answer_text_multi); //just in case it didn't go through onCreatedView
        answerText.setVisibility(View.VISIBLE); //now we need the TextView to be shown
        int countTrue = 0; //counter for the right answers - for the purpose of choosing the color of text in the answer
        //  if the user marked the option - if it's true add 2 points to the score and 1 to the countTrue variable
        if (cb1.isChecked()) {
            if (mQuestion.getBl1().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb2.isChecked()) {
            if (mQuestion.getBl2().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb3.isChecked()) {
            if (mQuestion.getBl3().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb4.isChecked()) {
            if (mQuestion.getBl4().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb5.isChecked()) {
            if (mQuestion.getBl5().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb6.isChecked()) {
            if (mQuestion.getBl6().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb7.isChecked()) {
            if (mQuestion.getBl7().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb8.isChecked()) {
            if (mQuestion.getBl8().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb9.isChecked()) {
            if (mQuestion.getBl9().equals("true")) {
                countTrue += 1;
            }
        }
        if (cb10.isChecked()) {
            if (mQuestion.getBl10().equals("true")) {
                countTrue += 1;
            }
        }
        if (countTrue == 5) { //if all the options the user marked are true - get 10 points
            mScore = 10;
            mCodedAnswer = mAnswer.getOp1();
            mAnswerColor = getResources().getColor(R.color.rightAnswer);
            answerText.setTextColor(mAnswerColor);
            answerText.setText(mCodedAnswer);
        } else { // if not all the options the user marked are true - doesn't get any points
            mCodedAnswer = mAnswer.getOp2();
            mAnswerColor = getResources().getColor(R.color.wrongAnswer);
            answerText.setTextColor(mAnswerColor);
            answerText.setText(mCodedAnswer);
        }
        //  the user can't make changes to the check boxes anymore after submitting his answers
        cb1.setEnabled(false);
        cb2.setEnabled(false);
        cb3.setEnabled(false);
        cb4.setEnabled(false);
        cb5.setEnabled(false);
        cb6.setEnabled(false);
        cb7.setEnabled(false);
        cb8.setEnabled(false);
        cb9.setEnabled(false);
        cb10.setEnabled(false);
        //  make a toast for the current score
        makeScoreToast();
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

    //  saving data for rotation the device
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
        int userChangesSize = userChanges.size();
        //checking what (if) the user chose - in case he didn't press submit
        mCb1IsChecked = cb1.isChecked();
        mCb2IsChecked = cb2.isChecked();
        mCb3IsChecked = cb3.isChecked();
        mCb4IsChecked = cb4.isChecked();
        mCb5IsChecked = cb5.isChecked();
        mCb6IsChecked = cb6.isChecked();
        mCb7IsChecked = cb7.isChecked();
        mCb8IsChecked = cb8.isChecked();
        mCb9IsChecked = cb9.isChecked();
        mCb10IsChecked = cb10.isChecked();
        if (userChangesSize == iLocal) {  //create new userChange object for the question if there wasn't one
            userChanges.add(new UserChange(mScore, mCb1IsChecked,
                    mCb2IsChecked, mCb3IsChecked, mCb4IsChecked, mCb5IsChecked, mCb6IsChecked, mCb7IsChecked,
                    mCb8IsChecked, mCb9IsChecked, mCb10IsChecked, mDidSubmit, mCodedAnswer, mAnswerColor,
                    mCbCheckedCount));
        } else { //if a userChanges object was made before - save the current changes to it
            userChanges.get(iLocal).putScore(mScore);
            userChanges.get(iLocal).putCb1(mCb1IsChecked);
            userChanges.get(iLocal).putCb2(mCb2IsChecked);
            userChanges.get(iLocal).putCb3(mCb3IsChecked);
            userChanges.get(iLocal).putCb4(mCb4IsChecked);
            userChanges.get(iLocal).putCb5(mCb5IsChecked);
            userChanges.get(iLocal).putCb6(mCb6IsChecked);
            userChanges.get(iLocal).putCb7(mCb7IsChecked);
            userChanges.get(iLocal).putCb8(mCb8IsChecked);
            userChanges.get(iLocal).putCb9(mCb9IsChecked);
            userChanges.get(iLocal).putCb10(mCb10IsChecked);
            userChanges.get(iLocal).putDidSubmit(mDidSubmit);
            userChanges.get(iLocal).putCodedAnswer(mCodedAnswer);
            userChanges.get(iLocal).putAnswerColor(mAnswerColor);
            userChanges.get(iLocal).putCbCheckedCount(mCbCheckedCount);
        }
    }

    //  restoring data from userChanges array list
    public void restoreUserChanges() {
        int userChangesSize = userChanges.size(); //the size of the userChanges array
        if (userChangesSize == iLocal) return; //user didn't make any changes yet - don't restore
        else { //restoring the data that was saved
            mScore = userChanges.get(iLocal).getScore();
            mCb1IsChecked = userChanges.get(iLocal).getCb1();
            mCb2IsChecked = userChanges.get(iLocal).getCb2();
            mCb3IsChecked = userChanges.get(iLocal).getCb3();
            mCb4IsChecked = userChanges.get(iLocal).getCb4();
            mCb5IsChecked = userChanges.get(iLocal).getCb5();
            mCb6IsChecked = userChanges.get(iLocal).getCb6();
            mCb7IsChecked = userChanges.get(iLocal).getCb7();
            mCb8IsChecked = userChanges.get(iLocal).getCb8();
            mCb9IsChecked = userChanges.get(iLocal).getCb9();
            mCb10IsChecked = userChanges.get(iLocal).getCb10();
            mDidSubmit = userChanges.get(iLocal).getDidSubmit();
            mCodedAnswer = userChanges.get(iLocal).getCodedAnswer();
            mAnswerColor = userChanges.get(iLocal).getAnswerColor();
            mCbCheckedCount = userChanges.get(iLocal).getCbCheckedCount();
            //  displaying the changes made on screen
            answerText = (TextView) findViewById(R.id.answer_text_multi); //finding the TextView for the codded answer
            submit = (Button) findViewById(R.id.submit_button_multi); //finding the Submit button
            //finding all the CheckBoxes (just in case)
            cb1 = findViewById(R.id.multi_op1);
            cb2 = findViewById(R.id.multi_op2);
            cb3 = findViewById(R.id.multi_op3);
            cb4 = findViewById(R.id.multi_op4);
            cb5 = findViewById(R.id.multi_op5);
            cb6 = findViewById(R.id.multi_op6);
            cb7 = findViewById(R.id.multi_op7);
            cb8 = findViewById(R.id.multi_op8);
            cb9 = findViewById(R.id.multi_op9);
            cb10 = findViewById(R.id.multi_op10);
            //setting the checked status in all the checkboxes
            cb1.setChecked(mCb1IsChecked);
            cb2.setChecked(mCb2IsChecked);
            cb3.setChecked(mCb3IsChecked);
            cb4.setChecked(mCb4IsChecked);
            cb5.setChecked(mCb5IsChecked);
            cb6.setChecked(mCb6IsChecked);
            cb7.setChecked(mCb7IsChecked);
            cb8.setChecked(mCb8IsChecked);
            cb9.setChecked(mCb9IsChecked);
            cb10.setChecked(mCb10IsChecked);
            if (!mDidSubmit) { //meaning that the user didn't do a good submit or didn't press submit at all
                //in this case the check boxes can still be marked
                cb1.setEnabled(true);
                cb2.setEnabled(true);
                cb3.setEnabled(true);
                cb4.setEnabled(true);
                cb5.setEnabled(true);
                cb6.setEnabled(true);
                cb7.setEnabled(true);
                cb8.setEnabled(true);
                cb9.setEnabled(true);
                cb10.setEnabled(true);
                submit.setVisibility(View.VISIBLE); //the user can do submit
                answerText.setVisibility(View.GONE); //no coded answer to show
            } else { //the user did a good submit
                //  in this case the check buttons cannot be pressed anymore
                cb1.setEnabled(false);
                cb2.setEnabled(false);
                cb3.setEnabled(false);
                cb4.setEnabled(false);
                cb5.setEnabled(false);
                cb6.setEnabled(false);
                cb7.setEnabled(false);
                cb8.setEnabled(false);
                cb9.setEnabled(false);
                cb10.setEnabled(false);
                answerText.setVisibility(View.VISIBLE); //now this needs to be shown
                answerText.setTextColor(mAnswerColor); //in the right color
                answerText.setText(mCodedAnswer); //with the coded answer
                submit.setVisibility(View.GONE); // don't need the submit button anymore
            }
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


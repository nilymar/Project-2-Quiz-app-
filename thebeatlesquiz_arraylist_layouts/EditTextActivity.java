package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.displayQuestion;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.score;
import static com.example.android.thebeatlesquiz_arraylist_layouts.QuizActivity.userChanges;

//  this class display an EditText question on screen
public class EditTextActivity extends AppCompatActivity {
    public TextView question;  //location for displaying the question text
    public EditText userInput; //locate the EditText view where the user put's is answer
    public TextView answerText; //location for the coded answer
    public Button submit; //button for submitting an answer
    public Button next; //button for moving to next question / score screen
    public Button back; //button for moving to previous question / explanation screen
    private int mScore = 0; //the score for this questions
    public int mIndex; //the location in the questions and answers arrays
    public int iLocal; //the size of the question and answer arrays
    private Question mQuestion; //object for current question
    private Answer mAnswer; //object for current answer
    private String mWhatAnswer = ""; //what the user wrote
    private boolean mDidSubmit = false; //did the user press submit (will go back to false if did not write answer)
    private String mCodedAnswer = ""; //the coded answer (what will be display in answerText TextView)
    private int mAnswerColor; //the color for that answer - different for right and wrong answers
//    private Context mContext; //the context for this activity (to use in "displayQuestion" method)

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_text_question);
        Intent myIntent = getIntent(); /*restoring data that was saved from intent call*/
        String mQuestionText = myIntent.getStringExtra("questionText");
        String mQuesOp1 = myIntent.getStringExtra("quesOp1");
        String mAnsOp1 = myIntent.getStringExtra("ansOp1");
        String mAnsOp2 = myIntent.getStringExtra("ansOp2");
        mIndex = myIntent.getIntExtra("index", 0);
        iLocal = myIntent.getIntExtra("i", 0);
        //  finding the locations and displaying the question on screen
        answerText = (TextView) findViewById(R.id.answer_text_edit_text);//where the coded answer is displayed
        answerText.setVisibility(View.GONE);
        next = (Button) findViewById(R.id.next_button_edit_text); //finding the Next button
        back = (Button) findViewById(R.id.back_button_edit_text); //finding the back button
        submit = (Button) findViewById(R.id.submit_button_edit_text); //finding the Submit button
        //  finding the question text TextView and putting the question text in it
        question = (TextView) findViewById(R.id.edit_text_question_text);
        question.setText(mQuestionText);
        //  create a new Question object with the data for current question
        mQuestion = new Question("EditText", mQuestionText, mQuesOp1);
        //  create a new Answer object with the data for current answers
        mAnswer = new Answer(mAnsOp1, mAnsOp2);
        //  if the question was created before - restoring the data saved
        restoreUserChanges();
        //  set onClickListener for the submit button - when it's pressed check the answer using checkAnswer method
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
                displayQuestion(EditTextActivity.this, iLocal, mIndex);//display next question
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

    //  local method to check the user answer (if there is one)
    public void checkAnswer() {
        answerText = findViewById(R.id.answer_text_edit_text); //finding the TextView where the codded answer will be displayed
        userInput = findViewById(R.id.edit_text_user_input); //finding the userInput - if there is any
        submit = findViewById(R.id.submit_button_edit_text); //finding the submit button
        String userAnswer = userInput.getText().toString().trim(); //getting the user input from the EditText
        //  what happens if the user didn't write anything
        if (TextUtils.isEmpty(userAnswer)) {
            mWhatAnswer = ""; //putting empty string in that case
            mDidSubmit = false; //the submit action is invalid
            userInput.setEnabled(true); //the user would be able to put an answer if he wants
            //  a toast message to notify the user he didn't answer the question
            Toast toast = Toast.makeText(this.getApplicationContext(),
                    getString(R.string.no_answer_text), Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.BOTTOM, 0, 240);
            toast.show();
            answerText.setVisibility(View.GONE); //no need to show a coded answer
        } else {
            if (userAnswer.equalsIgnoreCase(mQuestion.getOp1())) { //what happens if the user put the right answer
                mWhatAnswer = userAnswer; //put the user answer in memory
                mScore = 10; //the score is updated to indicate good answer
                submit.setVisibility(View.GONE); //the user can't submit something else
                answerText.setVisibility(View.VISIBLE); //the place for the codded answer is made visible
                userInput.setEnabled(false);  // the user would'nt be able to change it after submitting his answer
                mAnswerColor = getResources().getColor(R.color.rightAnswer); //gets the color for a right answer
                answerText.setTextColor(mAnswerColor); //set the right color
                mCodedAnswer = mAnswer.getOp1(); //get the codded answer for right answer
                answerText.setText(mCodedAnswer); //set the codded answer in its TextView
                makeScoreToast(); //make a score toast
            } else { //what happens if the user put the wrong answer
                mWhatAnswer = userAnswer; //save this answer
                submit.setVisibility(View.GONE); //can't submit something else
                answerText.setVisibility(View.VISIBLE);  //the place for the codded answer is made visible
                userInput.setEnabled(false);  // the user would'nt be able to change it after submitting his answer
                mAnswerColor = getResources().getColor(R.color.wrongAnswer); //gets the color for a wrong answer
                answerText.setTextColor(mAnswerColor); //set that color in the TextView
                mCodedAnswer = mAnswer.getOp2(); //get the codded answer for wrong answer
                answerText.setText(mCodedAnswer); //set the codded answer in its TextView
                makeScoreToast(); //make a score toast
            }
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
        //  just in case the user did not press submit
        userInput = findViewById(R.id.edit_text_user_input);//finding the userInput
        mWhatAnswer = userInput.getText().toString();//getting the user input - if there is one
        int userChangesSize = userChanges.size(); //size of userChanges array
        if (userChangesSize == iLocal) { //create new userChange object for the question if there wasn't one
            userChanges.add(new UserChange(mScore, mWhatAnswer, mDidSubmit, mCodedAnswer, mAnswerColor));
        } else { //in case there was an object for the question - put the changes in it
            userChanges.get(iLocal).putScore(mScore);
            userChanges.get(iLocal).putWhatAnswerEdit(mWhatAnswer);
            userChanges.get(iLocal).putDidSubmit(mDidSubmit);
            userChanges.get(iLocal).putCodedAnswer(mCodedAnswer);
            userChanges.get(iLocal).putAnswerColor(mAnswerColor);
        }
    }

    //restoring data from userChanges array list
    public void restoreUserChanges() {
        int userChangesSize = userChanges.size();
        if (userChangesSize <= iLocal) return; //there weren't any userChanges stored
        else { //if there is an object for this question - restore data
            mScore = userChanges.get(iLocal).getScore();
            mWhatAnswer = userChanges.get(iLocal).getWhatAnswerEdit();
            mDidSubmit = userChanges.get(iLocal).getDidSubmit();
            mCodedAnswer = userChanges.get(iLocal).getCodedAnswer();
            mAnswerColor = userChanges.get(iLocal).getAnswerColor();
            //  show the changes that were stored on screen
            submit = (Button) findViewById(R.id.submit_button_edit_text); //finding the submit button
            submit.setVisibility(View.VISIBLE);
            answerText = (TextView) findViewById(R.id.answer_text_edit_text); //finding the codded answer display place
            answerText.setVisibility(View.VISIBLE);
            userInput = (EditText) findViewById(R.id.edit_text_user_input); //finding the EditText for the user input
            if (mWhatAnswer.isEmpty() && !mDidSubmit) { //no answer was written and submit button wasn't pressed
                userInput.setEnabled(true);
                answerText.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            } else if (!mWhatAnswer.isEmpty() && !mDidSubmit) { //an answer was written but wasn't submitted
                userInput.setText(mWhatAnswer);
                userInput.setEnabled(true);
                answerText.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            } else if (mWhatAnswer.isEmpty() && mDidSubmit) { //no answer was written but the submit button was pressed
                userInput.setEnabled(true);
                answerText.setVisibility(View.GONE);
                submit.setVisibility(View.VISIBLE);
            } else if (!mWhatAnswer.isEmpty() && mDidSubmit) { //the user wrote an answer and submitted it
                userInput.setText(mWhatAnswer);
                userInput.setEnabled(false);
                answerText.setVisibility(View.VISIBLE);
                answerText.setTextColor(mAnswerColor);
                answerText.setText(mCodedAnswer);
                submit.setVisibility(View.GONE); // don't show the submit button
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


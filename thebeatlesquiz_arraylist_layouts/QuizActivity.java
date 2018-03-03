package com.example.android.thebeatlesquiz_arraylist_layouts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//  class that create the arrays of answers and questions to be displayed in the quiz
public class QuizActivity extends AppCompatActivity {
    private static ArrayList<Question> questions = new ArrayList<Question>(); //the array of questions to be displayed
    private static ArrayList<Answer> answers = new ArrayList<Answer>(); // the array of corresponding answers
    public static ArrayList<UserChange> userChanges = new ArrayList<UserChange>(); // the array for the changes the user makes to the questions
    private int index = 0; //variable for number of objects in each array (the same)
    public static int score = 0; //variable to collect the score
    private int i = 0; // the counter that move inside the arrays
    private List<Integer> randomList = new ArrayList<Integer>(); //array to store the random indexes for the questions (and answers) in the big arrays
    private Random random = new Random(); //to allow using random later

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<Question> radioQuestions = new ArrayList<Question>();//the array that will contain all the possible RadioGroup questions
        ArrayList<Answer> radioAnswers = new ArrayList<Answer>();//the array that will contain all the possible RadioGroup answers
        ArrayList<Question> editQuestions = new ArrayList<Question>();// the array that will contain all the possible EditText questions
        ArrayList<Answer> editAnswers = new ArrayList<Answer>();// the array that will contain all the possible EditText answers
        ArrayList<Question> multiQuestions = new ArrayList<Question>();// the array that will contain all the possible Multi-op' questions
        ArrayList<Answer> multiAnswers = new ArrayList<Answer>();// the array that will contain all the possible Multi-op' answers
        ArrayList<Question> tempQuestions = new ArrayList<Question>();//temporary array for the questions (before shuffling)
        ArrayList<Answer> tempAnswers = new ArrayList<Answer>();//temporary array for the answers (before shuffling)
        // putting Question objects in the ArrayLists
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question1), getString(R.string.qs1_op1),
                getString(R.string.qs1_bl1), getString(R.string.qs1_op2), getString(R.string.qs1_bl2),
                getString(R.string.qs1_op3), getString(R.string.qs1_bl3), getString(R.string.qs1_op4),
                getString(R.string.qs1_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question2), getString(R.string.qs2_op1),
                getString(R.string.qs2_bl1), getString(R.string.qs2_op2), getString(R.string.qs2_bl2),
                getString(R.string.qs2_op3), getString(R.string.qs2_bl3), getString(R.string.qs2_op4),
                getString(R.string.qs2_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question3), getString(R.string.qs3_op1),
                getString(R.string.qs3_bl1), getString(R.string.qs3_op2), getString(R.string.qs3_bl2),
                getString(R.string.qs3_op3), getString(R.string.qs3_bl3), getString(R.string.qs3_op4),
                getString(R.string.qs3_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question4), getString(R.string.qs4_op1),
                getString(R.string.qs4_bl1), getString(R.string.qs4_op2), getString(R.string.qs4_bl2),
                getString(R.string.qs4_op3), getString(R.string.qs4_bl3), getString(R.string.qs4_op4),
                getString(R.string.qs4_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question5), getString(R.string.qs5_op1),
                getString(R.string.qs5_bl1), getString(R.string.qs5_op2), getString(R.string.qs5_bl2),
                getString(R.string.qs5_op3), getString(R.string.qs5_bl3), getString(R.string.qs5_op4),
                getString(R.string.qs5_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question6), getString(R.string.qs6_op1),
                getString(R.string.qs6_bl1), getString(R.string.qs6_op2), getString(R.string.qs6_bl2),
                getString(R.string.qs6_op3), getString(R.string.qs6_bl3), getString(R.string.qs6_op4),
                getString(R.string.qs6_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question7), getString(R.string.qs7_op1),
                getString(R.string.qs7_bl1), getString(R.string.qs7_op2), getString(R.string.qs7_bl2),
                getString(R.string.qs7_op3), getString(R.string.qs7_bl3), getString(R.string.qs7_op4),
                getString(R.string.qs7_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question13), getString(R.string.qs13_op1),
                getString(R.string.qs13_bl1), getString(R.string.qs13_op2), getString(R.string.qs13_bl2),
                getString(R.string.qs13_op3), getString(R.string.qs13_bl3), getString(R.string.qs13_op4),
                getString(R.string.qs13_bl4)));
        radioQuestions.add(new Question(getString(R.string.qsType_radio_group), getString(R.string.question14), getString(R.string.qs14_op1),
                getString(R.string.qs14_bl1), getString(R.string.qs14_op2), getString(R.string.qs14_bl2),
                getString(R.string.qs14_op3), getString(R.string.qs14_bl3), getString(R.string.qs14_op4),
                getString(R.string.qs14_bl4)));

        editQuestions.add(new Question(getString(R.string.qsType_edit_text), getString(R.string.question8), getString(R.string.qs8_ans)));
        editQuestions.add(new Question(getString(R.string.qsType_edit_text), getString(R.string.question9), getString(R.string.qs9_ans)));
        editQuestions.add(new Question(getString(R.string.qsType_edit_text), getString(R.string.question11), getString(R.string.qs11_ans)));
        editQuestions.add(new Question(getString(R.string.qsType_edit_text), getString(R.string.question12), getString(R.string.qs12_ans)));

        multiQuestions.add(new Question(getString(R.string.qsType_multi), getString(R.string.question10),
                getString(R.string.qs10_op1), getString(R.string.qs10_bl1),
                getString(R.string.qs10_op2), getString(R.string.qs10_bl2),
                getString(R.string.qs10_op3), getString(R.string.qs10_bl3),
                getString(R.string.qs10_op4), getString(R.string.qs10_bl4),
                getString(R.string.qs10_op5), getString(R.string.qs10_bl5),
                getString(R.string.qs10_op6), getString(R.string.qs10_bl6),
                getString(R.string.qs10_op7), getString(R.string.qs10_bl7),
                getString(R.string.qs10_op8), getString(R.string.qs10_bl8),
                getString(R.string.qs10_op9), getString(R.string.qs10_bl9),
                getString(R.string.qs10_op10), getString(R.string.qs10_bl10)));
        multiQuestions.add(new Question(getString(R.string.qsType_multi), getString(R.string.question15),
                getString(R.string.qs15_op1), getString(R.string.qs15_bl1),
                getString(R.string.qs15_op2), getString(R.string.qs15_bl2),
                getString(R.string.qs15_op3), getString(R.string.qs15_bl3),
                getString(R.string.qs15_op4), getString(R.string.qs15_bl4),
                getString(R.string.qs15_op5), getString(R.string.qs15_bl5),
                getString(R.string.qs15_op6), getString(R.string.qs15_bl6),
                getString(R.string.qs15_op7), getString(R.string.qs15_bl7),
                getString(R.string.qs15_op8), getString(R.string.qs15_bl8),
                getString(R.string.qs15_op9), getString(R.string.qs15_bl9),
                getString(R.string.qs15_op10), getString(R.string.qs15_bl10)));
        multiQuestions.add(new Question(getString(R.string.qsType_multi), getString(R.string.question16),
                getString(R.string.qs16_op1), getString(R.string.qs16_bl1),
                getString(R.string.qs16_op2), getString(R.string.qs16_bl2),
                getString(R.string.qs16_op3), getString(R.string.qs16_bl3),
                getString(R.string.qs16_op4), getString(R.string.qs16_bl4),
                getString(R.string.qs16_op5), getString(R.string.qs16_bl5),
                getString(R.string.qs16_op6), getString(R.string.qs16_bl6),
                getString(R.string.qs16_op7), getString(R.string.qs16_bl7),
                getString(R.string.qs16_op8), getString(R.string.qs16_bl8),
                getString(R.string.qs16_op9), getString(R.string.qs16_bl9),
                getString(R.string.qs16_op10), getString(R.string.qs16_bl10)));
        multiQuestions.add(new Question(getString(R.string.qsType_multi), getString(R.string.question17),
                getString(R.string.qs17_op1), getString(R.string.qs17_bl1),
                getString(R.string.qs17_op2), getString(R.string.qs17_bl2),
                getString(R.string.qs17_op3), getString(R.string.qs17_bl3),
                getString(R.string.qs17_op4), getString(R.string.qs17_bl4),
                getString(R.string.qs17_op5), getString(R.string.qs17_bl5),
                getString(R.string.qs17_op6), getString(R.string.qs17_bl6),
                getString(R.string.qs17_op7), getString(R.string.qs17_bl7),
                getString(R.string.qs17_op8), getString(R.string.qs17_bl8),
                getString(R.string.qs17_op9), getString(R.string.qs17_bl9),
                getString(R.string.qs17_op10), getString(R.string.qs17_bl10)));

        // putting Answer objects in the ArrayLists
        radioAnswers.add(new Answer(getString(R.string.qs1_ans1_text), getString(R.string.qs1_ans2_text),
                getString(R.string.qs1_ans3_text), getString(R.string.qs1_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs2_ans1_text), getString(R.string.qs2_ans2_text),
                getString(R.string.qs2_ans3_text), getString(R.string.qs2_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs3_ans1_text), getString(R.string.qs3_ans2_text),
                getString(R.string.qs3_ans3_text), getString(R.string.qs3_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs4_ans1_text), getString(R.string.qs4_ans2_text),
                getString(R.string.qs4_ans3_text), getString(R.string.qs4_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs5_ans1_text), getString(R.string.qs5_ans2_text),
                getString(R.string.qs5_ans3_text), getString(R.string.qs5_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs6_ans1_text), getString(R.string.qs6_ans2_text),
                getString(R.string.qs6_ans3_text), getString(R.string.qs6_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs7_ans1_text), getString(R.string.qs7_ans2_text),
                getString(R.string.qs7_ans3_text), getString(R.string.qs7_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs13_ans1_text), getString(R.string.qs13_ans2_text),
                getString(R.string.qs13_ans3_text), getString(R.string.qs13_ans4_text)));
        radioAnswers.add(new Answer(getString(R.string.qs14_ans1_text), getString(R.string.qs14_ans2_text),
                getString(R.string.qs14_ans3_text), getString(R.string.qs14_ans4_text)));

        editAnswers.add(new Answer(getString(R.string.qs8_ans1_text), getString(R.string.qs8_ans2_text)));
        editAnswers.add(new Answer(getString(R.string.qs9_ans1_text), getString(R.string.qs9_ans2_text)));
        editAnswers.add(new Answer(getString(R.string.qs11_ans1_text), getString(R.string.qs11_ans2_text)));
        editAnswers.add(new Answer(getString(R.string.qs12_ans1_text), getString(R.string.qs12_ans2_text)));

        multiAnswers.add(new Answer(getString(R.string.qs10_ans1_text), getString(R.string.qs10_ans2_text)));
        multiAnswers.add(new Answer(getString(R.string.qs15_ans1_text), getString(R.string.qs15_ans2_text)));
        multiAnswers.add(new Answer(getString(R.string.qs16_ans1_text), getString(R.string.qs16_ans2_text)));
        multiAnswers.add(new Answer(getString(R.string.qs17_ans1_text), getString(R.string.qs17_ans2_text)));

        int mMin = 0; //the minimum number limit in the random method
        //get the size - number of objects - in the RadioQuestions ArrayList
        int mMax = radioQuestions.size(); //the maximum number limit in the random method
        int[] numArray1 = new int[6]; //maximum of 6 questions of this type
        //creating a new array with random questions from RadioQuestions array
        for (int i = 0; i < 6; i++) { //maximum of 6 questions of this type
            int r = getNextRandomNumber(mMin, mMax);
            numArray1[i] = r;
            tempQuestions.add(radioQuestions.get(numArray1[i]));
            tempAnswers.add(radioAnswers.get(numArray1[i]));
        }
        numArray1 = null;//deleting the content
        randomList.clear();//clearing the array for reuse

        //get the size - number of objects - in the EditQuestions ArrayList
        mMax = editQuestions.size();
        int[] numArray2 = new int[2]; //maximum of 2 questions of this type
        //adding random questions from EditQuestions array
        for (int i = 0; i < 2; i++) { //maximum of 2 questions of this type
            int r = getNextRandomNumber(mMin, mMax);
            numArray2[i] = r;
            tempQuestions.add(editQuestions.get(numArray2[i]));
            tempAnswers.add(editAnswers.get(numArray2[i]));
        }
        numArray2 = null;//deleting the content
        randomList.clear();//clearing the array for reuse

        //get the size - number of objects - in the MultiQuestions ArrayList
        mMax = multiQuestions.size();
        int[] numArray3 = new int[2]; //maximum of 2 questions of this type
        //adding random questions from MultiQuestions array
        for (int i = 0; i < 2; i++) { //maximum of 2 questions of this type
            int r = getNextRandomNumber(mMin, mMax);
            numArray3[i] = r;
            tempQuestions.add(multiQuestions.get(numArray3[i]));
            tempAnswers.add(multiAnswers.get(numArray3[i]));
        }
        numArray3 = null;//deleting the content
        randomList.clear();//clearing the array for reuse

        //randomizing the questions (answers) to be displayed into a new questions (answers) array
        // that will be used in the quiz
        mMax = tempQuestions.size();
        int[] numArray4 = new int[mMax];
        for (int i = 0; i < mMax; i++) {
            int r = getNextRandomNumber(mMin, mMax);
            numArray4[i] = r;
            questions.add(tempQuestions.get(numArray4[i]));
            answers.add(tempAnswers.get(numArray4[i]));
        }

        // resetting all the random specific variables
        mMax = 0;
        numArray4 = null;
        randomList.clear();

        // getting the size of questions (and answers) array(s)
        index = questions.size();
        i = 0;
        //using displayQuestion Global method to display the first question
        displayQuestion(this, i, index);

//      //  what happens when the user press  Exit on the last screen
        if (getIntent().getBooleanExtra("Exit me", false)) {
            //  delete the data in the public static variables
            questions.clear();
            answers.clear();
            userChanges.clear();
            randomList.clear();
            score = 0;
            Intent myIntent = new Intent(this, MainActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            myIntent.putExtra("Exit me", true);
            startActivity(myIntent);

            //  what happens when the user press  Start over on the last screen or back from first question
        } else if (getIntent().getBooleanExtra("Start over", false)) {
            //  delete the data in the public static variables
            questions.clear();
            answers.clear();
            userChanges.clear();
            randomList.clear();
            score = 0;
            Intent myIntent = new Intent(this, ExplanationsActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(myIntent);
        }
    }

    //  this method chooses what to display on screen according to the type of question/stage
    public static void displayQuestion(Context mContext, int i, int index) {
        if (i >= index) { //if the questions array is finished - start the ScoreActivity
            Intent myIntent = new Intent(mContext, ScoreActivity.class);
            myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            myIntent.putExtra("score", score);
            myIntent.putExtra("index", index);
            mContext.startActivity(myIntent);
        } else { //created a question object and an answer object
            Question mQuestion = questions.get(i);
            Answer mAnswer = answers.get(i);
            //if the type of question is "RadioGroup" - start a RadioGroupQuestionActivity
            if (mQuestion.getTypeOfQuestion().equals("RadioGroup")) {
                Intent myIntent = new Intent(mContext, RadioGroupActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("i", i);
                myIntent.putExtra("index", index);
                myIntent.putExtra("questionText", mQuestion.getQuestionText());
                myIntent.putExtra("quesOp1", mQuestion.getOp1());
                myIntent.putExtra("quesOp2", mQuestion.getOp2());
                myIntent.putExtra("quesOp3", mQuestion.getOp3());
                myIntent.putExtra("quesOp4", mQuestion.getOp4());
                myIntent.putExtra("bl1", mQuestion.getBl1());
                myIntent.putExtra("bl2", mQuestion.getBl2());
                myIntent.putExtra("bl3", mQuestion.getBl3());
                myIntent.putExtra("bl4", mQuestion.getBl4());
                myIntent.putExtra("ansOp1", mAnswer.getOp1());
                myIntent.putExtra("ansOp2", mAnswer.getOp2());
                myIntent.putExtra("ansOp3", mAnswer.getOp3());
                myIntent.putExtra("ansOp4", mAnswer.getOp4());
                mContext.startActivity(myIntent);
                //if the type of question is "EditText" starts a EditTextQuestionActivity
            } else if (mQuestion.getTypeOfQuestion().equals("EditText")) {
                Intent myIntent = new Intent(mContext, EditTextActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("questionText", mQuestion.getQuestionText());
                myIntent.putExtra("quesOp1", mQuestion.getOp1());
                myIntent.putExtra("ansOp1", mAnswer.getOp1());
                myIntent.putExtra("ansOp2", mAnswer.getOp2());
                myIntent.putExtra("index", index);
                myIntent.putExtra("i", i);
                mContext.startActivity(myIntent);
                //if the type of question is "Multi" starts a MultiActivity
            } else if (mQuestion.getTypeOfQuestion().equals("multi")) {
                Intent myIntent = new Intent(mContext, MultiActivity.class);
                myIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                myIntent.putExtra("i", i);
                myIntent.putExtra("index", index);
                myIntent.putExtra("questionText", mQuestion.getQuestionText());
                myIntent.putExtra("quesOp1", mQuestion.getOp1());
                myIntent.putExtra("quesOp2", mQuestion.getOp2());
                myIntent.putExtra("quesOp3", mQuestion.getOp3());
                myIntent.putExtra("quesOp4", mQuestion.getOp4());
                myIntent.putExtra("quesOp5", mQuestion.getOp5());
                myIntent.putExtra("quesOp6", mQuestion.getOp6());
                myIntent.putExtra("quesOp7", mQuestion.getOp7());
                myIntent.putExtra("quesOp8", mQuestion.getOp8());
                myIntent.putExtra("quesOp9", mQuestion.getOp9());
                myIntent.putExtra("quesOp10", mQuestion.getOp10());
                myIntent.putExtra("bl1", mQuestion.getBl1());
                myIntent.putExtra("bl2", mQuestion.getBl2());
                myIntent.putExtra("bl3", mQuestion.getBl3());
                myIntent.putExtra("bl4", mQuestion.getBl4());
                myIntent.putExtra("bl5", mQuestion.getBl5());
                myIntent.putExtra("bl6", mQuestion.getBl6());
                myIntent.putExtra("bl7", mQuestion.getBl7());
                myIntent.putExtra("bl8", mQuestion.getBl8());
                myIntent.putExtra("bl9", mQuestion.getBl9());
                myIntent.putExtra("bl10", mQuestion.getBl10());
                myIntent.putExtra("ansOp1", mAnswer.getOp1());
                myIntent.putExtra("ansOp2", mAnswer.getOp2());
                mContext.startActivity(myIntent);
            }
        }
    }

    //  returning a random number between (including) min and (excluding) max
    public int getNextRandomNumber(int min, int max) {
        int randomNum = random.nextInt(max - min) + min;
        if (randomList.contains(randomNum)) {
            randomNum = getNextRandomNumber(min, max);
        }
        randomList.add(randomNum);
        return randomNum;
    }
}



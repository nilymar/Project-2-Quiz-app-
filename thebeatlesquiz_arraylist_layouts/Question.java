package com.example.android.thebeatlesquiz_arraylist_layouts;

//  class for customized object to store question data
public class Question {
    /** type of question */
    private String mTypeOfQuestion;
    /** question text */
    private String mQuestionText;
    /** answer option 1 */
    private String mOp1;
    /** answer option 2 */
    private String mOp2;
    /** answer option 3 */
    private String mOp3;
    /** answer option 4 */
    private String mOp4;
    /** answer option 5 */
    private String mOp5;
    /** answer option 6 */
    private String mOp6;
    /** answer option 7 */
    private String mOp7;
    /** answer option 8 */
    private String mOp8;
    /** answer option 9 */
    private String mOp9;
    /** answer option 10 */
    private String mOp10;
    /** Strings to store if the corresponding option is true or false */
    private String mBl1;
    private String mBl2;
    private String mBl3;
    private String mBl4;
    private String mBl5;
    private String mBl6;
    private String mBl7;
    private String mBl8;
    private String mBl9;
    private String mBl10;

     //constructor for a RadioGroup question
    public Question(String typeOfQuestion, String questionText, String op1, String bl1,
                    String op2, String bl2, String op3, String bl3, String op4, String bl4) {
        mTypeOfQuestion = typeOfQuestion;
        mQuestionText = questionText;
        mOp1 = op1;
        mBl1 = bl1;
        mOp2 = op2;
        mBl2 = bl2;
        mOp3 = op3;
        mBl3 = bl3;
        mOp4 = op4;
        mBl4 = bl4;
    }

    //constructor for a multiple options question
    public Question(String typeOfQuestion, String questionText, String op1, String bl1,
                    String op2, String bl2, String op3, String bl3, String op4, String bl4,
                    String op5, String bl5, String op6, String bl6, String op7, String bl7,
                    String op8, String bl8, String op9, String bl9, String op10, String bl10) {
        mTypeOfQuestion = typeOfQuestion;
        mQuestionText = questionText;
        mOp1 = op1;
        mBl1 = bl1;
        mOp2 = op2;
        mBl2 = bl2;
        mOp3 = op3;
        mBl3 = bl3;
        mOp4 = op4;
        mBl4 = bl4;
        mOp5 = op5;
        mBl5 = bl5;
        mOp6 = op6;
        mBl6 = bl6;
        mOp7 = op7;
        mBl7 = bl7;
        mOp8 = op8;
        mBl8 = bl8;
        mOp9 = op9;
        mBl9 = bl9;
        mOp10 = op10;
        mBl10 = bl10;
    }

    //constructor for an EditText question
    public Question(String typeOfQuestion, String questionText, String op1) {
        mTypeOfQuestion = typeOfQuestion;
        mQuestionText = questionText;
        mOp1 = op1;
    }

    /**
     * Get the type of the question
     */
    public String getTypeOfQuestion() {
        return mTypeOfQuestion;
    }
    /**
     * Get the text of the question
     */
    public String getQuestionText() {
        return mQuestionText;
    }
    /**
     * Get the first optional answer
     */
    public String getOp1() {
        return mOp1;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl1() {
        return mBl1;
    }
    /**
     * Get the first optional answer
     */
    public String getOp2() {
        return mOp2;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl2() {
        return mBl2;
    }
    /**
     * Get the first optional answer
     */
    public String getOp3() {
        return mOp3;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl3() {
        return mBl3;
    }
    /**
     * Get the first optional answer
     */
    public String getOp4() {
        return mOp4;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl4() {
        return mBl4;
    }
    /**
     * Get the first optional answer
     */
    public String getOp5() {
        return mOp5;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl5() {
        return mBl5;
    }
    /**
     * Get the first optional answer
     */
    public String getOp6() {
        return mOp6;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl6() {
        return mBl6;
    }
    /**
     * Get the first optional answer
     */
    public String getOp7() {
        return mOp7;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl7() {
        return mBl7;
    }
    /**
     * Get the first optional answer
     */
    public String getOp8() {
        return mOp8;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl8() {
        return mBl8;
    }
    /**
     * Get the first optional answer
     */
    public String getOp9() {
        return mOp9;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl9() {
        return mBl9;
    }
    /**
     * Get the first optional answer
     */
    public String getOp10() {
        return mOp10;
    }
    /**
     * Get the if that optional answer is true or false
     */
    public String getBl10() {
        return mBl10;
    }

}


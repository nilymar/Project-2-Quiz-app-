package com.example.android.thebeatlesquiz_arraylist_layouts;

// class for customize object to store codded answers for each question
public class Answer {
    /** answer text option 1 */
    private String mOp1;
    /** answer text option 2 */
    private String mOp2;
    /** answer text option 3 */
    private String mOp3;
    /** answer text option 4 */
    private String mOp4;

    //constructor for 4 options Answer (RadioGroup question)
    public Answer( String op1, String op2, String op3, String op4) {
        mOp1 = op1;
        mOp2 = op2;
        mOp3 = op3;
        mOp4 = op4;
    }

    //constructor for a 2 options Answer (EditText question and Multi option question
    public Answer(String op1, String op2) {
        mOp1 = op1;
        mOp2 = op2;
    }

    /**
     * Get the first answer text
     */
    public String getOp1() {
        return mOp1;
    }
    /**
     * Get the 2nd answer text
     */
    public String getOp2() {
        return mOp2;
    }
    /**
     * Get the 3rd answer text
     */
    public String getOp3() {
        return mOp3;
    }
    /**
     * Get the 4th answer text
     */
    public String getOp4() {
        return mOp4;
    }

}


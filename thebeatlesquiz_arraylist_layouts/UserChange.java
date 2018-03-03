package com.example.android.thebeatlesquiz_arraylist_layouts;

//  class for customized object to store user changes in question display
public class UserChange {

    /** total score with current question */
    private int mScore;
    /** what the answer given by the user in an EditText question */
    private String mWhatAnswerEdit;
    /** what the answer chosen by the user in a RadioGroup question*/
    private int mWhatAnswerRadio;
    /** is the 1st checkBox checked in a Multi question*/
    private boolean mCb1checked;
    /** is the 2nd checkBox checked in a Multi question*/
    private boolean mCb2checked;
    /** is the 3rd checkBox checked in a Multi question*/
    private boolean mCb3checked;
    /** is the 4st checkBox checked in a Multi question*/
    private boolean mCb4checked;
    /** is the 5tg checkBox checked in a Multi question*/
    private boolean mCb5checked;
    /** is the 6th checkBox checked in a Multi question*/
    private boolean mCb6checked;
    /** is the 7th checkBox checked in a Multi question*/
    private boolean mCb7checked;
    /** is the 8th checkBox checked in a Multi question*/
    private boolean mCb8checked;
    /** is the 9th checkBox checked in a Multi question*/
    private boolean mCb9checked;
    /** is the 10th checkBox checked in a Multi question*/
    private boolean mCb10checked;
    /**did the user press submit*/
    private boolean mDidSubmit;
    /**the coded answer for the user choice*/
    private String mCodedAnswer;
    /**the color that answer should have*/
    private int mAnswerColor;
    /**the number of check boxes that where checked in a Multi question*/
    private int mCbCheckedCount;


    //constructor for a RadioGroup question user changes
    public UserChange(int score, int whatAnswerRadio, boolean didSubmit,
                      String codedAnswer, int answerColor) {
        mScore = score;
        mWhatAnswerRadio = whatAnswerRadio;
        mDidSubmit = didSubmit;
        mCodedAnswer = codedAnswer;
        mAnswerColor = answerColor;
    }

    //constructor for a EditText question user changes
    public UserChange( int score, String whatAnswerEdit, boolean didSubmit, String codedAnswer, int answerColor) {
        mScore = score;
        mWhatAnswerEdit = whatAnswerEdit;
        mDidSubmit = didSubmit;
        mCodedAnswer = codedAnswer;
        mAnswerColor = answerColor;
    }

    //constructor for an Multi question user changes
    public UserChange(int score, boolean cb1checked, boolean cb2checked, boolean cb3checked,
                      boolean cb4checked, boolean cb5checked, boolean cb6checked, boolean cb7checked,
                      boolean cb8checked, boolean cb9checked, boolean cb10checked, boolean didSubmit, String codedAnswer,
                      int answerColor, int cbCheckedCount) {
        mScore = score;
        mCb1checked = cb1checked;
        mCb2checked = cb2checked;
        mCb3checked = cb3checked;
        mCb4checked = cb4checked;
        mCb5checked = cb5checked;
        mCb6checked = cb6checked;
        mCb7checked = cb7checked;
        mCb8checked = cb8checked;
        mCb9checked = cb9checked;
        mCb10checked = cb10checked;
        mDidSubmit = didSubmit;
        mCodedAnswer = codedAnswer;
        mAnswerColor = answerColor;
        mCbCheckedCount = cbCheckedCount;
    }

     /**
     * get the score with this question
     */
    public int getScore() {
        return mScore;
    }
    /**
     * get the user answer for EditText question
     */
    public String getWhatAnswerEdit() {
        return mWhatAnswerEdit;
    }
    /**
     * get the user answer for RadioGroup question
     */
    public int getWhatAnswerRadio() {
        return mWhatAnswerRadio;
    }
    /**
     * Get if the 1st option in Multi question was checked
     */
    public boolean getCb1() {
        return mCb1checked;
    }
    /**
     * Get if the 2nd option in Multi question was checked
     */
    public boolean getCb2() {
        return mCb2checked;
    }
    /**
     * Get if the 3rd option in Multi question was checked
     */
    public boolean getCb3() {
        return mCb3checked;
    }
    /**
     * Get if the 4th option in Multi question was checked
     */
    public boolean getCb4() {
        return mCb4checked;
    }
    /**
     * Get if the 5th option in Multi question was checked
     */
    public boolean getCb5() {
        return mCb5checked;
    }
    /**
     * Get if the 6th option in Multi question was checked
     */
    public boolean getCb6() {
        return mCb6checked;
    }
    /**
     * Get if the 7th option in Multi question was checked
     */
    public boolean getCb7() {
        return mCb7checked;
    }
    /**
     * Get if the 8th option in Multi question was checked
     */
    public boolean getCb8() {
        return mCb8checked;
    }
    /**
     * Get if the 9th option in Multi question was checked
     */
    public boolean getCb9() {
        return mCb9checked;
    }
    /**
     * Get if the 10th option in Multi question was checked
     */
    public boolean getCb10() {
        return mCb10checked;
    }
    /**
     * get if the user pressed submit
     */
    public boolean getDidSubmit() {
        return mDidSubmit;
    }
    /**
     * get the coded answer for the question
     */
    public String getCodedAnswer() {
        return mCodedAnswer;
    }
    /**
     * get the color needed to present that answer on screen
     */
    public int getAnswerColor() {
        return mAnswerColor;
    }
    /**
     * get the number of check boxes that where checked
     */
    public int getCbCheckedCount() {
        return mCbCheckedCount;
    }

    /**
     * put the score with this question
     */
    public void putScore(int score) {
        mScore = score;
    }
      /**
     * put the user answer for EditText question
     */
    public void putWhatAnswerEdit(String whatAnswerEdit) {

        mWhatAnswerEdit = whatAnswerEdit;
    }
    /**
     * put the user answer for RadioGroup question
     */
    public void putWhatAnswerRadio(int whatAnswerRadio) {

         mWhatAnswerRadio = whatAnswerRadio;
    }
    /**
     * put the 1st check box user choice in Multi question
     */
    public void putCb1(boolean cb1checked) {

        mCb1checked = cb1checked;
    }
    /**
     * put the 2nd check box user choice in Multi question
     */
    public void putCb2(boolean cb2checked) {

        mCb2checked = cb2checked;
    }
    /**
     * put the 3rd check box user choice in Multi question
     */
    public void putCb3(boolean cb3checked) {

        mCb3checked = cb3checked;
    }
    /**
     * put the 4th check box user choice in Multi question
     */
    public void putCb4(boolean cb4checked) {

        mCb4checked = cb4checked;
    }
    /**
     * put the 5th check box user choice in Multi question
     */
    public void putCb5(boolean cb5checked) {

        mCb5checked = cb5checked;
    }
    /**
     * put the 6th check box user choice in Multi question
     */
    public void putCb6(boolean cb6checked) {

        mCb6checked = cb6checked;
    }
    /**
     * put the 7th check box user choice in Multi question
     */
    public void putCb7(boolean cb7checked) {

        mCb7checked = cb7checked;
    }
    /**
     * put the 8th check box user choice in Multi question
     */
    public void putCb8(boolean cb8checked) {

        mCb8checked = cb8checked;
    }
    /**
     * put the 9th check box user choice in Multi question
     */
    public void putCb9(boolean cb9checked) {

        mCb9checked = cb9checked;
    }
    /**
     * put the 10th check box user choice in Multi question
     */
    public void putCb10(boolean cb10checked) {

        mCb10checked = cb10checked;
    }
    /**
     * put if the user pressed submit
     */
    public void putDidSubmit(boolean didSubmit) {

        mDidSubmit = didSubmit;
    }
    /**
     * put the coded answer for the question
     */
    public void putCodedAnswer(String codedAnswer) {

        mCodedAnswer = codedAnswer;
    }
    /**
     * put the color needed to present that answer on screen
     */
    public void putAnswerColor(int answerColor) {

        mAnswerColor = answerColor;
    }
    /**
     * get the number of check boxes that where checked
     */
    public void putCbCheckedCount(int cbCheckedCount) {

        mCbCheckedCount = cbCheckedCount;
    }

}

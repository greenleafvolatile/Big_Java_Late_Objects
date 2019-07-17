/**
 * "Add a class FillInQuestion to the questionWithAnswerFilledIn hierarchy of Section 9,1. Such a questionWithAnswerFilledIn is constructed with a string that contains
 * the answer, surrounded by _ _, for example, "The inventor of Java was _James Gosling_". The questionWithAnswerFilledIn should be displayed as
 * "The inventor of Java was ____________"."
 */

public class Programming_Exercise_9_2_Fill_In_Question extends Question {


    /**
     * a constructor that takes a fill-in questionWithAnswerFilledIn with the answer filled in as parameter.
     * //* @param questionWithAnswerFilledInWithAnswerFilledIn = the fill-in questionWithAnswerFilledIn with the answer filled in.
     */
    public Programming_Exercise_9_2_Fill_In_Question(String questionWithAnswerFilledIn) {

        super.setText(questionWithAnswerFilledIn.split("\\_")[0] + String.format("%0" + questionWithAnswerFilledIn.split("\\_")[1].length() + "d", 0).replace("0", "_") + "?");
        super.setAnswer(questionWithAnswerFilledIn.split("\\_")[1]);
    }
}



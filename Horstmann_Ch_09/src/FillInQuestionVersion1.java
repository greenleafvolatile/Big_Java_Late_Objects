/**
 * "Add a class FillInQuestionVersion1 to the question hierarchy of Section 9,1. Such a question is constructed with a string that contains
 * the answer, surrounded by _ _, for example, "The inventor of Java was _James Gosling_". The question should be displayed as
 * "The inventor of Java was ____________"."
 *
 * Note: I took the text of this exercise to mean that the constructor of the FillInQuestionVersion1 class should take the fill-in question with the
 * answer filled in as a parameter. This resulted in some akward code. I made another version (version2) that does things a little differently.
 */


import java.util.logging.*;

public class FillInQuestionVersion1 extends Question {

    private String questionWithAnswerFilledIn;
    private int[] indices;

    /**
     * a constructor that takes a fill-in question with the answer filled in as parameter.
     * @param questionWithAnswerFilledIn
     */
    public FillInQuestionVersion1(String questionWithAnswerFilledIn) {
        this.questionWithAnswerFilledIn = questionWithAnswerFilledIn;
        this.indices = new int[2]; // an int array to hold the indices of the underscores surrounding the answer.

    }

    /**
     * setText() sets the question text. The answer parts of the fill-in question are replaced by underscores (_).
     */
    public void setText() {
        this.getIndices(this.questionWithAnswerFilledIn); // get the indices of the underscores (_) in the actual parameter.
        String[] answerParts = this.questionWithAnswerFilledIn.substring(indices[0] + 1, indices[1]).split(" "); //split the answer so the user can see how many parts the answer is made up of.
        String blankAnswer = "";
        for (int i=0;i< answerParts.length;i++) { // create a blank answer matching the number of parts and number of characters of the actual answer.
            for (int j=0; j<answerParts[i].length(); j++) {
                blankAnswer += "_";
            }
            if(i<answerParts.length - 1) {
                blankAnswer += " ";
            }
        }
        this.setText(this.questionWithAnswerFilledIn.substring(0, (this.indices[0])) + blankAnswer);
    }

    /**
     * setAnswer() sets the answer to the fill-in question.
     */
    public void setAnswer() {
        this.setAnswer(this.questionWithAnswerFilledIn.substring(this.indices[0] + 1, this.indices[1])); //getIndices is invoked in setText. This means that setAnswer only works if setText is invoked first.


    }

    /**
     * getIndices gets the indices of the underscores(_) in the fill-in question with the answer filled in, in order to filter out the answer.
     * @param questionWithAnswerFilledIn
     */
    private void getIndices(String questionWithAnswerFilledIn) { //I declared this method private because only other methods of this class should have access to it.
        int indicesIndex = 0;
        for(int i=0;i<this.questionWithAnswerFilledIn.length();i++) {
                if (this.questionWithAnswerFilledIn.charAt(i) == '_') {
                    Logger.getGlobal().info("Index: " + i);
                    this.indices[indicesIndex] = i;
                    indicesIndex++;
                }
            }
        }
}



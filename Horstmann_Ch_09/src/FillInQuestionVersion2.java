/**
 * "Add a class FillInQuestion to the question hierarchy of Section 9,1. Such a question is constructed with a string that contains
 *  the answer, surrounded by _ _, for example, "The inventor of Java was _James Gosling_". The question should be displayed as
 *  "The inventor of Java was ____________"."
 */

public class FillInQuestionVersion2 extends Question {

    /**
     * Constructor
     */
    public FillInQuestionVersion2() {}

    /**
     * This method processes the parameter, and sets the question text and answer via the superclass methods setText() and setAnswer();
     * @param fillInQuestionWithAnswer, the fill-in question with the answer filled in.
     */
    public void setTextAndAnswer(String fillInQuestionWithAnswer) {
        String[] fillInQuestionWithAnswerParts = fillInQuestionWithAnswer.split("_"); //split the parameter in a question part and an answer part.
        String questionPart = fillInQuestionWithAnswerParts[0];
        String answerPart = fillInQuestionWithAnswerParts[1];
        String[] answerParts = answerPart.split(" "); //split the answer in its constituent parts.
        String blankAnswer = "";
        for(int i=0;i<answerParts.length;i++) { //create a blank answer with underscores, matching the number of parts and the number characters in the answer.
            for(int j=0;j<answerParts[i].length();j++){
                blankAnswer+="_";
            }
            if(i<answerParts.length - 1){
                blankAnswer+=" ";
            }
        }
        this.setText(questionPart + blankAnswer);
        this.setAnswer(answerPart);
    }
}



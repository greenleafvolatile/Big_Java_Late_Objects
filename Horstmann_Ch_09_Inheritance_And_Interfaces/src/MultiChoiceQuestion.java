/**
 * "Add a class MultiChoiceQuestion to the question hierarchy of Section 9.1 that allows multiple correct choices.
 * The respondent should provide all correct choice separated by spaces. Provide instructions in the question text."
 */

public class MultiChoiceQuestion extends ChoiceQuestion{

    /**
     * Constructor
     */
    public MultiChoiceQuestion() {}

    /**
     * setAnswer() implements an answer string that consists of the correct choices separated by spaces.
     * @param choiceString, a number corresponding to a correct answer. See addChoice() of ChoiceQuestion.
     */
    @Override
    public void setAnswer(String choiceString) {
       if(this.getAnswer().length()==0){
           super.setAnswer(choiceString);
       }
       else{
           super.setAnswer(this.getAnswer() + " " + choiceString);
       }
   }

    /**
     * checkAnswer verifies if the user's response matches the correct answer.
     * @param response the user's response.
     * @return a boolean if the response matcher the correct answer.
     */
    @Override
    public boolean checkAnswer(String response){
        /* remove whitespace from response. The answer consisting of numbers separated by spaces would lead to false positives
            when iterating over both later on. */
        response=response.replaceAll("\\s+", "");
        int correctAnswerCount = 0;
        for(int i=0;i<response.length();i++){
            for(int j=0;j<this.getAnswer().length();j++){
                if(response.charAt(i)==this.getAnswer().charAt(j)){
                    correctAnswerCount++;
                }
            }
        }
        // Remove whitespace from the answer string so that the length of the string corresponds to the number of correct questions.
        return correctAnswerCount==this.getAnswer().replaceAll("\\s+", "").length();
    }

    /**
     *
     * display() displays the question text, the answer options and instructions pertinent to this type of question.
     */
    @Override
    public void display() {
        super.display();
        System.out.println("Provide all of the correct answers!");
    }
}

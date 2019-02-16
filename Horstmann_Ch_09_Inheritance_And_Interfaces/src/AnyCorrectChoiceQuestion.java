/**
 * "Add a class AnyCorrectQuestion to the question hierarchy of Section 9.1 that allows multiple correct choices.
 * The respondent should provide any one of the correct choices. The answer string shoould contain all of the coreect choices, separated by spaces.
 * Provide instructions in the question text.
 */

import java.util.ArrayList;

public class AnyCorrectChoiceQuestion extends ChoiceQuestion {

    /**
     * Constructor
     */
    public AnyCorrectChoiceQuestion() {}

    /**
     * setAnswer() implements an answer string that contains all of the correct answers separated by spaces.
     * @param choiceString, the number of the correct answer converted to String format.
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
     * checkAnswer() checks if the answer string contains the number inputted by the user.
     * @param response, the user's response.
     * @return a boolean.
     */
    @Override
    public boolean checkAnswer(String response){
       for(int i=0;i<response.length();i++){
           for(int j=0;j<this.getAnswer().length();j++){
               if(response.charAt(i)==this.getAnswer().charAt(j)){
                   return true;
               }
           }
       }
       return false;
   }

    /**
     * display() displays the questions text, the answer options and instructions pertinent to this type of question.
     */
   @Override
    public void display(){
       super.display();
       System.out.println("There are multiple correct answers. Choose ONE answer");
   }
}

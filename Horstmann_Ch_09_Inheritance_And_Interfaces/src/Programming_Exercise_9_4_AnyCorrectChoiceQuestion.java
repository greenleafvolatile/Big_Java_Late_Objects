import java.util.ArrayList;
import java.util.Scanner;

/**
 * "Add a class AnyCorrectQuestion to the question hierarchy of Section 9.1 that allows multiple correct choices.
 * The respondent should provide any one of the correct choices. The answer string should contain all of the correct choices, separated by spaces.
 * Provide instructions in the question text.
 */

public class Programming_Exercise_9_4_AnyCorrectChoiceQuestion extends Question {

    private final ArrayList<String> options;

    private Programming_Exercise_9_4_AnyCorrectChoiceQuestion() {
        options=new ArrayList<>();
    }


    private void addOption(String option, boolean correct){
        options.add(option);
        if(correct){
            String answer="" + options.size();
            setAnswer(answer);
        }
    }

    @Override
    public void setAnswer(String answer) {
        super.setAnswer(super.getAnswer()+answer+" ");
    }

    @Override
    public boolean checkAnswer(String response){

        for(int i=0;i<super.getAnswer().length();i++){
            if(response.trim().toLowerCase().charAt(0)==super.getAnswer().toLowerCase().charAt(i)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < options.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + options.get(i));
        }
    }

    public static void main(String[] args){

        Programming_Exercise_9_4_AnyCorrectChoiceQuestion question = new Programming_Exercise_9_4_AnyCorrectChoiceQuestion();
        question.setText("Which of the below colors is a color of the rainbow? (There is more than one correct answer)");
        question.addOption("Yellow", true);
        question.addOption("Black", false);
        question.addOption("Brown", false);
        question.addOption("Red", true);

        question.display();
        Scanner in=new Scanner(System.in);
        System.out.print("Your answer: ");
        String response=in.nextLine();
        System.out.print(question.checkAnswer(response));
    }
}
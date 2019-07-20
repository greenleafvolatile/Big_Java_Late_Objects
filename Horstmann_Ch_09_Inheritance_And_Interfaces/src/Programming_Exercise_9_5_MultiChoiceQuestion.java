import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;

public class Programming_Exercise_9_5_MultiChoiceQuestion extends ChoiceQuestion {

    @Override
    public void addOption(String option, boolean correct){
        super.add(option);
        if(correct){
            String answer="" + super.getOptions().size();
            setAnswer(answer);
        }
    }

    @Override
    public void setAnswer(String answer) {
        super.setAnswer(super.getAnswer()+answer+" ");
    }

    public static void main(String[] args){

        Programming_Exercise_9_5_MultiChoiceQuestion question= new Programming_Exercise_9_5_MultiChoiceQuestion();
        question.setText("Which of the people below were at one time president of the USA?");
        question.addOption("Woodrow Wilson", true);
        question.addOption("Bon Jovi", false);
        question.addOption("Bruce Willis", false);
        question.addOption("Donald Trump", true);

        question.display();

        Scanner in=new Scanner(System.in);
        System.out.println("Please enter all correct answers separated by spaces: ");
        String response=in.nextLine();
        System.out.println(question.checkAnswer(response));

    }

}

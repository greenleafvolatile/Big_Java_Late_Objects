import java.util.ArrayList;
import java.util.Arrays;

public class ChoiceQuestion extends Question {
    /**
     * A question with multiple choices
     */

    private ArrayList<String> options;

    /**
     * Constructs a choice question with no choices
     */
    public ChoiceQuestion() {

        this.options = new ArrayList<>();
    }

    public String toString() {
        return super.toString() + "\n" + "[choices=" + options + "]";
    }

    public void add(String option){
        options.add(option);
    }

    /**
     * Adds an answer choice to this question
     * @param  option the choice
     * @param correct true if choice is correct, else false
     */
    public void addOption(String option, boolean correct) {
        add(option);
        if (correct)
        {
            String choiceString = "" + options.size();
            super.setAnswer(choiceString);
        }
    }

    /**
     * Display question and answers.
     */
    @Override
    public void display() {
        // Display the question text
        super.display();
        // Display the choices
        for (int i = 0; i <options.size(); i++) {
            int choiceNumber = i + 1;
            System.out.println(choiceNumber + ": " + options.get(i));
        }
    }

    public ArrayList<String> getOptions() {
        return options;
    }
}



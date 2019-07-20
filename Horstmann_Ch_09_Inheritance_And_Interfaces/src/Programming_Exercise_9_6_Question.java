import java.util.Scanner;

/**
 * "Add a method 'addText' to the Question superclass and provide a different implementation of ChoiceQuestion that
 * calls 'addText' rather than storing an array list of choices."
 */

public class Programming_Exercise_9_6_Question
{
    private String text;
    private String answer;

    private Programming_Exercise_9_6_Question() {
        text = "";
        answer = "";
    }

    private class Choice_Question extends Programming_Exercise_9_6_Question {

        private int numberOfOptions;

        private Choice_Question() {

            numberOfOptions = 0;
        }

        private void addOption(String option, boolean correct) {
            numberOfOptions++;
            super.addText("\n" + numberOfOptions + ")" + option);
            if(correct) {
                super.setAnswer("" + numberOfOptions);
            }
        }
    }


    public String toString() {
        return getClass().getName() + "\n[text=" + text + "]" + "\n" + "[answer=" + answer + "]";
    }

    private void addText(String option) {
        this.text+=option;
    }

    void setText(String questionText) {
        text = questionText;
    }

    private void setAnswer(String correctResponse) {
        answer = correctResponse;
    }

    boolean checkAnswer(String response) {
        return response.toLowerCase().equals(answer.trim().toLowerCase());
    }

    void display() {
        System.out.println(text);
    }

    public static void main(String[] args){

        Programming_Exercise_9_6_Question.Choice_Question question = new Programming_Exercise_9_6_Question().new Choice_Question();
        question.setText("Who played the Terminator in the Terminator movie franchise?");
        question.addOption("Al Pacino", false);
        question.addOption("Donald Trump", false);
        question.addOption("Nanci Pelosi", false);
        question.addOption("Arnold Schwarzenegger", true);

        question.display();
        Scanner in =new Scanner(System.in);
        System.out.print("Your answer: ");
        String response=in.nextLine();
        System.out.println(question.checkAnswer(response));
    }


}
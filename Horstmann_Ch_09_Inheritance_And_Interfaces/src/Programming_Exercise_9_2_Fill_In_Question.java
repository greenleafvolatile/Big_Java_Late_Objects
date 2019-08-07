import java.util.Scanner;

/**
 * "Add a class FillInQuestion to the question hierarchy of Section 9,1. Such a question is constructed with a string that contains
 * the answer, surrounded by _ _, for example, "The inventor of Java was _James Gosling_". The question should be displayed as
 * "The inventor of Java was ____________"."
 */

public class Programming_Exercise_9_2_Fill_In_Question extends Question {

    public Programming_Exercise_9_2_Fill_In_Question(String questionWithAnswerFilledIn) {

        super.setText(questionWithAnswerFilledIn.split("\\_")[0] + String.format("%0" + questionWithAnswerFilledIn.split("\\_")[1].length() + "d", 0).replace("0", "_") + "?");
        super.setAnswer(questionWithAnswerFilledIn.split("\\_")[1]);
    }

    public static void main(String[] args){

        Question question = new Programming_Exercise_9_2_Fill_In_Question("The inventor of Java is  _James Gosling_");
        question.display();
        Scanner in=new Scanner(System.in);
        System.out.print("Your answer: ");
        String response=in.nextLine();
        System.out.println(question.checkAnswer(response));

    }



}



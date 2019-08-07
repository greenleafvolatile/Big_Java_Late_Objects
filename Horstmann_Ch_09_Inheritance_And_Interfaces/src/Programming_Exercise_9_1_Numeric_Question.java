/**
 * Add a class NumericQuestion to the question hierarchy of Section 9.1. If the response and the expected answer differ by no more than 0.01,
 * the accept the response as correct.
 */

class Programming_Exercise_9_1_Numeric_Question extends Question {

    private static final double ACCEPTED_DIFFERENCE = 0.01;

    public Programming_Exercise_9_1_Numeric_Question() {
    }

    @Override
    public boolean checkAnswer(String response) {
        return (Math.abs(Double.parseDouble(response) - Double.parseDouble(this.getAnswer())) <= ACCEPTED_DIFFERENCE);
    }

    public static void main(String[] args){

        Question question = new Programming_Exercise_9_1_Numeric_Question();
        question.setText("What is 2 + 3: ");
        question.setAnswer("5");
    }







}

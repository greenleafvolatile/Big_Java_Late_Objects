/**
 * Add a class NumericQuestion to the question hierarchy of Section 9.1. If the response and the expected answer differ by no more than 0.01,
 * the accept the response as correct.
 */

class Programming_Exercise_9_1_Numeric_Question extends Question {

    private static final double ACCEPTED_DIFFERENCE = 0.01;

    public Programming_Exercise_9_1_Numeric_Question() {
    }

    /**
     * Checks if the given response to the numeric question is correct. A difference of 0.01 between the response and the correct answer is accepted.
     * @param response, the user's answer to the question.
     * @return boolean.
     */
    @Override
    public boolean checkAnswer(String response) {
        return (Math.abs(Double.parseDouble(response) - Double.parseDouble(this.getAnswer())) <= ACCEPTED_DIFFERENCE);
    }







}

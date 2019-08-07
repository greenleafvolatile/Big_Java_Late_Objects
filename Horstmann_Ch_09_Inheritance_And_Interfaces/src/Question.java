public class Question
{
    private String text;
    private String answer;

    /**
     * Constructs a questions with empty question and answer
     */
    public Question()
    {
        this.text = "";
        this.answer = "";
    }

    /**
     * toString() returns the contents of the question object.
     * @return a String containing the values of the instance variables 'text' and 'answer'.
     */
    public String toString() {
        return getClass().getName() + "\n[text=" + this.text + "]" + "\n" + "[answer=" + this.answer + "]";
    }

    public void addText(String choiceText) {
            this.text+=choiceText;
    }
    /**
     * Sets the question text
     * @param questionText the question
     */
    public void setText(String questionText)
    {
        text = questionText;
    }

    /**
     * Sets the answer to the question
     * @param correctResponse the correct response to the question.
     */
    public void setAnswer(String correctResponse)
    {
        answer = correctResponse;
    }

    /**
     * Checks if a given response is correct
     * @param response the response
     * @return a boolean, TRUE if correct, FALSE if incorrect.
     */

    public boolean checkAnswer(String response)
    {
        return response.toLowerCase().equals(answer.trim().toLowerCase());
    }

    /**
     * Displays the question / answer
     */
    public void display() {
        System.out.println(text);
    }

    public String getAnswer(){
        return this.answer;
    }


}

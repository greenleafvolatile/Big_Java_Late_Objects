/**
 * "Write a program that prompts the user for two numbers and then prints the sum, the difference, the product, the average,
 * the distance (the absolute value of the difference), the maximum (the larger of the two) and the minimum (the smaller of the two).
 * Hint: the max and min functions are declared in the math class."
 */

import javax.swing.JOptionPane;

public class progrExercise24 {

    // This program prompts the user for two numbers and then prints the sum, the difference, the product, the average, the distance, the maximum and the minimu.

    public static void main(String[] args)
    {
        double  firstNumber = Double.parseDouble(JOptionPane.showInputDialog("Please enter an number."));
        JOptionPane.showMessageDialog(null, "The first number you entered is: " + firstNumber );
        double secondNumber = Double.parseDouble(JOptionPane.showInputDialog("Please enter a second number."));
        JOptionPane.showMessageDialog(null, "The second number you entered is: " + secondNumber);
        JOptionPane.showMessageDialog(null, "The sum of the numbers you entered is: " + (firstNumber + secondNumber));
        JOptionPane.showMessageDialog(null, "The difference between the numbers you entered is: " + (firstNumber - secondNumber));
        JOptionPane.showMessageDialog(null, "The product of the numbers you entered is: " + (firstNumber * secondNumber));
        JOptionPane.showMessageDialog(null, "The average of the numbers you entered is: " + ((firstNumber + secondNumber) / 2));
        JOptionPane.showMessageDialog(null, "The distance of the numbers you entered is: " + Math.abs(firstNumber - secondNumber));
        JOptionPane.showMessageDialog(null, "The maximum of the two numbers you entered is: " + Math.max(firstNumber, secondNumber));
        JOptionPane.showMessageDialog(null, "The minimum of the two numbers you entered is: " + Math.min(firstNumber, secondNumber));
    }
}

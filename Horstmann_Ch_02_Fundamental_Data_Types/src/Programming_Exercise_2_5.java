/**
 * "Enhance the output of Exercise P2.4 so that the numbers are properly aligned."
 */

import java.util.Scanner;

public class Programming_Exercise_2_5 {

    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);

        System.out.print("Please enter an number: ");

        double firstNumber = in.nextDouble();

        System.out.print("Please enter another number: ");

        double secondNumber = in.nextDouble();

        System.out.printf("The sum of the numbers you entered is:             %10.2f \n", (firstNumber + secondNumber));
        System.out.printf("The difference between the numbers you entered is: %10.2f \n", (firstNumber - secondNumber));
        System.out.printf("The product of the numbers you entered is:         %10.2f \n", (firstNumber * secondNumber));
        System.out.printf("The average of the numbers you entered is:         %10.2f \n", (firstNumber + secondNumber) / 2);
        System.out.printf("The distance of the numbers you entered is:        %10.2f \n", Math.abs(firstNumber - secondNumber));
        System.out.printf("The maximum of the two numbers you entered is:     %10.2f \n", Math.max(firstNumber, secondNumber));
        System.out.printf("The minimum of the two numbers you entered is:     %10.2f \n", Math.min(firstNumber, secondNumber));
    }
}

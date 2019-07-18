/**
 * "Write a program that reads a number and displays the square, cube and fourth power. Use the Math.pow method only for the fourth power."
 */

import java.util.Scanner;

public class Programming_Exercise_2_3 {

    // This program gives the square, cube and fourth power of a give number.

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter a number:");
        double number = in.nextInt();
        System.out.printf("Your number squared is:              %.2f \n", number * number);
        System.out.printf("Your number cubed is:                %.2f \n", number * number * number);
        System.out.printf("Your number to the fourth power is:  %.2f", Math.pow(number, 4));
    }
}

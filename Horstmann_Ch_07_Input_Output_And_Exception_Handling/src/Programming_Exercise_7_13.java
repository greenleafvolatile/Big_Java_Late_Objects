import java.util.Scanner;

/**
 * "Write a program that asks the user to input a set of floating_point values. When the user enters a value that
 * is not a number, give the user a second chance to enter the value. After two chances, quit reading input. Add all
 * correctly specified values and print the sum when the user is done entering data. Use exception handling to detect
 * improper inputs."
 */
public class Programming_Exercise_7_13
{
    public static void main(String[] args)
    {
        Scanner stdin= new Scanner(System.in);
        double sum = 0;
        int chances= 0;
        do
        {
            System.out.print("Please enter a set of floating point values('q' when done): ");
            String input=stdin.next();
            if(input.equals("q")){
                break;
            }
            else{
                try
                {
                    sum += Double.parseDouble(input);

                }
                catch (NumberFormatException e)
                {
                    System.out.println("You may enter only numbers!");
                    chances++;
                }
            }
        }
        while (chances< 2);
        System.out.print("The sum of the values you inputted is: " + sum);
        stdin.close();
    }
}

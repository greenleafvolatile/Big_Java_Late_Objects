/**
 * "Write a program that computes and displays the perimeter of a letter-size(8.5 x 11 inches) sheet of paper and the length of its diagonal.
 */
public class Programming_Exercise_2_2{


    // This program computes and displays the perimeter of a letter-size sheet of paper and its diagonal

    public static void main (String[] args)
    {
        double width = 8.5;
        double height = 11;
        System.out.printf("The perimeter is:              %.2f \n", width * 2 + height * 2);
        System.out.printf("The length of the diagonal is: %.2f", Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2)));
    }
}

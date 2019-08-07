/**
 * "Write a program that displays the dimensions of a letter-size(8.5 x 11 inches) sheet of paper in millimeters. There are 25.4 millimeters per inch.
 * Use constants and comments in your program."
 */
public class Programming_Exercise_2_1 {

    public static void main(String[] args){

        final double INCH = 25.4;
        double width = 8.5;
        double height = 11;
        System.out.printf("The width in millimeters is:   %.2f \n", width * INCH);
        System.out.printf("The height in millimeters is:  %.2f \n", height * INCH);
    }
}
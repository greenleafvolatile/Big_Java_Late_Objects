import java.util.Random;
import java.util.logging.Logger;

/**
 * "The following method was known to the ancient Greeks for computing square
 * roots. Given a value x>0 and  guess g for the square root, a better gues is
 * (g+x/g)/2. Write a recursive helper method public static squareRootGuess(double x, double g).
 * If g*g is approximately equal to x, return g, otherwise return squareRootGuess with the better guess.
 * Then write a method public static squareRoot(double x) that uses the helper method."
 */

public class Programming_Exercise_13_11 {

    private static double squareRootGuess(double x, double g, int t){

        double epsilon=Math.pow(10, -14);
        if(Math.abs(Math.pow(g, 2)-x)<epsilon){
            return g;
        }
        Logger.getGlobal().info("" + (g+x/g)/2);
        return squareRootGuess(x, (g+x/g)/2, t-1);
    }

    private static double squareRoot(double x){

        double guess=new Random().nextDouble();
        return squareRootGuess(x, guess, 10);
    }
    public static void main(String[] args){

        System.out.println(squareRootGuess(4.0, 1.0, 10));
    }
}

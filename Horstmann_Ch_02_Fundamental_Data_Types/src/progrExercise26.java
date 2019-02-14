/**
 * "Write a program that prompts the user for a measurement in meters and then converts it to miles, feet and inches.
 */

import javax.swing.JOptionPane;

public class progrExercise26 {

    public static void main (String[] args)
    {
        final double MILE = 1600;
        final double FEET = 0.3;
        final double INCH = 0.025;
        double measurementInMeters = Double.parseDouble(JOptionPane.showInputDialog("Please provide a measurement in meters: "));
        JOptionPane.showMessageDialog(null, "The measurement you provided is: " + measurementInMeters + " meters.");
        JOptionPane.showMessageDialog(null, measurementInMeters + " meters is equal to " + measurementInMeters / MILE + " miles.");
        JOptionPane.showMessageDialog(null, measurementInMeters + " meters is equal to " + measurementInMeters / FEET + " feet.");
        JOptionPane.showMessageDialog(null, measurementInMeters + " meters is equal to " + measurementInMeters / INCH + " inches.");
    }

}

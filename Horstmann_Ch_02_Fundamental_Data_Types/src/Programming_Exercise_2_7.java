/**
 * "Write a program that prompts the user for a radius and then prints the area and circumference of a circle wit that radius,
 * and the volume and surface area of a sphere with that radius."
 */

import javax.swing.JOptionPane;

public class Programming_Exercise_2_7{

    public static void main(String[] args){

        double radius = Double.parseDouble(JOptionPane.showInputDialog("Please input a radius."));
        double diameter = radius * 2;
        double area = Math.PI * Math.pow(radius, 2);
        double circumference = Math.PI * diameter;
        double volume = 0.75 * Math.PI * Math.pow(radius, 3);
        double surfaceArea = 4 * Math.PI * Math.pow(radius, 2);
        JOptionPane.showMessageDialog(null, "The radius you entered is: " + radius);
        JOptionPane.showMessageDialog(null, String.format("The area of a circle with radius " + radius + " would be %.2f ", area));
        JOptionPane.showMessageDialog(null, String.format("The circumference of a circle with radius " + radius + " would be %.2f", circumference));
        JOptionPane.showMessageDialog(null, String.format("The volume of a sphere with radius " + radius + " would be %.2f", volume));
        JOptionPane.showMessageDialog(null, String.format("The surface area of a sphere with radius " + radius + " would be %.2f", surfaceArea));
    }
}

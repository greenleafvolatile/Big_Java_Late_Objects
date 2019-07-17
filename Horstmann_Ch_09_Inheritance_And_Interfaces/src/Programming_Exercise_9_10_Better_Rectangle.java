/**
 * "The rectangle class of the standard Java library does not supply a method to compute the area or the perimeter of a rectangle.
 * Provide a subclass 'BetterRectangle' of the Rectangle class that has getPerimeter and getArea methods. Do not add any instance
 * variables. In the constructor, call the setLocation and setSize methods of the Rectangle class. Provide a program that
 * tests the methods that you supplied."
 */

public class Programming_Exercise_9_10_Better_Rectangle extends java.awt.Rectangle {

    public Programming_Exercise_9_10_Better_Rectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }

    public double getPerimeter() {
        return 2*(getWidth()+getHeight());
    }

    public double getArea() {
        return getWidth()*getHeight();
    }

    public static void main(String[] args) {

        Programming_Exercise_9_10_Better_Rectangle rectangle=new Programming_Exercise_9_10_Better_Rectangle(0, 0, 10, 5);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}

/**
 * "Repeat Exercise P9.10, but in the BetterRectangle constructor, invoke the superclass constructor."
 */

public class Programming_Exercise_9_11_Better_Rectangle extends java.awt.Rectangle {

    private Programming_Exercise_9_11_Better_Rectangle(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    private double getPerimeter() {
        return 2 * (getWidth() + getHeight());
    }

    private double getArea() {
        return getWidth() * getHeight();
    }

    public static void main(String[] args) {

        Programming_Exercise_9_11_Better_Rectangle rectangle = new Programming_Exercise_9_11_Better_Rectangle(0, 0, 10, 5);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}
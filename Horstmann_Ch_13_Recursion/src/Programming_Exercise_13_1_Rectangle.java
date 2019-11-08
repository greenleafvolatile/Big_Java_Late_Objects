/**
 * "Given a class Rectangle with instance variables width and height, provide a recursive getArea() method.
 * Construct a rectangle whose width is one less than the original and call its getArea() method."
 */

public class Programming_Exercise_13_1_Rectangle {

    private final int width;
    private final int height;

    private Programming_Exercise_13_1_Rectangle(int aWidth, int aHeight){
        width=aWidth;
        height=aHeight;
    }

    private int getArea(){
        if(width<=0){
            return 0;
        }
        else{
            Programming_Exercise_13_1_Rectangle smallerRectangle=new Programming_Exercise_13_1_Rectangle(width-1, height);
            int smallerArea=smallerRectangle.getArea();
            return smallerArea + height;
        }
    }

    public static void main(String[] args){

        Programming_Exercise_13_1_Rectangle test=new Programming_Exercise_13_1_Rectangle(3, 6);
        System.out.println(test.getArea());

    }

}

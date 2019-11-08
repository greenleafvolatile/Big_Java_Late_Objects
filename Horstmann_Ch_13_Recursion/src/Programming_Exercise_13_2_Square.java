/**
 * "Given a class Square with instance variable width, provide a recursive getArea method. Construct a square whose width
 * is one less than the original and call its getArea() method."
 */

public class Programming_Exercise_13_2_Square {

    private final int width;

    private Programming_Exercise_13_2_Square(int aWidth){
        width=aWidth;

    }

    private int getArea(){
        if(width<=0){
            return 0;
        }
        else{
            Programming_Exercise_13_2_Square smallerSquare=new Programming_Exercise_13_2_Square(width-1);
            int smallerArea=smallerSquare.getArea();
            return smallerArea + ((width * 2) - 1);
        }
    }

    public static void main(String[] args){
        Programming_Exercise_13_2_Square test=new Programming_Exercise_13_2_Square(1);
        System.out.println(test.getArea());
    }

}

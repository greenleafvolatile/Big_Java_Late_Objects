import java.awt.*;

class Programming_Exercise_11_14_Custom_Rectangle extends Rectangle {

    public static final int RECTANGLE_WIDTH = 20, RECTANGLE_HEIGHT = 30;
    private String direction;
    private int xPos, yPos;

    public Programming_Exercise_11_14_Custom_Rectangle(int x, int y, String direction){
        super(x, y, RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        this.xPos = x;
        this.yPos = y;
        this.direction = direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void moveRectangle() {
        if (this.direction.equals("up")) {
            this.xPos--;
            this.yPos--;
            this.setLocation(xPos, yPos);
        }
        else if (this.direction.equals("down")) {
            this.xPos++;
            this.yPos++;
            this.setLocation(xPos, yPos);
        }
    }
}
import java.awt.*;

public class Programming_Exercise_11_15_Car {

    public final static int WIDTH=45, HEIGHT=15, TIRE_DIAMETER=12;
    private int xPos, yPos;
    private boolean movingLeft;

    public Programming_Exercise_11_15_Car(Point point, boolean direction){
        this.movingLeft=direction;
        this.xPos=(int) point.getX();
        this.yPos=(int) point.getY();

    }

    public void drawCar(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw car body.
        g2d.drawRect(xPos, yPos, WIDTH, HEIGHT);

        // Draw car top.
        g2d.drawRect(xPos+(WIDTH/4), yPos-HEIGHT, WIDTH/2, HEIGHT);

        // Draw car tires.
        g2d.fillOval(xPos+(WIDTH/8), yPos+(HEIGHT*4/6), TIRE_DIAMETER, TIRE_DIAMETER);
        g2d.fillOval(xPos+(WIDTH-(WIDTH/8)-TIRE_DIAMETER), yPos+(HEIGHT*4/6), TIRE_DIAMETER, TIRE_DIAMETER);
    }

    public void drive(){
        if(movingLeft==true){
            this.xPos--;
        }
        else{
            this.xPos++;
        }
    }

    public int getXpos(){
        return this.xPos;
    }

    public void setDirection(boolean direction){
        this.movingLeft=direction;
    }

    public void setInitPosition(Point point){
        this.xPos=(int) point.getX();
        this.yPos=(int) point.getY();
    }

    public void setInitDirection(boolean direction){
        this.movingLeft=direction;
    }
}

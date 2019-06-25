import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * This component displays a rectangle that can be moved.
 */

public class Rectangle_Component extends JComponent {

    private static final int RECTANLE_WIDTH=20, RECTANGLE_HEIGHT=30;

    private int xLeft, xTop;

    public Rectangle_Component(){

        xLeft=0;
        xTop=0;
    }

    public void paintComponent(Graphics g){

        g.fillRect(xLeft, xTop, RECTANLE_WIDTH, RECTANGLE_HEIGHT);
    }

    /**
     * Move the rectangle by a given amount.
     * @param dx the amount to move in the x-direction.
     * @param dy the amount to move in the y-direction.
     */

    public void moveRectangleBy(int dx, int dy){
        xLeft=xLeft+dx;
        xTop=xTop+dy;
        repaint();
    }


}

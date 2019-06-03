import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Programming_Exercise_11_13_Component extends JComponent{

    private static final int DIAMETER=25, INIT_XPOS=20, INIT_YPOS=50;
    private int xPos, yPos;

    public Programming_Exercise_11_13_Component(){
        final int BORDER_THICKNESS=2;
        final Color BORDER_COLOR= Color.BLACK;
        this.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
        this.xPos=INIT_XPOS;
        this.yPos=INIT_YPOS;
    }

    public void paintComponent(Graphics g){
        g.fillOval(xPos, yPos, DIAMETER, DIAMETER);
    }

    public void moveRectangleBy(int dx, int dy){
        this.xPos+=dx;
        this.yPos+=dy;
        repaint();
    }

    public int getXpos(){
        return this.xPos;
    }

    public int getYpos(){
        return this.yPos;
    }

    public int getDiameter(){
        return DIAMETER;
    }
    @Override
    public Dimension getPreferredSize(){
        return new Dimension(300, 300);
    }

}

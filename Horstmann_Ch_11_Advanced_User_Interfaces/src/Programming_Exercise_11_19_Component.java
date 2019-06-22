import java.awt.*;
import javax.swing.JComponent;

public class Programming_Exercise_11_19_Component extends JComponent {

    private static final int PREF_WIDTH=1000;
    private static final int PREF_HEIGHT=500;
    private int radius;
    private int xPos;
    private int yPos;

    public Programming_Exercise_11_19_Component(){
    }

    public void paintComponent(Graphics g){
        final int diameter=radius*2;
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(xPos-radius, yPos-radius, diameter, diameter);
    }

    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }


    public void setXPos(int pos){
        xPos=pos;
    }

    public void setYPos(int pos){
        yPos=pos;
    }

    public void setRadius(int length){
        radius=length;
    }
}

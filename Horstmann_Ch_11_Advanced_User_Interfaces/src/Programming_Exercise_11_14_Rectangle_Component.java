import java.util.List;
import java.awt.*;
import javax.swing.JComponent;

/**
 * This component displays a rectangle that can be moved.
 */

public class Programming_Exercise_11_14_Rectangle_Component extends JComponent{

    public static final int PREF_WIDTH=400, PREF_HEIGHT=400;

    private final List<Programming_Exercise_11_14_Custom_Rectangle> rectangles;

    public Programming_Exercise_11_14_Rectangle_Component(List<Programming_Exercise_11_14_Custom_Rectangle> rectangles){
        this.rectangles=rectangles;
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(Programming_Exercise_11_14_Custom_Rectangle rect : rectangles){

            g2d.fillRect((int) rect.getX(), (int)rect.getY(), (int) rect.getWidth(), (int) rect.getHeight());
        }
    }

    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }
}
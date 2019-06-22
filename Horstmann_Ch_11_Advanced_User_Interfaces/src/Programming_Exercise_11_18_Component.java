import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Programming_Exercise_11_18_Component extends JComponent {

    private static final int RECTANGLE_WIDTH=20, RECTANGLE_HEIGHT=30;
    private final ArrayList<Point> list;

    public Programming_Exercise_11_18_Component(){
        list=new ArrayList<>();
    }

    public void paintComponent(Graphics g){

        for(Point point : list){
            g.fillRect((int) point.getX(), (int) point.getY(), RECTANGLE_WIDTH, RECTANGLE_HEIGHT);
        }
    }

    public void addRectangle(int x, int y){
        list.add(new Point(x, y));
        repaint();
    }
}
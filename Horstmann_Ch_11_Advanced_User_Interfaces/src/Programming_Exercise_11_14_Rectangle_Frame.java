import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * "Change the rectangle animation in Section 11.5 so that it shows two rectangles moving in opposite directions."
 */

public class Programming_Exercise_11_14_Rectangle_Frame extends JFrame {

    private final List<Programming_Exercise_11_14_Custom_Rectangle> rectangles;
    private final Programming_Exercise_11_14_Rectangle_Component scene;

    private class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent event){

            for(Programming_Exercise_11_14_Custom_Rectangle rect : rectangles){
                if(rect.getY()==Programming_Exercise_11_14_Rectangle_Component.PREF_HEIGHT-Programming_Exercise_11_14_Custom_Rectangle.RECTANGLE_HEIGHT){
                    rect.setDirection("up");
                }
                else if(rect.getY()==0){
                    rect.setDirection("down");
                }
                rect.moveRectangle();
                scene.repaint();
            }
        }
    }

    Programming_Exercise_11_14_Rectangle_Frame(){

        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);
        final int BORDER_THICKNESS=2;
        final Color BORDER_COLOR=Color.BLACK;
        contPanel.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));

        rectangles=new ArrayList<>();

        Programming_Exercise_11_14_Custom_Rectangle rectOne=new Programming_Exercise_11_14_Custom_Rectangle(0, 0, "down");
        Programming_Exercise_11_14_Custom_Rectangle rectTwo=new Programming_Exercise_11_14_Custom_Rectangle(Programming_Exercise_11_14_Rectangle_Component.PREF_WIDTH-Programming_Exercise_11_14_Custom_Rectangle.RECTANGLE_WIDTH, Programming_Exercise_11_14_Rectangle_Component.PREF_HEIGHT-Programming_Exercise_11_14_Custom_Rectangle.RECTANGLE_HEIGHT, "up");
        rectangles.add(rectOne);
        rectangles.add(rectTwo);

        scene=new Programming_Exercise_11_14_Rectangle_Component(rectangles);
        add(scene);
        this.pack();

        ActionListener listener=new TimerListener();
        final int delay=50;
        Timer t= new Timer(delay, listener);
        t.start();
    }

    public static void main(String[] args){

        JFrame frame=new Programming_Exercise_11_14_Rectangle_Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
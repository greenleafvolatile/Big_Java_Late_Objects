import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * "Write a program that allows the user to specify a circle with two mouse presses, the first one
 * on the center and the second on a point on the periphery. Hint: In the mouse press handler, you must keep track
 * of whether you already received the center point in a previous mouse press."
 */
public class Programming_Exercise_11_21 extends JFrame{

    private boolean firstClick;

    private Programming_Exercise_11_21(){

        JPanel mainPanel=new JPanel();
        mainPanel.setLayout(new BorderLayout());
        setContentPane(mainPanel);
        Programming_Exercise_11_21_Component component=new Programming_Exercise_11_21_Component();
        firstClick=true;
        component.addMouseListener(new MouseAdapter(){

            public void mousePressed(MouseEvent event){
                if(firstClick){
                    component.setCenter(event.getX(), event.getY());
                }
                else{
                    component.drawCircle(event.getX(), event.getY());
                }
                firstClick=!firstClick;
            }
        });
        mainPanel.add(component, BorderLayout.CENTER);
        pack();
    }

    private class Programming_Exercise_11_21_Component extends JComponent {

        final int PREF_WIDTH=400;
        final int PREF_HEIGHT=400;
        private int radius;
        private Point center;


        public void paintComponent(Graphics g){
            final int DIAMETER=radius*2;
            Graphics2D g2d=(Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if(center!=null){
                g2d.drawOval( (int) center.getX()-radius, (int) center.getY()-radius, DIAMETER, DIAMETER);
            }
        }

        void setCenter(int x, int y){
            center=new Point(x, y);
        }

        void drawCircle(int x, int y){
            Point periphery=new Point(x, y);
            radius=(int) Math.sqrt(Math.pow((periphery.getX()-center.getX()),2) + Math.pow((periphery.getY()-center.getY()),2));
            repaint();
        }

        public Dimension getPreferredSize(){
            return new Dimension(PREF_WIDTH, PREF_HEIGHT);
        }

    }

    private static void createAndShowGUI(){
        JFrame frame=new Programming_Exercise_11_21();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Programming_Exercise_11_21::createAndShowGUI);
    }
}

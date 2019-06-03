import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * "Write a program that displays a number of rectangles at random positions. Supply menu items "Fewer" and "More" that generate fewer or more random rectangles.
 * Each time the user selects "Fewer", the count should be halved. Each time the user clicks on "More", the count should be doubled."
 */

public class Programming_Exercise_11_7 extends JFrame {

    private final Rectangle_Component rectangleComponent;

    private Programming_Exercise_11_7(){
        this.rectangleComponent=new Rectangle_Component();
        this.add(rectangleComponent);
        this.createMenuBar();
        this.pack();
    }

    class Rectangle_Component extends JComponent{

        private final int RECT_WIDTH=30, RECT_HEIGHT=15,COMP_WIDTH=400, COMP_HEIGHT=400, INIT_NR_RECT=1;
        private final Random randomGenerator=new Random();
        private final Color rectangleColor=Color.RED;

        private final List<Rectangle> rectangles;

        Rectangle_Component(){
            this.rectangles=new ArrayList<>();
            this.initRectangles();
        }

        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(rectangleColor);
            for(Rectangle rect: rectangles){
                g.fillRect((int) rect.getX(), (int) rect.getY(), RECT_WIDTH, RECT_HEIGHT);
            }
        }


        @Override
        public Dimension getPreferredSize(){
            return new Dimension(COMP_WIDTH, COMP_HEIGHT);
        }

        private void doubleNrOfRectangles(){
            int value=rectangles.size();
            for(int i=0;i<value;i++){
                Rectangle rect=new Rectangle(randomGenerator.nextInt(COMP_WIDTH-RECT_WIDTH), randomGenerator.nextInt(COMP_HEIGHT-RECT_HEIGHT), RECT_WIDTH, RECT_HEIGHT);
                rectangles.add(rect);
            }
            repaint();
        }

        private void halveNrOfRectangles(){

            if(rectangles.size()>=2){
                rectangles.subList(rectangles.size()/2, rectangles.size()).clear();
            }
            else{
                JOptionPane.showMessageDialog(this, "Cannot have less than one rectangle!", "Error!", JOptionPane.ERROR_MESSAGE);
            }
            repaint();
        }

        private void initRectangles(){
            for(int i=0;i<INIT_NR_RECT;i++){
                Rectangle rect=new Rectangle(randomGenerator.nextInt(COMP_WIDTH-RECT_WIDTH), randomGenerator.nextInt(COMP_HEIGHT-RECT_HEIGHT), RECT_WIDTH, RECT_HEIGHT);
                rectangles.add(rect);
            }
        }
    }

    private void createMenuBar(){
        JMenuBar menuBar=new JMenuBar();
        JMenu moreOrLess=new JMenu("Rectangles");
        JMenuItem more=new JMenuItem("More");
        JMenuItem less=new JMenuItem("Less");

        more.addActionListener(e -> Programming_Exercise_11_7.this.rectangleComponent.doubleNrOfRectangles());
        less.addActionListener(e -> Programming_Exercise_11_7.this.rectangleComponent.halveNrOfRectangles());

        moreOrLess.add(more);
        moreOrLess.add(less);
        menuBar.add(moreOrLess);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_7();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

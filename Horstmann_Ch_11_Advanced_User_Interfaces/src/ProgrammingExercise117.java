import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProgrammingExercise117 extends JFrame {

    private final RectangleComponent3 rectangleComponent;

    private ProgrammingExercise117(){
        this.rectangleComponent=new RectangleComponent3();
        this.add(rectangleComponent);
        this.createMenuBar();
        this.pack();
    }

    class RectangleComponent3 extends JComponent{

        private final int RECT_WIDTH=30, RECT_HEIGHT=15,COMP_WIDTH=400, COMP_HEIGHT=400, INIT_NR_RECT=1;
        private final Random randomGenerator=new Random();
        private final Color rectangleColor=Color.RED;

        private final List<Rectangle> rectangles;

        RectangleComponent3(){
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

        more.addActionListener(e -> ProgrammingExercise117.this.rectangleComponent.doubleNrOfRectangles());
        less.addActionListener(e -> ProgrammingExercise117.this.rectangleComponent.halveNrOfRectangles());

        moreOrLess.add(more);
        moreOrLess.add(less);
        menuBar.add(moreOrLess);
        setJMenuBar(menuBar);
    }

    public static void main(String[] args){
        JFrame frame=new ProgrammingExercise117();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

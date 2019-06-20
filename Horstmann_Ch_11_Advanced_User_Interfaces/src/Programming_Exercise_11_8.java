import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Modify the program of Exercise P11.7 to replace the buttons with a slider to
 * generate more or fewer random rectangles.
 */
public class Programming_Exercise_11_8 extends JFrame {

    private final RectangleComponent3 rectangleComponent;
    private JPanel sliderPanel;
    private int actualSliderValue;

    private Programming_Exercise_11_8(){
        this.rectangleComponent=new RectangleComponent3();
        this.createSliderPanel();
        this.constructFrame();
        this.pack();
    }

    private void createSliderPanel(){
        sliderPanel=new JPanel();
        JSlider slider=new JSlider(0, 10, 0);
        actualSliderValue=slider.getValue();

        slider.addChangeListener(e -> {
            if(slider.getValue()>actualSliderValue){
                Programming_Exercise_11_8.this.rectangleComponent.doubleNrOfRectangles();
            }
            else if(slider.getValue()<actualSliderValue){
                Programming_Exercise_11_8.this.rectangleComponent.halveNrOfRectangles();
            }
            actualSliderValue=slider.getValue();

        });
        sliderPanel.add(slider);
    }

    private void constructFrame(){
        this.add(rectangleComponent, BorderLayout.CENTER);
        this.add(sliderPanel, BorderLayout.SOUTH);
    }


    class RectangleComponent3 extends JComponent{

        private final int RECT_WIDTH=30, RECT_HEIGHT=15,COMP_WIDTH=400, COMP_HEIGHT=400;
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
            repaint();
        }

        private void initRectangles(){
            final int INIT_NR_RECT=1;
            for(int i=0;i<INIT_NR_RECT;i++){
                Rectangle rect=new Rectangle(randomGenerator.nextInt(COMP_WIDTH-RECT_WIDTH), randomGenerator.nextInt(COMP_HEIGHT-RECT_HEIGHT), RECT_WIDTH, RECT_HEIGHT);
                rectangles.add(rect);
            }
        }

    }


    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_8();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
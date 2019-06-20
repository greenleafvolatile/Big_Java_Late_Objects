import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/**
 * "Modify the slider program in Section 11.4 to add a set of tick marks to each slider
 * that show the exact slider position."
 */
public class Programming_Exercise_11_9 extends JFrame{

    private JPanel colorPanel;
    private JSlider redSlider, blueSlider, greenSlider;
    private final static int FRAME_WIDTH=300, FRAME_HEIGHT=400;

    public Programming_Exercise_11_9(){

        colorPanel=new JPanel();
        add(colorPanel, BorderLayout.CENTER);
        createControlPanel();
        setSampleColor();

        setSize(FRAME_WIDTH, FRAME_HEIGHT);


    }

    class ColorListener implements ChangeListener {

        public void stateChanged(ChangeEvent event){
            setSampleColor();
        }

    }
    public void createControlPanel(){

        ChangeListener listener=new ColorListener();

        redSlider=new JSlider(0, 255, 255);
        redSlider.setMajorTickSpacing(25);
        redSlider.setPaintTicks(true);
        redSlider.addChangeListener(listener);

        blueSlider=new JSlider(0, 255, 175);
        blueSlider.setMajorTickSpacing(25);
        blueSlider.setPaintTicks(true);
        blueSlider.addChangeListener(listener);

        greenSlider=new JSlider(0, 255, 175);
        greenSlider.setMajorTickSpacing(25);
        greenSlider.setPaintTicks(true);
        greenSlider.addChangeListener(listener);

        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(3, 2));

        controlPanel.add(new JLabel("Red"));
        controlPanel.add(redSlider);

        controlPanel.add(new JLabel("Green"));
        controlPanel.add(greenSlider);

        controlPanel.add(new JLabel("Blue"));
        controlPanel.add(blueSlider);

        add(controlPanel, BorderLayout.SOUTH);

    }

    public void setSampleColor(){

        // Read slider values

        int red=redSlider.getValue();
        int blue=blueSlider.getValue();
        int green=greenSlider.getValue();

        // Set panel background to selected color

        colorPanel.setBackground(new Color(red, green, blue));
        colorPanel.repaint();

    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_9();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
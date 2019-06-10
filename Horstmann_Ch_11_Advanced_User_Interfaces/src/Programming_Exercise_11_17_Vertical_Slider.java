import javax.swing.*;
import java.awt.*;

public class Programming_Exercise_11_17_Vertical_Slider extends JFrame {

    private int height;

    public Programming_Exercise_11_17_Vertical_Slider(int height){
        this.height=height;
        this.initializeUI();
    }

    public void initializeUI(){

        JPanel panel=new JPanel();
        panel.setLayout(new GridLayout(1, 1));
        panel.setPreferredSize(new Dimension(0, height));
        System.out.print(this.getMinimumSize().width);
        JSlider slider=new JSlider(JSlider.VERTICAL, 0, 100, 0);
        panel.add(slider);
        this.setContentPane(panel);
        this.pack();
    }
}

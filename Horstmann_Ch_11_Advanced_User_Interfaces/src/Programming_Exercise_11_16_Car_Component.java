import java.util.List;
import java.awt.*;
import javax.swing.*;

public class Programming_Exercise_11_16_Car_Component extends JComponent {

    public static final int PREF_WIDTH=400;
    public static final int PREF_HEIGHT=400;

    private final List<Programming_Exercise_11_16_Car> cars;

    public Programming_Exercise_11_16_Car_Component(List<Programming_Exercise_11_16_Car> cars){
        this.cars=cars;

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int i=0;i<cars.size();i++){
            cars.get(i).drawCar(g);
        }
    }


    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

}

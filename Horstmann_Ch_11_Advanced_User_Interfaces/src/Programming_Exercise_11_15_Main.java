import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * "Write a program that animates a car so that it moves across a frame."
 */

public class Programming_Exercise_11_15_Main extends JFrame{

    private final List<Programming_Exercise_11_15_Car> cars;
    private final Programming_Exercise_11_15_Car_Component carComponent;

    private Programming_Exercise_11_15_Main(){

        cars=new ArrayList<>();
        cars.add(new Programming_Exercise_11_15_Car(new Point(0, Programming_Exercise_11_15_Car_Component.PREF_HEIGHT/2), "right"));

        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);

        Color borderColor=Color.BLACK;
        int borderThickness=2;
        contPanel.setBorder(new LineBorder(borderColor, borderThickness));

        carComponent=new Programming_Exercise_11_15_Car_Component(cars);

        contPanel.add(carComponent);

        this.pack();

        int delay=20;

        Timer t1=new Timer(delay, new CarListener());
        t1.start();
    }

    class CarListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            for (Programming_Exercise_11_15_Car car : cars) {
                if (car.getXpos() == 0) {
                    car.setDirection("right");
                } else if (car.getXpos() + Programming_Exercise_11_15_Car.WIDTH == carComponent.getPreferredSize().width - 1) {
                    car.setDirection("left");
                }
                car.drive();
                carComponent.repaint();
            }
        }
    }

    public static void main(String[] args){
        JFrame carFrame=new Programming_Exercise_11_15_Main();
        carFrame.setLocationRelativeTo(null);
        carFrame.setVisible(true);
        carFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
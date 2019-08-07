import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Write a program that animates two cars moving across a frame in opposite directions (but at different heights so that they don't collide)
 */

public class Programming_Exercise_11_16_Main extends JFrame {

    List<Programming_Exercise_11_16_Car> cars;
    Programming_Exercise_11_16_Car_Component carComponent;

    private Programming_Exercise_11_16_Main(){

        cars=new ArrayList<>();
        cars.add(new Programming_Exercise_11_16_Car(new Point(Programming_Exercise_11_16_Car_Component.PREF_WIDTH/2, 50), "left"));
        cars.add(new Programming_Exercise_11_16_Car(new Point(Programming_Exercise_11_16_Car_Component.PREF_WIDTH/2- Programming_Exercise_11_16_Car.WIDTH, 150), "right"));

        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);

        Color borderColor=Color.BLACK;
        int borderThickness=2;
        contPanel.setBorder(new LineBorder(borderColor, borderThickness));

        carComponent=new Programming_Exercise_11_16_Car_Component(cars);

        contPanel.add(carComponent);

        this.pack();

        int delay=20;

        Timer t1=new Timer(delay, new CarListener());
        t1.start();
    }

    class CarListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            for(int i=0;i<cars.size();i++){
                if(cars.get(i).getXpos()==0){
                    cars.get(i).setDirection("right");
                }
                else if(cars.get(i).getXpos()+ Programming_Exercise_11_16_Car.WIDTH==carComponent.getPreferredSize().width-1){
                    cars.get(i).setDirection("left");
                }
                cars.get(i).drive();
            }
            carComponent.repaint();
        }
    }


    public static void main(String[] args){
        JFrame carFrame=new Programming_Exercise_11_16_Main();
        carFrame.setLocationRelativeTo(null);
        carFrame.setVisible(true);
        carFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programming_Exercise_11_15_Main extends JFrame {

    boolean driveRight, driveLeft;
    List<Programming_Exercise_11_15_Car> cars;
    Programming_Exercise_11_15_Car_Component carComponent;

    private Programming_Exercise_11_15_Main(){
        driveLeft=true;
        driveRight=false;

        cars=new ArrayList<>();

        cars.add(new Programming_Exercise_11_15_Car(new Point(200, 50), driveRight));

        cars.add(new Programming_Exercise_11_15_Car(new Point(200, 150), driveLeft));

        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);

        Color borderColor=Color.BLACK;
        int borderThickness=2;
        contPanel.setBorder(new LineBorder(borderColor, borderThickness));


        //Programming_Exercise_11_15_Car carOne=new Programming_Exercise_11_15_Car(new Point(200, 50), driveRight);
        //Programming_Exercise_11_15_Car carTwo=new Programming_Exercise_11_15_Car(new Point(200-Programming_Exercise_11_15_Car.WIDTH, 100),driveLeft);

        carComponent=new Programming_Exercise_11_15_Car_Component(cars);

        contPanel.add(carComponent);

        this.pack();

        int delay=50;

        Timer t1=new Timer(delay, new CarListener());/*new ActionListener(){

            public void actionPerformed(ActionEvent event){
                if(carOne.getXpos()==0){
                    carOne.setDirection(Programming_Exercise_11_15_Main.this.driveRight);
                }
                else if(carOne.getXpos()+Programming_Exercise_11_15_Car.WIDTH==carComponent.getPreferredSize().width-1){
                    carOne.setDirection(driveLeft);

                }
                carOne.drive();
                carComponent.repaint();

            }
        });

        Timer t2=new Timer(delay, new ActionListener(){

            public void actionPerformed(ActionEvent event){
                if(carTwo.getXpos()==0){
                    carTwo.setDirection(driveRight);
                }
                else if(carTwo.getXpos()+Programming_Exercise_11_15_Car.WIDTH==carComponent.getPreferredSize().width-1){
                    scarTwo.setDirection(driveLeft);
                }
                carTwo.drive();
                carComponent.repaint();

            }
        });*/
        t1.start();
        //t2.start();
    }

    class CarListener implements ActionListener{

        public void actionPerformed(ActionEvent event){
            for(int i=0;i<cars.size();i++){
                if(cars.get(i).getXpos()==0){
                    cars.get(i).setDirection(driveRight);
                }
                else if(cars.get(i).getXpos()+Programming_Exercise_11_15_Car.WIDTH==carComponent.getPreferredSize().width-1){
                    cars.get(i).setDirection(driveLeft);
                }
                cars.get(i).drive();
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

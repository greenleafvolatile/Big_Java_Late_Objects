import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programming_Exercise_11_15_Main extends JFrame {

    public Programming_Exercise_11_15_Main(){
        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);
        Color borderColor=Color.BLACK;
        int borderThickness=2;
        contPanel.setBorder(new LineBorder(borderColor, borderThickness));
        Programming_Exercise_11_15_Car_Component carComponent=new Programming_Exercise_11_15_Car_Component();
        carComponent.setCarOneInitPos(new Point(0, carComponent.getPreferredSize().height*1/4));
        carComponent.setCarTwoInitPos(new Point(carComponent.getPreferredSize().width-Programming_Exercise_11_15_Car.getCarWidth(), carComponent.getPreferredSize().height*3/4));

        contPanel.add(carComponent);
        this.pack();
        int carOneSpeed=1;
        int carTwoSpeed=-1;
        Timer t1=new Timer(100, new ActionListener(){

            public void actionPerformed(ActionEvent event){
                carComponent.moveCarOne(carOneSpeed);
            }
        });
        Timer t2=new Timer(100, new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                carComponent.moveCarTwo(carTwoSpeed);
            }
        });
        t1.start();
        t2.start();

    }

    public static void main(String[] args){
        JFrame carFrame=new Programming_Exercise_11_15_Main();
        carFrame.setVisible(true);
        carFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

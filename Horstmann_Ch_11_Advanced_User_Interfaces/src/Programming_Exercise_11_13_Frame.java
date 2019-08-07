import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programming_Exercise_11_13_Frame extends JFrame{



    private final Programming_Exercise_11_13_Component scene;
    private int dx,dy;


    public Programming_Exercise_11_13_Frame(){
        this.dx=1;
        this.dy=1;
        this.scene=new Programming_Exercise_11_13_Component();
        this.add(scene);
        this.pack();

        ActionListener listener=new TimerListener();

        final int DELAY=10;
        Timer t=new Timer(DELAY, listener);
        t.start();
    }

    class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(Programming_Exercise_11_13_Frame.this.scene.getXpos()==0){
                Programming_Exercise_11_13_Frame.this.dx=1;
            }
            else if(Programming_Exercise_11_13_Frame.this.scene.getXpos()+ Programming_Exercise_11_13_Frame.this.scene.getDiameter()== Programming_Exercise_11_13_Frame.this.scene.getPreferredSize().width){
                Programming_Exercise_11_13_Frame.this.dx=-1;
            }
            if(Programming_Exercise_11_13_Frame.this.scene.getYpos()==0){
                Programming_Exercise_11_13_Frame.this.dy=1;
            }
            else if(Programming_Exercise_11_13_Frame.this.scene.getYpos()+ Programming_Exercise_11_13_Frame.this.scene.getDiameter()== Programming_Exercise_11_13_Frame.this.scene.getPreferredSize().height){
                Programming_Exercise_11_13_Frame.this.dy=-1;
            }
            scene.moveRectangleBy(Programming_Exercise_11_13_Frame.this.dx, Programming_Exercise_11_13_Frame.this.dy);
        }
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rectangle_Frame extends JFrame {

    private static final int FRAME_WIDTH=300, FRAME_HEIGHT=400;

    private Rectangle_Component scene;

    class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent event){

            scene.moveRectangleBy(1, 1);
        }
    }

    public Rectangle_Frame(){

        scene=new Rectangle_Component();
        add(scene);

        setSize(FRAME_WIDTH, FRAME_HEIGHT);

        ActionListener listener=new TimerListener();

        final int delay=100; // Milliseconds between timer ticks
        Timer t= new Timer(delay, listener);
        t.start();
    }
}

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgrammingExercise11_13_Frame extends JFrame{



    private final ProgrammingExercise11_13_Component scene;
    private int dx,dy;


    public ProgrammingExercise11_13_Frame(){
        this.dx=1;
        this.dy=1;
        this.scene=new ProgrammingExercise11_13_Component();
        this.add(scene);
        this.pack();

        ActionListener listener=new TimerListener();

        final int DELAY=10;
        Timer t=new Timer(DELAY, listener);
        t.start();
    }

    class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(ProgrammingExercise11_13_Frame.this.scene.getXpos()==0){
                ProgrammingExercise11_13_Frame.this.dx=1;
            }
            else if(ProgrammingExercise11_13_Frame.this.scene.getXpos()+ ProgrammingExercise11_13_Frame.this.scene.getDiameter()== ProgrammingExercise11_13_Frame.this.scene.getPreferredSize().width){
                ProgrammingExercise11_13_Frame.this.dx=-1;
            }
            if(ProgrammingExercise11_13_Frame.this.scene.getYpos()==0){
                ProgrammingExercise11_13_Frame.this.dy=1;
            }
            else if(ProgrammingExercise11_13_Frame.this.scene.getYpos()+ ProgrammingExercise11_13_Frame.this.scene.getDiameter()== ProgrammingExercise11_13_Frame.this.scene.getPreferredSize().height){
                ProgrammingExercise11_13_Frame.this.dy=-1;
            }
            scene.moveRectangleBy(ProgrammingExercise11_13_Frame.this.dx, ProgrammingExercise11_13_Frame.this.dy);
        }
    }
}

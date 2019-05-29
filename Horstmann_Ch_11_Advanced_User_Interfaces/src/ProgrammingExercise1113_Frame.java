import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProgrammingExercise1113_Frame extends JFrame{



    private final ProgrammingExercise1113_Component scene;
    private int dx,dy;


    public ProgrammingExercise1113_Frame(){
        this.dx=1;
        this.dy=1;
        this.scene=new ProgrammingExercise1113_Component();
        this.add(scene);
        this.pack();

        ActionListener listener=new TimerListener();

        final int DELAY=10;
        Timer t=new Timer(DELAY, listener);
        t.start();

    }

    class TimerListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            if(ProgrammingExercise1113_Frame.this.scene.getXpos()==0){
                ProgrammingExercise1113_Frame.this.dx=1;
            }
            else if(ProgrammingExercise1113_Frame.this.scene.getXpos()+ ProgrammingExercise1113_Frame.this.scene.getDiameter()== ProgrammingExercise1113_Frame.this.scene.getPreferredSize().width){
                ProgrammingExercise1113_Frame.this.dx=-1;
            }
            if(ProgrammingExercise1113_Frame.this.scene.getYpos()==0){
                ProgrammingExercise1113_Frame.this.dy=1;
            }
            else if(ProgrammingExercise1113_Frame.this.scene.getYpos()+ ProgrammingExercise1113_Frame.this.scene.getDiameter()== ProgrammingExercise1113_Frame.this.scene.getPreferredSize().height){
                ProgrammingExercise1113_Frame.this.dy=-1;
            }
            scene.moveRectangleBy(ProgrammingExercise1113_Frame.this.dx, ProgrammingExercise1113_Frame.this.dy);
        }
    }
}

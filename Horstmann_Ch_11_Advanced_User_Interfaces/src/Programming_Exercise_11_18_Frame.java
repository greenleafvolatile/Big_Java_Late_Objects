import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * "Change the RectangleComponent for the mouse listener program in Section 11.6 so that a new rectangle is added to
 * the component whenever the mouse is clicked. Hint: Store all points on which the user clicked, and draw all rectangles
 * in the paintComponent method.
 */
public class Programming_Exercise_11_18_Frame extends JFrame{

    private static final int FRAME_WIDTH=300;
    private static final int FRAME_HEIGHT=400;

    private final Programming_Exercise_11_18_Component scene;

    private Programming_Exercise_11_18_Frame(){

        scene=new Programming_Exercise_11_18_Component();
        this.add(scene);
        MouseListener listener=new MousePressListener();
        scene.addMouseListener(listener);
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);

    }

    class MousePressListener implements MouseListener{

        public void mousePressed(MouseEvent event){
            int x=event.getX();
            int y=event.getY();
            scene.addRectangle(x, y);
        }


        public void mouseReleased(MouseEvent event){}

        public void mouseClicked(MouseEvent event){}

        public void mouseEntered(MouseEvent event){}

        public void mouseExited(MouseEvent event){}
    }

    private static void createAndShowGUI(){
        JFrame frame=new Programming_Exercise_11_18_Frame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Programming_Exercise_11_18_Frame::createAndShowGUI);
    }
}
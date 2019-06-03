import java.awt.*;
import javax.swing.JComponent;

public class Programming_Exercise_11_17_Component extends JComponent {

    public static final int PREF_WIDTH=400, PREF_HEIGHT=400;
    private int xPos;
    private int yPos;
    private String message;
    private Font font;

    public Programming_Exercise_11_17_Component(String message, Font font) {
        this.font=font;
        this.xPos=PREF_WIDTH/2;
        this.yPos=0;
        this.message=message;
    }

    @Override
    public void paintComponent(Graphics g){
        g.setFont(this.font);
        g.drawString(message, xPos, yPos);

    }

    public void moveMessage(){
        this.yPos++;
        repaint();

    }
    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

}

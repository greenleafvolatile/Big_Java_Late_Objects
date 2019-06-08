import java.awt.Canvas;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.logging.Logger;
import javax.swing.JComponent;

public class Programming_Exercise_11_17_Component extends JComponent {

    public static final int PREF_WIDTH = 400, PREF_HEIGHT = 400;

    private Rectangle2D messageMetrics;
    private Programming_Exercise_11_17_Direction direction;
    private int xPos, yPos;
    private String message;

    public Programming_Exercise_11_17_Component(String message, Font font) {
        this.setFont(font);
        this.direction = new Programming_Exercise_11_17_Direction("left", "up");
        this.message = message;
        Canvas c=new Canvas();
        int messageHeight=c.getFontMetrics(font).getHeight();
        this.xPos=PREF_WIDTH;
        this.yPos=PREF_HEIGHT+messageHeight;
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        this.messageMetrics=g2d.getFontMetrics().getStringBounds(message, g2d);
        g.drawString(message, xPos, yPos);
        System.out.println(String.format("(%d, %d)", xPos, yPos));
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        this.message=message;
        repaint();
    }

    public Rectangle2D getMessageMetrics() {
        return this.messageMetrics;
    }

    public void moveMessage() {
        if (this.direction.getVerticalDirection().equals("down") && this.direction.getHorizontalDirection().equals("left")) {
            this.xPos--;
            this.yPos++;
        } else if (this.direction.getVerticalDirection().equals("up") && this.direction.getHorizontalDirection().equals("right")) {
            this.xPos++;
            this.yPos--;
        } else if (this.direction.getVerticalDirection().equals("up") && this.direction.getHorizontalDirection().equals("left")) {
            this.xPos--;
            this.yPos--;
        } else if (this.direction.getVerticalDirection().equals("down") && this.direction.getHorizontalDirection().equals("right")) {
            this.xPos++;
            this.yPos++;
        }
        repaint();
    }

    public void setNewDirection(String horizontal, String vertical) {
        this.direction.setHorizontalDirection(horizontal);
        this.direction.setVerticalDirection(vertical);
        repaint();
    }

    public Programming_Exercise_11_17_Direction getDirection() {
        return this.direction;
    }

    public Dimension getPreferredSize() {
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

    public int getXpos() {
        return this.xPos;
    }

    public int getYpos() {
        return this.yPos;
    }

    public void setXpos(int pos) {
        this.xPos = pos;
    }

    public void setYpos(int pos) {
        this.yPos = pos;
    }
}


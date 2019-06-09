import java.awt.Canvas;
import java.awt.*;
import java.util.logging.Logger;
import javax.swing.*;

public class Programming_Exercise_11_17_Component extends JComponent{

    public static final int PREF_WIDTH = 400, PREF_HEIGHT = 400;

    private String_Metrics_Calculator calculator;
    private Programming_Exercise_11_17_Direction direction;
    private int xPos, yPos;
    private String message;

    public Programming_Exercise_11_17_Component(String message, Font font) {
        this.setFont(font);
        this.message = message;
        this.direction = new Programming_Exercise_11_17_Direction("right", "down");
        final Point INIT_POSITION=new Point(0-new Canvas().getFontMetrics(this.getFont()).stringWidth(this.message), 0);
        this.xPos=(int) INIT_POSITION.getX();
        this.yPos=(int) INIT_POSITION.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(message, xPos, yPos);
    }

    public String getMessage(){
        return this.message;
    }

    public void setMessage(String message){
        Logger.getGlobal().info("Check!");
        this.message=message;
        this.repaint();
    }

    public int getMessageHeight() {
        return new Canvas().getFontMetrics(this.getFont()).stringWidth(this.message);
    }

    public int getMessageWidth(){
        return new Canvas().getFontMetrics(this.getFont()).stringWidth(this.message);
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


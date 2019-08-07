import java.awt.Canvas;
import java.awt.*;
import javax.swing.*;

public class Programming_Exercise_11_17_Component extends JComponent{

    public static final int PREF_WIDTH = 400;
    public static final int PREF_HEIGHT = 400;

    private final Programming_Exercise_11_17_Direction direction;
    private int xPos, yPos;
    private String message;
    private Dimension dimension;

    public Programming_Exercise_11_17_Component(String message, Font font) {
        dimension=new Dimension(PREF_WIDTH, PREF_HEIGHT);
        setFont(font);
        this.message = message;
        direction = new Programming_Exercise_11_17_Direction("right", "down");
        final Point INIT_POSITION=new Point(0-new Canvas().getFontMetrics(this.getFont()).stringWidth(this.message), 0);
        xPos=(int) INIT_POSITION.getX();
        yPos=(int) INIT_POSITION.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d=(Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(message, xPos, yPos);
    }

    public void setMessage(String message){
        this.message=message;
        repaint();
    }

    public int getMessageHeight() {
        return new Canvas().getFontMetrics(getFont()).stringWidth(message);
    }

    public int getMessageWidth(){
        return new Canvas().getFontMetrics(getFont()).stringWidth(message);
    }

    public void moveMessage() {
        if (direction.getVerticalDirection().equals("down") && direction.getHorizontalDirection().equals("left")) {
            xPos--;
            yPos++;
        } else if (direction.getVerticalDirection().equals("up") && direction.getHorizontalDirection().equals("right")) {
            xPos++;
            yPos--;
        } else if (direction.getVerticalDirection().equals("up") && direction.getHorizontalDirection().equals("left")) {
            xPos--;
            yPos--;
        } else if (direction.getVerticalDirection().equals("down") && direction.getHorizontalDirection().equals("right")) {
            xPos++;
            yPos++;
        }
        repaint();
    }

    public void setNewDirection(String horizontalDirection, String verticalDirection) {
        direction.setHorizontalDirection(horizontalDirection);
        direction.setVerticalDirection(verticalDirection);
    }

    public Programming_Exercise_11_17_Direction getDirection() {
        return direction;
    }

    public Dimension getPreferredSize() {
        return dimension;
    }

    public void setDimension(int width, int height){
        dimension=new Dimension(width, height);
    }


    public int getYpos() {
        return yPos;
    }

    public void setXpos(int pos) {
        xPos = pos;
    }

    public void setYpos(int pos) {
        yPos = pos;
    }
}


import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;

public class Programming_Exercise_11_17_Component extends JComponent {

    public static final int PREF_WIDTH = 400, PREF_HEIGHT = 400;
    public static final Point initPos = new Point(0, 0);
    //public static final String INIT_HORIZONTAL_DIRECTION = "right", INIT_VERTICAL_DIRECTION="down");

    private Rectangle2D messageRect;
    private Programming_Exercise_11_17_Direction direction;
    private boolean up, left;
    private int xPos, yPos;
    private String message, horDirection, verDirection;

    public Programming_Exercise_11_17_Component(String message) {
        this.direction=new Programming_Exercise_11_17_Direction("right", "down");
        this.message = message;
        //this.horDirection = INIT_HORIZONTAL_DIRECTION;
        //this.verDirection = INIT_VERTICAL_DIRECTION;
        this.xPos = (int) initPos.getX();
        this.yPos = (int) initPos.getY();
    }

    @Override
    public void paintComponent(Graphics g) {
        this.messageRect = getMessageRect(g, message);
        g.drawString(message, xPos - ((int) messageRect.getWidth()), yPos);

    }


    public Rectangle2D getMessageRect(Graphics g, String message) {
        Graphics2D g2d = (Graphics2D) g;
        return g2d.getFontMetrics().getStringBounds(message, g2d);
    }

    public int getMessageHeight() {
        return (int) this.messageRect.getHeight();
    }

    public int getMessageWidth(){
        return (int) this.messageRect.getWidth();
    }


    public void moveMessage() {
        if (this.direction.getVerticalDirecion().equals("down") && this.direction.getHorizontalDirectoin().equals("left")){
            this.xPos--;
            this.yPos++;
        }
        else if (this.direction.getVerticalDirecion().equals("up") && this.direction.getHorizontalDirectoin().equals("right")){
            this.xPos++;
            this.yPos++;
        }
        else if (this.direction.getVerticalDirecion().equals("up") && this.direction.getHorizontalDirectoin().equals("left")){
            this.xPos--;
            this.yPos--;
        }
        else if(this.direction.getVerticalDirecion().equals("down") && this.direction.getHorizontalDirectoin().equals("right")){
            this.xPos++;
            this.yPos++;
        }
        repaint();
    }

    public void setNewDirection(String horizontal, String vertical){
        this.direction.setHorizontalDirectoin(horizontal);
        this.direction.setVerticalDirection(vertical);

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

    public void setUp(){
        this.up=!up;
    }

    public void setLeft(){
        this.left=!left;
    }

    public boolean getUp(){
        return this.up;
    }

    public boolean getLeft(){
        return this.left;
    }
}


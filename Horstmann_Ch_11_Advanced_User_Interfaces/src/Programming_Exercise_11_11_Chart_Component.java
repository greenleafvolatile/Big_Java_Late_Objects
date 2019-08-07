import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class Programming_Exercise_11_11_Chart_Component extends JComponent{

    private static final int PREF_WIDTH=400;
    private static final int PREF_HEIGHT=800;

    private final List<Programming_Exercise_11_11_Item> items;


    public Programming_Exercise_11_11_Chart_Component(){
        this.items=new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        final int ITEM_HEIGHT=20, GAP=20;

        int y=GAP;
        for (Programming_Exercise_11_11_Item item : items) {
            g.setColor(Color.BLACK);
            g.drawString(item.getName(), 0, y);
            g.setColor(item.getColor());
            g.fillRect(0, y + 5,item.getLength(), ITEM_HEIGHT);
            y += GAP + ITEM_HEIGHT;
            if (y > Programming_Exercise_11_11_Chart_Component.PREF_HEIGHT) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(Programming_Exercise_11_11_Chart_Component.this, "Cannot not add anymore items", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                });
            }
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

    public void addBar(Programming_Exercise_11_11_Item bar){
        items.add(bar);
        repaint();
    }

    public void reset(){
        this.items.clear();
        repaint();
    }
}

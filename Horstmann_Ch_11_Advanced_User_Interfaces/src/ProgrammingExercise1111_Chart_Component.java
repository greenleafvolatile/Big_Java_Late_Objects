import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ProgrammingExercise1111_Chart_Component extends JComponent{

    private static final int PREF_WIDTH=400;
    private static final int PREF_HEIGHT=800;

    private final List<ProgrammingExercise1111_Item> items;


    public ProgrammingExercise1111_Chart_Component(){
        this.items=new ArrayList<>();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        final int ITEM_HEIGHT=20, GAP=20;

        int y=GAP;
        for (ProgrammingExercise1111_Item item : items) {
            g.setColor(Color.BLACK);
            g.drawString(item.getName(), 0, y);
            g.setColor(item.getColor());
            g.fillRect(0, y + 5,item.getLength(), ITEM_HEIGHT);
            y += GAP + ITEM_HEIGHT;
            if (y > ProgrammingExercise1111_Chart_Component.PREF_HEIGHT) {

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        JOptionPane.showMessageDialog(ProgrammingExercise1111_Chart_Component.this, "Cannot not add anymore items", "Error!", JOptionPane.ERROR_MESSAGE);
                    }
                });
            }
        }
    }

    @Override
    public Dimension getPreferredSize(){
        return new Dimension(PREF_WIDTH, PREF_HEIGHT);
    }

    public void addBar(ProgrammingExercise1111_Item bar){
        items.add(bar);
        repaint();
    }

    public void reset(){
        this.items.clear();
        repaint();
    }
}

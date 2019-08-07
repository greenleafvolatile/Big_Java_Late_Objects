import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EtchedBorder;

/**
 * Write a program that allows the user to specify a circle by typing the radius in a text field and
 * then clicking on the center. Note that you don't need a "Draw" button."
 */
public class Programming_Exercise_11_20 extends JFrame {

    private JTextField radiusField;

    private Programming_Exercise_11_20(){
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        Programming_Exercise_11_20_Component component=new Programming_Exercise_11_20_Component();
        component.addMouseListener(new MouseAdapter(){

            public void mousePressed(MouseEvent event){
                try{

                    component.drawCircle(event.getX(), event.getY(), Integer.parseInt(radiusField.getText()));
                }
                catch(NumberFormatException nfe){
                    JOptionPane.showMessageDialog(Programming_Exercise_11_20.this, "Radius has to be a number and cannot be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        mainPanel.add(component, BorderLayout.CENTER);
        mainPanel.add(constructControlPanel(), BorderLayout.SOUTH);
        setContentPane(mainPanel);
        pack();
    }

    class Programming_Exercise_11_20_Component extends JComponent {

        static final int PREF_WIDTH = 400;
        static final int PREF_HEIGHT = 400;

        private int xPos, yPos, radius;

        Programming_Exercise_11_20_Component() {

        }

        public void paintComponent(Graphics g) {
            final int diameter = radius * 2;
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.drawOval(xPos - radius, yPos - radius, diameter, diameter);
        }
        public Dimension getPreferredSize(){
            return new Dimension(PREF_WIDTH, PREF_HEIGHT);
        }

        void drawCircle(int x, int y, int value){
            xPos=x;
            yPos=y;
            radius=value;
            repaint();
        }
    }

    private JPanel constructControlPanel(){
        JPanel panel=new JPanel();
        panel.setBorder(new EtchedBorder());
        JLabel label=new JLabel("Enter radius");
        radiusField=new JTextField(5);
        panel.add(label);
        panel.add(radiusField);
        return panel;
    }

    private static void createAndShowGUI(){
        JFrame frame=new Programming_Exercise_11_20();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Programming_Exercise_11_20::createAndShowGUI);
    }





}

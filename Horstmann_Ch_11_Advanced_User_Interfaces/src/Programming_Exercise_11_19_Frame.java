import java.util.Enumeration;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;

/**
 * "Write a program that prompts the user to enter the x- and y-positions of a center point and a radius, using text fields.
 * When the user clicks a "Draw" button, draw a circle with that center and radius in a component".
 */

public class Programming_Exercise_11_19_Frame extends JFrame{

    private final Programming_Exercise_11_19_Component component;
    private JTextField xPosField;
    private JTextField yPosField;
    private JTextField radiusField;

    private Programming_Exercise_11_19_Frame(){
        JPanel mainPanel=constructMainPanel();
        setContentPane(mainPanel);
        component=new Programming_Exercise_11_19_Component();
        mainPanel.add(component, BorderLayout.CENTER);
        JPanel controlPanel=constructControlPanel();
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        pack();
        Logger.getGlobal().info(""+controlPanel.getWidth());
        Logger.getGlobal().info("Component: " + component.getWidth());
    }

    private static void setUIFont(FontUIResource f){
        Enumeration keys=UIManager.getDefaults().keys();
        while(keys.hasMoreElements()){
            Object key=keys.nextElement();
            Object value=UIManager.get(key);
            if(value instanceof FontUIResource){
                FontUIResource org = (FontUIResource) value;
                Font font=new Font(f.getFontName(), org.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }

    private JPanel constructMainPanel(){
        JPanel panel=new JPanel();
        panel.setLayout(new BorderLayout());
        return panel;
    }

    private JPanel constructControlPanel(){
        final int NR_OF_COLUMNS=5;

        JPanel controlPanel=new JPanel();
        controlPanel.setBorder(new EtchedBorder());

        JLabel xPosLabel=new JLabel(String.format("Set x-coordinate (<%d): ",component.getPreferredSize().width));
        JLabel yPosLabel=new JLabel(String.format("Set y-coordinate (<%d): ",component.getPreferredSize().height));
        JLabel radiusLabel=new JLabel(String.format("Set radius (<%d): ", component.getPreferredSize().width));

        xPosField=new JTextField(NR_OF_COLUMNS);
        yPosField=new JTextField(NR_OF_COLUMNS);
        radiusField=new JTextField(NR_OF_COLUMNS);

        controlPanel.add(xPosLabel);
        controlPanel.add(xPosField);
        controlPanel.add(yPosLabel);
        controlPanel.add(yPosField);
        controlPanel.add(radiusLabel);
        controlPanel.add(radiusField);
        controlPanel.add(constructDrawButton());
        Logger.getGlobal().info("ControlPanel width: " + controlPanel.getWidth());

        return controlPanel;
    }

    private JButton constructDrawButton(){
        JButton drawButton=new JButton("Draw");
        drawButton.addActionListener(e -> {
            try{
                component.setXPos(Integer.parseInt(xPosField.getText()));
                component.setYPos(Integer.parseInt(yPosField.getText()));
                component.setRadius(Integer.parseInt(radiusField.getText()));
            }
            catch(Exception ex){
                Logger.getGlobal().info("" + ex.getClass().getSimpleName());
                JOptionPane.showMessageDialog(Programming_Exercise_11_19_Frame.this, "Only numbers!", "Error", JOptionPane.ERROR_MESSAGE);
            }
                component.repaint();
                clearTextFields();
            });
        return drawButton;
    }

    private void clearTextFields(){
        xPosField.setText("");
        yPosField.setText("");
        radiusField.setText("");
    }

    private static void createAndShowGUI(){
        final Font FONT=new Font("TimesRoman", Font.BOLD, 20);
        setUIFont(new FontUIResource(FONT));
        JFrame frame=new Programming_Exercise_11_19_Frame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(Programming_Exercise_11_19_Frame::createAndShowGUI);
    }
}

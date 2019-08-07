import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 * "Enhance he font viewer program to allow the user to select different font faces.
 * Research the API documentation to find out how to find the available fonts on the user's system."
 */
public class Programming_Exercise_11_10 extends JFrame {

    private static final int FRAME_WIDTH = 300, FRAME_HEIGHT = 400;

    private JLabel label;
    private JCheckBox italicCheckBox;
    private JCheckBox boldCheckBox;
    private JRadioButton smallButton;
    private JRadioButton mediumButton;
    private JRadioButton largeButton;
    private JComboBox<String> fontFaceCombo;
    private ActionListener listener;


    // Constructs the frame

    public Programming_Exercise_11_10() {

        this.label = new JLabel("Big Java");
        this.add(label, BorderLayout.CENTER);

        // This listener is shared among all components

        this.listener = new ChoiceListener();

        this.createControlPanel();
        this.setLabelFont();
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }

    class ChoiceListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            Programming_Exercise_11_10.this.setLabelFont();
        }
    }

    /**
     * Create the control panel to change the font
     */

    public void createControlPanel() {
        JPanel fontFacePanel=createFontFacePanel();
        JPanel sizeGroupPanel=createSizeGroupPanel();
        JPanel styleGroupPanel=createStyleGroupPanel();

        // line up component panels

        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(3, 1));
        controlPanel.add(fontFacePanel);
        controlPanel.add(sizeGroupPanel);
        controlPanel.add(styleGroupPanel);

        // add panels to content pane

        this.add(controlPanel, BorderLayout.SOUTH);
    }

    public JPanel createFontFacePanel(){

        String[] fonts=GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        this.fontFaceCombo=new JComboBox<>();
        for(String faceName : fonts){
            fontFaceCombo.addItem(faceName);
        }
        this.fontFaceCombo.setEditable(false);
        this.fontFaceCombo.addActionListener(listener);
        JPanel panel=new JPanel();
        panel.add(fontFaceCombo);
        return panel;


    }


    public JPanel createStyleGroupPanel() {
        italicCheckBox = new JCheckBox("Italic");
        italicCheckBox.addActionListener(listener);
        boldCheckBox = new JCheckBox(("Bold"));
        boldCheckBox.addActionListener(listener);

        JPanel panel = new JPanel();
        panel.add(italicCheckBox);
        panel.add(boldCheckBox);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "Style"));

        return panel;
    }

    public JPanel createSizeGroupPanel() {

        smallButton = new JRadioButton("small");
        smallButton.addActionListener(listener);

        mediumButton = new JRadioButton("medium");
        mediumButton.addActionListener(listener);

        largeButton = new JRadioButton("large");
        largeButton.addActionListener(listener);
        largeButton.setSelected(true);

        ButtonGroup group = new ButtonGroup();
        group.add(smallButton);
        group.add(mediumButton);
        group.add(largeButton);

        JPanel panel = new JPanel();
        panel.add(smallButton);
        panel.add(mediumButton);
        panel.add(largeButton);
        panel.setBorder(new TitledBorder(new EtchedBorder(), "size"));

        return panel;
    }

    /**
     * Gets user choice for font name, style and size
     * and sets the font of the text sample
     */

    public void setLabelFont(){

        // Get font name
        String fontFace=(String) fontFaceCombo.getSelectedItem();

        // Get font style

        int style=0;
        if(italicCheckBox.isSelected()){
            style+=Font.ITALIC;
        }
        if(boldCheckBox.isSelected()){
            style+=Font.BOLD;
        }

        // Get font size

        int size=0;

        final int SMALL_SIZE=24;
        final int MEDIUM_SIZE=36;
        final int LARGE_SIZE=48;

        if(smallButton.isSelected()){
            size=SMALL_SIZE;
        }
        else if(mediumButton.isSelected()){
            size=MEDIUM_SIZE;
        }
        else if(largeButton.isSelected()){
            size=LARGE_SIZE;
        }

        // set font of text field

        label.setFont(new Font(fontFace, style, size));
        label.repaint();
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_10();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * "Write an application with three check boxes labeled "Red', "Green", and "Blue" that adds
 * a red, green, or blue component to the background color of a panel in the center of the frame.
 * This application can display a total of eight color combinations."
 */

public class Programming_Exercise_11_4 extends JFrame {


    private JPanel centerPanel, buttonPanel;
    private JCheckBox greenButton, redButton, blueButton;
    private int red, green, blue;


    private Programming_Exercise_11_4() {
        this.red=0;
        this.green=0;
        this.blue=0;
        this.createCenterPanel();
        this.createButtons();
        this.createButtonPanel();
        this.constructPanel();
        this.pack();
    }

    class ColorChanger implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            System.out.print(centerPanel.getBackground());
            Programming_Exercise_11_4.this.setColors();
            if(red==0 && green==0 && blue==0){
                Programming_Exercise_11_4.this.centerPanel.setBackground(new Color(238, 238, 238));
            }
            else{
                Programming_Exercise_11_4.this.centerPanel.setBackground(new Color(Programming_Exercise_11_4.this.red, Programming_Exercise_11_4.this.green, Programming_Exercise_11_4.this.blue));
            }
        }
    }

    class CustomPanel extends JPanel{


        private final int pref_width;
        private final int pref_height;

        CustomPanel(int width, int height){
            this.pref_width=width;
            this.pref_height=height;
        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(pref_width, pref_height);
        }
    }

    class CustomButton extends JCheckBox{


        static final int PREF_WIDTH=100;
        static final int PREF_HEIGHT=40;

        CustomButton(String text){
            super(text);
            this.addActionListener(new ColorChanger());
            this.setHorizontalAlignment(SwingConstants.CENTER);

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(PREF_WIDTH, PREF_HEIGHT);
        }

    }

    private void createCenterPanel() {
        final int PREF_WIDTH=100, PREF_HEIGHT=100, BORDER_THICKNESS=5;
        final Color BORDER_COLOR=Color.BLACK;

        this.centerPanel = new JPanel();
        this.centerPanel.setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));
        this.centerPanel.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
    }

    private void createButtons(){

        redButton=new CustomButton("Red");
        greenButton=new CustomButton("Green");
        blueButton=new CustomButton("Blue");

    }

    private void createButtonPanel() {

        final int NR_OF_ROWS = 2, NR_OF_COLUMNS = 1, PREF_WIDTH=400, PREF_HEIGHT=150, BORDER_THICKNESS=2;
        final Color BORDER_COLOR=Color.BLACK;

        this.buttonPanel = new CustomPanel(PREF_WIDTH, PREF_HEIGHT);
        this.buttonPanel.setLayout(new GridLayout(NR_OF_ROWS, NR_OF_COLUMNS));

        JPanel[][] panelArray = new JPanel[NR_OF_ROWS][NR_OF_COLUMNS];
        for (int row = 0; row < NR_OF_ROWS; row++) {
            for (int column = 0; column < NR_OF_COLUMNS; column++) {
                panelArray[row][column] = new JPanel();
                buttonPanel.add(panelArray[row][column]);
            }
        }

        panelArray[1][0].setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
        panelArray[1][0].add(redButton);
        panelArray[1][0].add(greenButton);
        panelArray[1][0].add(blueButton);


    }

    private void constructPanel() {

        final int SIDEPANEL_WIDTH=150, SIDEPANEL_HEIGHT=100, TOPPANEL_WIDTH=400, TOPPANEL_HEIGHT=150;
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(new CustomPanel(SIDEPANEL_WIDTH, SIDEPANEL_HEIGHT), BorderLayout.EAST);
        this.add(new CustomPanel(SIDEPANEL_WIDTH, SIDEPANEL_HEIGHT), BorderLayout.WEST);
        this.add(new CustomPanel(TOPPANEL_WIDTH, TOPPANEL_HEIGHT), BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setColors(){
        red=redButton.isSelected()?255:0;
        green=greenButton.isSelected()?255:0;
        blue=blueButton.isSelected()?255:0;
    }

    public static void main(String[] args) {

        JFrame frame = new Programming_Exercise_11_4();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
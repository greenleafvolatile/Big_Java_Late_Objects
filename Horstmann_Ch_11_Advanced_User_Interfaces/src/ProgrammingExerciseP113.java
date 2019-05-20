import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

public class ProgrammingExerciseP113 extends JFrame {


    private JPanel centerPanel, buttonPanel;
    private JRadioButton greenButton, redButton, blueButton;


    private ProgrammingExerciseP113() {
        this.createCenterPanel();
        this.createButtons();
        this.createButtonPanel();
        this.constructPanel();
        this.pack();
    }

    class ColorChanger implements ActionListener {

        private final Color color;

        ColorChanger(Color color) {
            this.color = color;
        }

        public void actionPerformed(ActionEvent event) {
            ProgrammingExerciseP113.this.centerPanel.setBackground(color);
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

    class CustomButton extends JRadioButton{


        static final int PREF_WIDTH=100;
        static final int PREF_HEIGHT=40;

        CustomButton(String text, Color color){
            super(text);
            this.addActionListener(new ColorChanger(color));
            this.setHorizontalAlignment(SwingConstants.CENTER);

        }

        @Override
        public Dimension getPreferredSize(){
            return new Dimension(PREF_WIDTH, PREF_HEIGHT);
        }
    }

    private void createCenterPanel() {
        final Color BORDER_COLOR=Color.BLACK;
        final int BORDER_THICKNESS=5, PREF_WIDTH=100, PREF_HEIGHT=100;

        this.centerPanel = new JPanel();
        this.centerPanel.setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));
        this.centerPanel.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
        this.centerPanel.setBackground(Color.RED);
    }


    private void createButtons(){

        redButton=new CustomButton("Red", Color.RED);
        greenButton=new CustomButton("Green", Color.GREEN);
        blueButton=new CustomButton("Blue", Color.BLUE);

        ButtonGroup group=new ButtonGroup();
        group.add(redButton);
        group.add(greenButton);
        group.add(blueButton);

        redButton.setSelected(true);


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

    public static void main(String[] args) {

        JFrame frame = new ProgrammingExerciseP113();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
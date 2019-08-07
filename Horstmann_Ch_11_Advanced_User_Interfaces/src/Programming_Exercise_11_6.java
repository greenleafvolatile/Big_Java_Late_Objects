import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * "Write an application with a Color menu and menu items labeled "Red", "Green", and "Blue"
 * that change the background color of a panel in the center of the frame to red, green, or blue."
 */
public class Programming_Exercise_11_6 extends JFrame {


    private JPanel centerPanel;
    private JMenuBar menuBar;


    private Programming_Exercise_11_6() {
        this.createMenuBar();
        this.createCenterPanel();
        this.constructFrame();
    }

    class ColorChanger implements ActionListener {

        private final Color color;

        ColorChanger(Color color){
            this.color=color;
        }

        public void actionPerformed(ActionEvent event) {
            Programming_Exercise_11_6.this.centerPanel.setBackground(color);
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

    private void createMenuBar(){

        this.menuBar=new JMenuBar();

        // construct colors menu
        JMenu colors=new JMenu("Colors");

        // construct a MenuItem object for each color
        JMenuItem red=new JMenuItem("Red");
        JMenuItem green=new JMenuItem("Green");
        JMenuItem blue=new JMenuItem("Blue");

        // add an ActionListener to each MenuItem object
        red.addActionListener(new ColorChanger(Color.RED));
        green.addActionListener(new ColorChanger(Color.GREEN));
        blue.addActionListener(new ColorChanger(Color.BLUE));

        // add items to the menu
        colors.add(red);
        colors.add(green);
        colors.add(blue);

        // add menu to the menu bar
        this.menuBar.add(colors);
    }

    private void createCenterPanel() {
        final int PREF_WIDTH=100, PREF_HEIGHT=100, BORDER_THICKNESS=5;
        final Color BORDER_COLOR=Color.BLACK;

        this.centerPanel = new JPanel();
        this.centerPanel.setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));
        this.centerPanel.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
    }

    private void constructFrame() {

        final int SIDEPANEL_WIDTH=150, SIDEPANEL_HEIGHT=100, TOPPANEL_WIDTH=400, TOPPANEL_HEIGHT=150;
        this.add(centerPanel, BorderLayout.CENTER);
        this.add(new CustomPanel(SIDEPANEL_WIDTH, SIDEPANEL_HEIGHT), BorderLayout.EAST);
        this.add(new CustomPanel(SIDEPANEL_WIDTH, SIDEPANEL_HEIGHT), BorderLayout.WEST);
        this.add(new CustomPanel(TOPPANEL_WIDTH, TOPPANEL_HEIGHT), BorderLayout.SOUTH);
        this.add(new CustomPanel(TOPPANEL_WIDTH, TOPPANEL_HEIGHT), BorderLayout.NORTH);
        this.setJMenuBar(menuBar);
        this.pack();
    }

    public static void main(String[] args) {

        JFrame frame = new Programming_Exercise_11_6();

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
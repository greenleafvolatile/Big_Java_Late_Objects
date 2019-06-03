import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

/**
 * "Write a program that lets users design charts such as the following:
 * ----------------------------------
 * |Golden Gate                     |
 * ----------------------------------
 * ------------------------
 * |Brooklyn              |
 * ------------------------
 * ----------------------------
 * |Delaware memorial         |
 * ----------------------------
 * -------------------------------
 * |Mackinac                     |
 * -------------------------------
 *
 * Use appropriate components to ask for the length, label, and color, then apply them when the user clicks an "Add item" button"."
 */

public class Programming_Exercise_11_11_Main extends JFrame {

    private final JPanel contPanel;
    private JLabel nameLabel, lengthLabel;
    private JButton colorButton, drawButton, resetButton;
    private Color color;
    private String name;
    private int length;
    private JTextField nameField, lengthField;
    private final Programming_Exercise_11_11_Chart_Component chartComponent;

    private Programming_Exercise_11_11_Main(){
        final Color BORDER_COLOR = Color.BLACK;
        final int BORDER_THICKNESS = 2;
        contPanel=new JPanel();
        this.setContentPane(contPanel);
        contPanel.setLayout(new BorderLayout());
        contPanel.setBorder(new TitledBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS),"Chart Designer Version 1.01", TitledBorder.CENTER, TitledBorder.ABOVE_TOP));
        chartComponent=new Programming_Exercise_11_11_Chart_Component();
        contPanel.add(chartComponent, BorderLayout.CENTER);
        this.createLabels();
        this.createTextFields();
        this.createButtons();
        this.createControlPanel();
        this.pack();
    }

    private void createLabels(){
        lengthLabel=new JLabel(String.format("Item length: (0<n>%d)", chartComponent.getPreferredSize().width));
        lengthLabel.setHorizontalAlignment(SwingConstants.CENTER);
        nameLabel=new JLabel("Item title: ");
        nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void createTextFields(){
        lengthField=new JTextField();
        nameField=new JTextField();
    }

    private void createButtons() {
        colorButton = new JButton("Select item color");
        colorButton.addActionListener(event -> Programming_Exercise_11_11_Main.this.color = JColorChooser.showDialog(Programming_Exercise_11_11_Main.this.contPanel, "Select a color", null));

        drawButton = new JButton("Add item");
        drawButton.addActionListener(event -> {
            try {
                name = Programming_Exercise_11_11_Main.this.nameField.getText();
                if (name.equals("")) {
                    throw new Exception("Please enter a name!");
                }

                length = Integer.parseInt(Programming_Exercise_11_11_Main.this.lengthField.getText().length() == 0 ? "0" : Programming_Exercise_11_11_Main.this.lengthField.getText());
                if (length == 0 || length<0 || length> Programming_Exercise_11_11_Main.this.chartComponent.getPreferredSize().width) {
                    throw new Exception("Please enter a valid bar length!");
                }
                Programming_Exercise_11_11_Item item = new Programming_Exercise_11_11_Item(name, length, Programming_Exercise_11_11_Main.this.color);
                Programming_Exercise_11_11_Main.this.chartComponent.addBar(item);
            }
            catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    JOptionPane.showMessageDialog(Programming_Exercise_11_11_Main.this, "Length must be a number", "Error!", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(Programming_Exercise_11_11_Main.this, e.getMessage(), "Error!", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> Programming_Exercise_11_11_Main.this.chartComponent.reset());
    }

    private void createControlPanel(){
        final int CP_ROWS=1, CP_COLUMNS=3, LP_ROWS=2, LP_COLUMNS=1, RP_ROWs=3, RP_COLUMNS=1, MP_ROWS=2, MP_COLUMNS=1, BORDER_THICKNESS=1;
        JPanel controlPanel=new JPanel();
        controlPanel.setLayout(new GridLayout(CP_ROWS, CP_COLUMNS));
        controlPanel.setBorder(new LineBorder(Color.BLACK, BORDER_THICKNESS));

        JPanel leftPanel=new JPanel(new GridLayout(LP_ROWS, LP_COLUMNS));
        JPanel rightPanel=new JPanel(new GridLayout(RP_ROWs, RP_COLUMNS));
        JPanel middlePanel=new JPanel(new GridLayout(MP_ROWS, MP_COLUMNS));

        leftPanel.add(nameLabel);
        leftPanel.add(lengthLabel);

        middlePanel.add(nameField);
        middlePanel.add(lengthField);

        rightPanel.add(colorButton);
        rightPanel.add(drawButton);
        rightPanel.add(resetButton);

        controlPanel.add(leftPanel);
        controlPanel.add(middlePanel);
        controlPanel.add(rightPanel);
        this.add(controlPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame frame = new Programming_Exercise_11_11_Main();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

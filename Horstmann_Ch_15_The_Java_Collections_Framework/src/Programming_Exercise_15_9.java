import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Programming_Exercise_15_9 extends JFrame {


    private JTable table;
    private final Map<String, String> namesGradesMap;
    private DefaultTableModel model;

    public Programming_Exercise_15_9(Map<String, String> aNamesGradesMap){
        namesGradesMap=aNamesGradesMap;
        setContentPane(new JPanel(new BorderLayout()));
        JScrollPane pane=new JScrollPane(initTable());
        //pane.setPreferredSize(new Dimension(table.getPreferredSize().width,  table.getRowHeight() * table.getRowCount() + table.getTableHeader().getPreferredSize().height));
        add(pane, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.WEST);
        pack();

    }

    private JTable initTable(){

        table=new JTable(toTableModel(namesGradesMap));
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        return table;
    }

    private DefaultTableModel toTableModel(Map<String, String> grades){

        String[] columnHeaders={"Name: ", "Grade: "};
        String[][] data=new String[grades.size()][];
        int i=0;
        for(Map.Entry<String, String> entry : grades.entrySet()){
            data[i++]=new String[]{entry.getKey(), entry.getValue()};
        }
        model=new DefaultTableModel(data, columnHeaders);

        return model;
    }

    private JPanel createButtonPanel(){

        class AddButtonListener implements ActionListener {

            JTextField nameField, gradeField;

            public void actionPerformed(ActionEvent event) {

                int i=JOptionPane.showConfirmDialog(Programming_Exercise_15_9.this, createPanel(), "Add grade", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                if(i==JOptionPane.OK_OPTION){

                    String name=nameField.getText();
                    String grade=gradeField.getText();
                    model.addRow(new Object[]{name,grade});
                }
            }

            private JPanel createPanel(){

                JPanel panel=new JPanel(new BorderLayout());

                JPanel labelsPanel=new JPanel(new GridLayout(2, 1, 5, 5));
                JLabel nameLabel=new JLabel("Name:");
                JLabel gradeLabel=new JLabel("Grade:");
                labelsPanel.add(nameLabel);
                labelsPanel.add(gradeLabel);

                JPanel textFieldsPanel=new JPanel(new GridLayout(2, 1, 5, 5));
                nameField=new JTextField();
                nameField.addAncestorListener(new AncestorListener() {
                    @Override
                    public void ancestorAdded(AncestorEvent ancestorEvent) {
                        SwingUtilities.invokeLater(new Runnable(){
                            public void run(){
                                nameField.requestFocusInWindow();
                            }
                        });
                        nameField.removeAncestorListener(this);
                    }

                    @Override
                    public void ancestorRemoved(AncestorEvent ancestorEvent) {

                    }

                    @Override
                    public void ancestorMoved(AncestorEvent ancestorEvent) {

                    }

                });
                gradeField=new JTextField();
                textFieldsPanel.add(nameField);
                textFieldsPanel.add(gradeField);


                panel.add(labelsPanel, BorderLayout.WEST);
                panel.add(textFieldsPanel, BorderLayout.CENTER);

                return panel;
            }



        }
        JPanel buttonPanel=new JPanel();


        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10 ));

        JPanel west=new JPanel(new GridBagLayout());
        GridBagConstraints gbc=new GridBagConstraints();

        //gbc.gridy=0;
        //gbc.fill=GridBagConstraints.VERTICAL;
        gbc.anchor=GridBagConstraints.NORTH;

        gbc.weighty=0.5;

        JButton removeButton=new JButton("Remove");
        buttonPanel.add(removeButton);


        JButton addButton=new JButton("Add");
        addButton.addActionListener(new AddButtonListener());
        buttonPanel.add(addButton);

        JButton modifyButton=new JButton("Modify");
        buttonPanel.add(modifyButton);

        west.add(buttonPanel, gbc);
        return west;

    }

    public static void main(String[] args){
        Map<String, String> map=new HashMap<>();
        map.put("Jane", "A");
        map.put("John", "B+");
        map.put("Dave", "C-");
        map.put("Laura", "F");
        map.put("Max", "C");
        Programming_Exercise_15_9 frame=new Programming_Exercise_15_9(map);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}

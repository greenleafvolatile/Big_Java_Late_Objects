import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Programming_Exercise_15_9 extends JFrame {


    public Programming_Exercise_15_9(Map<String, String> grades){
        JTable table=new JTable(toTableModel(grades));
        //table.setPreferredScrollableViewportSize(table.getPreferredSize());
        setContentPane(new JPanel(new BorderLayout()));
        JScrollPane pane=new JScrollPane(table);
        //pane.setPreferredSize(new Dimension(table.getPreferredSize().width,  table.getRowHeight() * table.getRowCount() + table.getTableHeader().getPreferredSize().height));
        add(pane, BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.WEST);
        pack();

    }

    private DefaultTableModel toTableModel(Map<String, String> grades){

        String[] columnHeaders={"Name: ", "Grade: "};
        String[][] data=new String[grades.size()][];
        int i=0;
        for(Map.Entry<String, String> entry : grades.entrySet()){
            data[i++]=new String[]{entry.getKey(), entry.getValue()};
        }
        return new DefaultTableModel(data, columnHeaders);
    }

    private JPanel createButtonPanel(){

        JPanel buttonPanel=new JPanel();


        buttonPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
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

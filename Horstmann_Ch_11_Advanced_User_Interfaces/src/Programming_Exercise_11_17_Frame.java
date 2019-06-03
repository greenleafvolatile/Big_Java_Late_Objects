import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Programming_Exercise_11_17_Frame extends JFrame {


    private Programming_Exercise_11_17_Component component;
    private int fontSize, fontStyle;
    private String faceName;
    private Font font;

    public Programming_Exercise_11_17_Frame(){
        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);
        contPanel.setLayout(new BorderLayout());
        contPanel.setBorder(new LineBorder(Color.BLACK, 2));

        component=new Programming_Exercise_11_17_Component("Test", new Font("Serif", Font.BOLD, 25));
        contPanel.add(component, BorderLayout.CENTER);

        JMenuBar menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createFontMenu());


        this.pack();

        final int delay=50;
        Timer t=new Timer(delay, new TimerListener());
        t.start();
    }

    public JMenu createFileMenu(){

        JMenu fileMenu=new JMenu("File");
        JMenuItem exitItem=new JMenuItem("Exit");
        exitItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
                System.exit(0);
            }
        });
        fileMenu.add(exitItem);
        return fileMenu;
    }

    public JMenu createFontMenu(){

        JMenu fontMenu=new JMenu("Font");
        fontMenu.add(createStyleMenu());
        //fontMenu.add(createSizeMenu());
        //fontMenu.add(createFaceMenu());
        return fontMenu;
    }

    public JMenu createStyleMenu(){

        JMenu styleMenu=new JMenu("Style");
        styleMenu.add(createStyleItem("Bold", Font.BOLD));
        styleMenu.add(createStyleItem("Italic", Font.ITALIC));
        styleMenu.add(createStyleItem("Plain", Font.PLAIN));
        return styleMenu;

    }

    public JMenuItem createStyleItem(final String name, final int style){

        class StyleListener implements ActionListener{

            public void actionPerformed(ActionEvent event){
                Programming_Exercise_11_17_Frame.this.fontStyle=style;
                Programming_Exercise_11_17_Frame.this.setFont();
            }
        }
        JMenuItem styleItem=new JMenuItem(name);
        return styleItem;

    }

    public void setFont(){
        this.font=new Font(faceName, fontStyle, fontSize);
    }

    class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent event){
            component.moveMessage();

        }
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_17_Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

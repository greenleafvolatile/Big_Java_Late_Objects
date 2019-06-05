import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Programming_Exercise_11_17_Frame extends JFrame {


    private Programming_Exercise_11_17_Component component;
    private int fontSize, fontStyle, messageHeight;
    private String fontFamily, message;
    JList systemFonts;
    private Font font;

    public Programming_Exercise_11_17_Frame(){
        this.message="Test";
        this.fontStyle=Font.PLAIN;
        this.fontSize=12;
        this.fontFamily="TimesRoman";
        this.font=new Font(fontFamily, fontStyle, fontSize);
        JPanel contPanel=new JPanel();
        this.setContentPane(contPanel);
        contPanel.setLayout(new BorderLayout());
        contPanel.setBorder(new LineBorder(Color.BLACK, 2));

        component=new Programming_Exercise_11_17_Component(message);
        component.setFont(font);
        contPanel.add(component, BorderLayout.CENTER);

        JMenuBar menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createMessageMenu());


        this.pack();

        final int delay=25;
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

    public JMenu createMessageMenu(){

        JMenu messageMenu=new JMenu("Message");
        messageMenu.add(createFontMenu());
        return messageMenu;
    }

    public JMenu createFontMenu(){

        JMenu fontMenu=new JMenu("Message font");
        fontMenu.add(createStyleMenu());
        fontMenu.add(createSizeMenu());
        fontMenu.add(createFontFamilyMenu());
        return fontMenu;
    }

    public JMenu createFontFamilyMenu(){


        class FontFamilyListener extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {
                Programming_Exercise_11_17_Frame.this.fontFamily = (String) Programming_Exercise_11_17_Frame.this.systemFonts.getSelectedValue();
                Programming_Exercise_11_17_Frame.this.setFont();
            }
        }


        JMenu fontFamilyMenu=new JMenu("Font Family");
        systemFonts=new JList(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        systemFonts.addMouseListener(new FontFamilyListener());
        fontFamilyMenu.add(new JScrollPane(systemFonts));
        return fontFamilyMenu;
    }


    public JMenu createSizeMenu(){

        JMenu sizeMenu=new JMenu("Size");
        sizeMenu.add(createSizeItem("Bigger", 1));
        sizeMenu.add(createSizeItem("Smaller", -1));
        return sizeMenu;
    }

    public JMenuItem createSizeItem(final String size, final int increment){

        class SizeListener implements ActionListener{

            public void actionPerformed(ActionEvent event){
               Programming_Exercise_11_17_Frame.this.fontSize += increment;
               Programming_Exercise_11_17_Frame.this.setFont();
            }
        }
        JMenuItem sizeItem=new JMenuItem(size);
        sizeItem.addActionListener(new SizeListener());
        return sizeItem;
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
        styleItem.addActionListener(new StyleListener());
        return styleItem;

    }

    public void setFont(){
        this.font=new Font(fontFamily, fontStyle, fontSize);
        this.component.setFont(font);

    }

    class TimerListener implements ActionListener {

        public void actionPerformed(ActionEvent event){
            if(component.getYpos()==component.getPreferredSize().height+component.getMessageHeight() && component.getXpos()>=component.getPreferredSize().width){
                component.setYpos(0);
                component.setXpos(component.getPreferredSize().width+component.getMessageWidth());
                component.setNewDirection("left", "down");
            }
            if(component.getYpos()==component.getPreferredSize().height+component.getMessageHeight() && component.getXpos()==0-component.getMessageWidth()){
                component.setXpos(0);
                component.setYpos(0);
                component.setNewDirection("right", "down");
            }
            component.moveMessage();

        }
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_17_Frame();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

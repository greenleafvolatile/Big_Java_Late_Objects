import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Rectangle2D;
import java.util.logging.Logger;

public class Programming_Exercise_11_17_Frame extends JFrame {


    private Programming_Exercise_11_17_Component component;
    private int fontSize, fontStyle;
    private String fontFamily, message;
    JList systemFonts;
    private Font font;
    private JPanel contPanel;
    private Color backgroundColor, foregroundColor;

    public Programming_Exercise_11_17_Frame(){
        this.foregroundColor=Color.BLACK;
        this.backgroundColor=Color.WHITE;
        this.message="Test";
        this.fontStyle=Font.PLAIN;
        this.fontSize=12;
        this.fontFamily="TimesRoman";
        this.font=new Font(fontFamily, fontStyle, fontSize);
        contPanel=new JPanel();
        this.setContentPane(contPanel);
        contPanel.setLayout(new BorderLayout());
        contPanel.setBorder(new LineBorder(Color.BLACK, 2));
        contPanel.setBackground(backgroundColor);
        contPanel.setForeground(foregroundColor);

        component=new Programming_Exercise_11_17_Component(message, font);

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

        messageMenu.add(createForegroundColorItem());
        messageMenu.add(createChangeBackgroundColorItem());
        messageMenu.add(createSetMessageItem());
        messageMenu.add(createSetMessageFontMenu());
        messageMenu.add(createChangeDirectionItem());
        return messageMenu;
    }

    private JMenuItem createForegroundColorItem(){
        JMenuItem foregroundColorItem=new JMenuItem("Set foreground color");
        foregroundColorItem.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent event) {
                final JColorChooser colorChooser = new JColorChooser(Color.BLACK);

                ActionListener cancelListener = new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        Programming_Exercise_11_17_Frame.this.contPanel.setForeground(Programming_Exercise_11_17_Frame.this.foregroundColor);
                    }
                };

                ActionListener okListener = new ActionListener() {

                    public void actionPerformed(ActionEvent event) {
                        Programming_Exercise_11_17_Frame.this.foregroundColor = colorChooser.getColor();
                        Programming_Exercise_11_17_Frame.this.contPanel.setForeground(Programming_Exercise_11_17_Frame.this.foregroundColor);
                    }
                };

                final JDialog colorDialog = JColorChooser.createDialog(Programming_Exercise_11_17_Frame.this.component, "Choose a background color", true, colorChooser, okListener, cancelListener);
                colorDialog.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        Programming_Exercise_11_17_Frame.this.contPanel.setForeground(Programming_Exercise_11_17_Frame.this.foregroundColor);
                    }
                });
                colorDialog.setVisible(true);
            }

        });
        return foregroundColorItem;
    }

    private JMenuItem createChangeBackgroundColorItem(){
        JMenuItem backgroundItem=new JMenuItem("Set background color");
        backgroundItem.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
                final JColorChooser colorChooser=new JColorChooser(Color.BLACK);

                ActionListener cancelListener=new ActionListener(){

                    public void actionPerformed(ActionEvent event){
                        Programming_Exercise_11_17_Frame.this.contPanel.setBackground(Programming_Exercise_11_17_Frame.this.backgroundColor);
                    }
                };

                ActionListener okListener=new ActionListener(){

                    public void actionPerformed(ActionEvent event){
                        Programming_Exercise_11_17_Frame.this.backgroundColor=colorChooser.getColor();
                        Programming_Exercise_11_17_Frame.this.contPanel.setBackground(Programming_Exercise_11_17_Frame.this.backgroundColor);
                    }
                };

                final JDialog colorDialog=JColorChooser.createDialog(Programming_Exercise_11_17_Frame.this.component, "Choose a background color", true, colorChooser, okListener, cancelListener);
                colorDialog.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        Programming_Exercise_11_17_Frame.this.contPanel.setBackground(Programming_Exercise_11_17_Frame.this.backgroundColor);
                    }
                });
                colorDialog.setVisible(true);
            }
        });
        return backgroundItem;
    }
    private JMenuItem createChangeDirectionItem(){
        JMenuItem changeDirection=new JMenuItem("Change message direction");
        changeDirection.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
                if (component.getDirection().getHorizontalDirection().equals("right") && component.getDirection().getVerticalDirection().equals("up")) {
                    component.setNewDirection("left", "down");
                }
                else if (component.getDirection().getHorizontalDirection().equals("left") && component.getDirection().getVerticalDirection().equals("up")) {
                    component.setNewDirection("right", "down");
                }
                else if(component.getDirection().getHorizontalDirection().equals("right") && component.getDirection().getVerticalDirection().equals("down")){
                    component.setNewDirection("left", "up");
                }
                else if(component.getDirection().getHorizontalDirection().equals("left") && component.getDirection().getVerticalDirection().equals("down")){
                    component.setNewDirection("right", "up");
                }
            }
        });
        return changeDirection;
    }

    private JMenuItem createSetMessageItem(){
        JMenuItem setMessage=new JMenuItem("Set message");
        setMessage.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent event){
                Programming_Exercise_11_17_Frame.this.message=JOptionPane.showInputDialog(Programming_Exercise_11_17_Frame.this.component, "Please input a new message: ", "Set message", JOptionPane.OK_OPTION);
                if(Programming_Exercise_11_17_Frame.this.message==null) {
                    Programming_Exercise_11_17_Frame.this.component.setMessage(Programming_Exercise_11_17_Frame.this.component.getMessage());
                }
                else if(Programming_Exercise_11_17_Frame.this.message.length()==0){
                    JOptionPane.showMessageDialog(Programming_Exercise_11_17_Frame.this.component, "Message field can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                }
                Programming_Exercise_11_17_Frame.this.component.setMessage(Programming_Exercise_11_17_Frame.this.message);
            }
        });
        return setMessage;

    }

    public JMenu createSetMessageFontMenu(){

        JMenu fontMenu=new JMenu("Set message font");
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

        JMenu sizeMenu=new JMenu("Font Size");
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

        JMenu styleMenu=new JMenu("Font Style");
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
            if(component.getYpos()>=component.getPreferredSize().height + component.getMessageHeight() && component.getDirection().getHorizontalDirection().equals("right") && component.getDirection().getVerticalDirection().equals("down")){
                //Set message to start from top right corner.
                component.setYpos(0);
                component.setXpos(component.getPreferredSize().width);
                component.setNewDirection("left", "down");
            }
            else if(component.getYpos()>=component.getPreferredSize().height+component.getMessageHeight() && component.getDirection().getHorizontalDirection().equals("left") && component.getDirection().getVerticalDirection().equals("down")){
                // Set message to start from to left corner
                component.setXpos(0-(int) component.getMessageWidth());
                component.setYpos(0);
                component.setNewDirection("right", "down");
            }
            else if(component.getYpos()<=0 && component.getDirection().getHorizontalDirection().equals("left") && component.getDirection().getVerticalDirection().equals("up")){
                component.setXpos(0-(int) component.getMessageWidth());
                component.setYpos(component.getPreferredSize().height+(int) component.getMessageHeight());
                component.setNewDirection("right", "up");
            }
            else if(component.getYpos()==0 && component.getDirection().getHorizontalDirection().equals("right") && component.getDirection().getVerticalDirection().equals("up")){
                component.setXpos(component.getPreferredSize().width);
                component.setYpos(component.getPreferredSize().height+(int) component.getMessageHeight());
                component.setNewDirection("left", "up");
            }
            component.moveMessage();

        }
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_17_Frame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


}

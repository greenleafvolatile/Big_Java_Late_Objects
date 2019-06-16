import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Programming_Exercise_11_17_Frame extends JFrame {



    private final static GraphicsDevice device=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    private final static int DEFAULT_FONT_STYLE=Font.PLAIN;
    private final static int DEFAULT_FONT_SIZE=12;
    private final static int BORDER_THICKNESS=2;
    private final static String DEFAULT_FONT_FAMILY="TimesRoman";
    private final static String DEFAULT_MESSAGE="Made by Daan Pol";
    private final static Color DEFAULT_FG_COLOR=Color.BLACK;
    private final static Color DEFAULT_BG_COLOR=Color.WHITE;
    private final static Color BORDER_COLOR=Color.BLACK;
    private final static int GAP=10;

    private final Programming_Exercise_11_17_Component component;
    private final Timer timer;
    private final JPanel mainPanel;

    private int fontSize;
    private int fontStyle;
    private final int delay;
    private String fontFamily;
    private String message;
    private JList<String> systemFonts;
    private Font font;
    private Color backgroundColor;
    private Color foregroundColor;

    private Programming_Exercise_11_17_Frame(){
        foregroundColor=DEFAULT_FG_COLOR;
        backgroundColor=DEFAULT_BG_COLOR;
        message=DEFAULT_MESSAGE;
        fontStyle=DEFAULT_FONT_STYLE;
        fontSize=DEFAULT_FONT_SIZE;
        fontFamily=DEFAULT_FONT_FAMILY;
        font=new Font(fontFamily, fontStyle, fontSize);

        // Set up the main panel.
        mainPanel=new JPanel();
        setContentPane(mainPanel); // Set a panel as the content pane so that it can have a border.
        mainPanel.setLayout(new BorderLayout());
        mainPanel.setBorder(new LineBorder(BORDER_COLOR, BORDER_THICKNESS));
        mainPanel.setBackground(backgroundColor);
        mainPanel.setForeground(foregroundColor);

        // Add the component on which the 'screensaver' text is actually drawn to the content pane.
        component=new Programming_Exercise_11_17_Component(message, font);
        mainPanel.add(component, BorderLayout.CENTER);

        createMenuBar();
        pack();

        delay=10;
        timer=new Timer(delay, new TimerListener());
        timer.start();

    }

    /**
     * This method creates a menu bar with two file menu's, "File" and "Message", and adds it to the content pane.
     */
    private void createMenuBar(){
        JMenuBar menuBar=new JMenuBar();
        this.setJMenuBar(menuBar);
        menuBar.add(createFileMenu());
        menuBar.add(createMessageMenu());
        menuBar.add(createBackgroundMenu());
    }

    /**
     * This method creates an "Background" menu with an item that allows the user to set the background color.
     * @return a JMenu object.
     */
    private JMenu createBackgroundMenu() {
        JMenu backgroundMenu = new JMenu("Background");
        JMenuItem backgroundColorItem = new JMenuItem("Set background color");

        backgroundColorItem.addActionListener(changeBFColorEvent -> {

            final Color INITIAL_COLOR = Color.BLACK;
            final JColorChooser colorChooser = new JColorChooser(INITIAL_COLOR);

            ActionListener cancelListener = cancelEvent -> mainPanel.setBackground(backgroundColor);

            ActionListener okListener = okEvent -> {

                backgroundColor = colorChooser.getColor();
                mainPanel.setBackground(backgroundColor);
            };

            final JDialog colorDialog = JColorChooser.createDialog(component, "Choose a background color", true, colorChooser, okListener, cancelListener);
            colorDialog.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosed(WindowEvent e) {
                    super.windowClosed(e);
                    mainPanel.setBackground(backgroundColor);
                }
            });
            colorDialog.setVisible(true);
        });
        backgroundMenu.add(backgroundColorItem);
        return backgroundMenu;
    }

    /**
     * This method creates the "File" menu.
     * @return a JMenu object.
     */
    private JMenu createFileMenu(){

        JMenu fileMenu=new JMenu("File");
        fileMenu.add(createExitItem());
        return fileMenu;
    }

    private JMenuItem createExitItem(){

        JMenuItem exitItem=new JMenuItem("Exit");
        exitItem.addActionListener(event -> System.exit(0));
        return exitItem;
    }

    /**
     * This method creates the "Message" menu, with options to change the color of the message, the color of the background,
     * the message font (font size, font style, font family), the speed at which the message moves, the direction in which the message moves,
     * and the message itself. Not all font families work as they should (foreign language fonts for instance). I did not fix this because I'd already
     * spent more than the time I'd allotted for this project.
     * @return a JMenu object.
     */
    private JMenu createMessageMenu(){

        JMenu messageMenu=new JMenu("Message");

        messageMenu.add(createMessageColorItem());
        messageMenu.add(createSetMessageItem());
        messageMenu.add(createSetMessageFontMenu());
        messageMenu.add(createSetMessageSpeedItem());
        messageMenu.add(createChangeDirectionItem());

        return messageMenu;
    }

    /**
     * This method creates an entry in the "Message" menu that allows the user to set the speed of the message. I elected to do this with a JSlider to show that I can work with JSliders.
     * @return a JMenuItem with a ChangeListener object.
     */
    private JMenuItem createSetMessageSpeedItem(){

        final int SLIDER_MIN_VALUE=0;
        final int SLIDER_MAX_VALUE=100;
        JMenuItem speedItem=new JMenuItem("Set message speed");
        speedItem.addActionListener(event -> {
            Programming_Exercise_11_17_Vertical_Slider speedSlider=new Programming_Exercise_11_17_Vertical_Slider(SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, delay);
            speedSlider.getSlider().setInverted(true);
            speedSlider.setLocation(this.getX() + this.getWidth() + GAP, this.getY());
            speedSlider.setVisible(true);
            speedSlider.getSlider().addChangeListener(e-> setSpeed(speedSlider.getSlider().getValue()));
        });
        return speedItem;
    }

    /**
     * This method creates an entry in the "Message" menu that allows the user to set the color of the message.
     * @return a JMenuItem with an ActionListener object.
     */
    private JMenuItem createMessageColorItem(){
        JMenuItem foregroundColorItem=new JMenuItem("Set message color");
        foregroundColorItem.addActionListener(changeFGColorEvent -> {
            final Color INITIAL_COLOR=Color.BLACK;
            final JColorChooser colorChooser = new JColorChooser(INITIAL_COLOR);

                ActionListener cancelListener = cancelEvent -> mainPanel.setForeground(foregroundColor);

                ActionListener okListener = okEvent -> {

                    foregroundColor = colorChooser.getColor();
                    mainPanel.setForeground(foregroundColor);
                };

                final JDialog colorDialog = JColorChooser.createDialog(component, "Choose a message color", true, colorChooser, okListener, cancelListener);
                colorDialog.addWindowListener(new WindowAdapter() {

                    @Override
                    public void windowClosed(WindowEvent e) {
                        super.windowClosed(e);
                        mainPanel.setForeground(foregroundColor);
                    }
                });
                colorDialog.setVisible(true);
            });
        return foregroundColorItem;
    }

    /**
     * This method adds an entry to the "Message" menu that allows the user to change the direction of the message.
     * @return a JMenItem with an ActionListener object.
     */
    private JMenuItem createChangeDirectionItem(){
        JMenuItem changeDirection=new JMenuItem("Change message direction");
        changeDirection.addActionListener(actionEvent -> {
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
        });
        return changeDirection;
    }

    /**
     * This methods creates an entry in the "Message" menu that allows the user to change the message.
     * @return a JMenuItem with an ActionListener object.
     */
    private JMenuItem createSetMessageItem(){
        JMenuItem setMessage=new JMenuItem("Set message");
        setMessage.addActionListener(actionEvent -> {

            String oldMessage=this.message;
            this.message=JOptionPane.showInputDialog(this.component, "Please input a new message: ", "Set message", JOptionPane.INFORMATION_MESSAGE);
            while(this.message==null || this.message.length()==0){
                if(this.message==null){
                    this.message=oldMessage;
                }
                else{
                    JOptionPane.showMessageDialog(this.component, "Message field can not be empty!", "Error", JOptionPane.ERROR_MESSAGE);
                    this.message=JOptionPane.showInputDialog(this.component, "Please input a new message: ", "Set message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            this.component.setMessage(Programming_Exercise_11_17_Frame.this.message);
        });
        return setMessage;

    }

    /**
     * This methods creates a sub menu in the "Message" menu that allows the user to set the font size, font style, and font family.
     * @return a JMenu item.
     */
    private JMenu createSetMessageFontMenu(){

        JMenu fontMenu=new JMenu("Set message font");
        fontMenu.add(createSizeItem());
        fontMenu.add(createStyleMenu());
        fontMenu.add(createFontFamilyMenu());
        return fontMenu;
    }

    /**
     * This method adds an entry to the "Set message font" menu that allows the user to select a font family for the displayed message.
     * @return a JMenu object.
     */
    private JMenu createFontFamilyMenu(){

        class FontFamilyListener extends MouseAdapter {

            @Override
            public void mousePressed(MouseEvent e) {
                fontFamily = systemFonts.getSelectedValue();
                setFont();
            }
        }

        JMenu fontFamilyMenu=new JMenu("Set font family");
        this.systemFonts=new JList<>(GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames());
        this.systemFonts.addMouseListener(new FontFamilyListener());
        fontFamilyMenu.add(new JScrollPane(this.systemFonts));
        return fontFamilyMenu;
    }

    /**
     * This methods creates an entry in the "Set message font" menu that allows the user to change the size of the font that is used to display the message.
     * @return a JMenuItem object.
     */
    private JMenuItem createSizeItem() {

        final int SLIDER_MIN_VALUE=0;
        final int SLIDER_MAX_VALUE=100;
        JMenuItem sizeItem = new JMenuItem("Set font size");
        sizeItem.addActionListener(sizeEvent -> {
            Programming_Exercise_11_17_Vertical_Slider sizeSlider = new Programming_Exercise_11_17_Vertical_Slider(SLIDER_MIN_VALUE, SLIDER_MAX_VALUE, fontSize);
            sizeSlider.setLocation(this.getX() + this.getWidth() + GAP, this.getY());
            sizeSlider.setVisible(true);
            sizeSlider.getSlider().addChangeListener(sizeChangeEvent -> {

                    fontSize = sizeSlider.getSlider().getValue();
                    setFont();
            });
        });
        return sizeItem;
    }

    /**
     * This method creates a sub menu in the "Set message font" menu that allows the user to change the font style.
     * @return a JMenuItem object.
     */
    private JMenu createStyleMenu(){

        JMenu styleMenu=new JMenu("Set font style");
        styleMenu.add(createStyleItem("Bold", Font.BOLD));
        styleMenu.add(createStyleItem("Italic", Font.ITALIC));
        styleMenu.add(createStyleItem("Plain", Font.PLAIN));
        return styleMenu;

    }

    private JMenuItem createStyleItem(final String name, final int style){

        JMenuItem styleItem=new JMenuItem(name);
        styleItem.addActionListener(actionEvent -> {
            fontStyle=style;
            setFont();
        });
        return styleItem;

    }

    /**
     * This methods applies the new font when I change has been made by a user.
     */
    private void setFont(){
        font=new Font(fontFamily, fontStyle, fontSize);
        component.setFont(font);
    }

    /**
     * This method applies the new speed of the message when a change has been made by the user.
     * @param newSpeed the new speed.
     */
    private void setSpeed(int newSpeed){
        this.timer.setDelay(newSpeed);

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
                // Set message to start from top left corner.
                component.setXpos(0-component.getMessageWidth());
                component.setYpos(0);
                component.setNewDirection("right", "down");
            }
            else if(component.getYpos()<=0 && component.getDirection().getHorizontalDirection().equals("left") && component.getDirection().getVerticalDirection().equals("up")){
                // Set message to start from lower left corner.
                component.setXpos(0-component.getMessageWidth());
                component.setYpos(component.getPreferredSize().height+ component.getMessageHeight());
                component.setNewDirection("right", "up");
            }
            else if(component.getYpos()==0 && component.getDirection().getHorizontalDirection().equals("right") && component.getDirection().getVerticalDirection().equals("up")){
                // Set message to start from lower right corner.
                component.setXpos(component.getPreferredSize().width);
                component.setYpos(component.getPreferredSize().height+ component.getMessageHeight());
                component.setNewDirection("left", "up");
            }
            component.moveMessage();

        }
    }

    public static void main(String[] args){
        JFrame frame=new Programming_Exercise_11_17_Frame();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                System.out.println(frame.getWidth());
                
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

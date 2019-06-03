import java.awt.*;

public class Programming_Exercise_11_11_Item {

    private final int length;
    private final Color color;
    private final String name;

    public Programming_Exercise_11_11_Item(String name, int length, Color color){
        this.name=name;
        this.color=color;
        this.length=length;
    }

    public int getLength(){
        return this.length;
    }

    public String getName(){
        return this.name;
    }

    public Color getColor(){
        return this.color;
    }
}

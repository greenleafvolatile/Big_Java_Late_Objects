
public class Programming_Exercise_11_17_Direction{

    private String horizontal_direction;
    private String vertical_direction;

    public Programming_Exercise_11_17_Direction(String horizontal, String vertical) {
        horizontal_direction=horizontal;
        vertical_direction=vertical;
    }

    public void setHorizontalDirection(String horizontal) {
        horizontal_direction = horizontal;
    }

    public void setVerticalDirection(String vertical){
        vertical_direction=vertical;
    }

    public String getHorizontalDirection(){
        return horizontal_direction;
    }

    public String getVerticalDirection(){
        return vertical_direction;
    }
}

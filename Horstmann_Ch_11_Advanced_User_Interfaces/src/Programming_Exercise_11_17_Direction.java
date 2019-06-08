public class Programming_Exercise_11_17_Direction{

    String horizontal_direction, vertical_direction;

    public Programming_Exercise_11_17_Direction(String horizontal, String vertical){
        this.horizontal_direction=horizontal;
        this.vertical_direction=vertical;
    }

    public void setHorizontalDirection(String horizontal) {
        this.horizontal_direction = horizontal;
    }

    public void setVerticalDirection(String vertical){
        this.vertical_direction=vertical;
    }

    public String getHorizontalDirection(){
        return this.horizontal_direction;
    }

    public String getVerticalDirection(){
        return this.vertical_direction;
    }
}

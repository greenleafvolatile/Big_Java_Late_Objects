public class Programming_Exercise_11_17_Direction{

    String horizontal_directoin, vertical_direction;

    public Programming_Exercise_11_17_Direction(String horizontal, String vertical){
        this.horizontal_directoin=horizontal;
        this.vertical_direction=vertical;
    }

    public void setHorizontalDirectoin(String horizontal) {
        this.horizontal_directoin = horizontal;
    }

    public void setVerticalDirection(String vertical){
        this.vertical_direction=vertical;
    }

    public String getHorizontalDirectoin(){
        return this.horizontal_directoin;
    }

    public String getVerticalDirecion(){
        return this.vertical_direction;
    }
}

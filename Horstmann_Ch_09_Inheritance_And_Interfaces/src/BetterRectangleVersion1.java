public class BetterRectangle extends java.awt.Rectangle {

    public BetterRectangle(int x, int y, int width, int height) {
        super.setLocation(x, y);
        super.setSize(width, height);
    }

    public double getPerimeter() {
        return (this.getWidth()+this.getHeight())*2;
    }

    public double getArea() {
        return this.getWidth()*this.getHeight();
    }

    public static void main(String[] args) {

        BetterRectangle rectangle=new BetterRectangle(0, 0, 10, 5);
        System.out.println(rectangle.getPerimeter());
        System.out.println(rectangle.getArea());
    }
}

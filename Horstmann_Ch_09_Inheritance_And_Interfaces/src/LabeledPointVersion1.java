public class LabeledPoint {

    private int x;
    private int y;
    String label;

    public LabeledPoint(int x, int y, String label){
        this.x=x;
        this.y=y;
        this.label=label;
    }

    public String toString(){
        return "[x=" + this.x + "]\n" + "[y=" + this.y + "]\n" + "[label=" + this.label + "]\n";
    }


    public static void main(String[] args){

        LabeledPoint labeledPoint=new LabeledPoint(0, 0, "Point");
        System.out.println(labeledPoint.toString());
    }
}

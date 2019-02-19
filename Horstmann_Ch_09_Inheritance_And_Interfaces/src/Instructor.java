public class Instructor extends Person {

    private double salary;

    public Instructor(int yearOfBirth, String name, double salary) {
        super(yearOfBirth, name);
        this.salary = salary;
    }

    public String toString() {
        return super.toString() + "[salary=" + salary + "]";
    }


}

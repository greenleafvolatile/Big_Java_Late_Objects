public class Student extends Person {

    private String major;

    public Student(int yearOfBirth, String name, String major) {
        super(yearOfBirth, name);
        this.major = major;
    }

    public String toString() {
        return super.toString() + "[major=" + this.major + "]\n";
    }
}

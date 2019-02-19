public class Person {

    private int yearOfBirth;
    private String name;

    public Person(int yearOfBirth, String name) {
        this.yearOfBirth = yearOfBirth;
        this.name = name;
    }

    public String toString(){
        return getClass().getName() + "\n[name=" + this.name + "]\n" + "[Year of birth=" + this.yearOfBirth + "]\n";
    }

    public static void main(String[] args) {

        Person person = new Person(1920, "George");
        System.out.println(person.toString());
        Student student = new Student(1955, "John", "Mathmatics");
        System.out.println(student.toString());
        Instructor instructor = new Instructor(1950, "James", 2000);
        System.out.println(instructor.toString());
    }
}



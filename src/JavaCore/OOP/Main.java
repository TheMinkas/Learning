package JavaCore.OOP;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Minkas", 25, "Russia");
        System.out.println(student);

        Student student1 = new Student();
        student1.setName("Bob");
        System.out.println(student1);
    }
}

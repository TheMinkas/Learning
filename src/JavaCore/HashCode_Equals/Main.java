package JavaCore.HashCode_Equals;

public class Main {
    public static void main(String[] args) {
        Student student1 = new Student(1, "John", "23 East");
        Student student2 = new Student(2, "John", "23 East");
        Student student3 = new Student(1, "John", "23 East");

        System.out.println(student1.equals(student3));
        System.out.println(student1.hashCode() == student3.hashCode());
    }
}

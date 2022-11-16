package JavaCore.Strems;

import JavaCore.lamda.Student;

import java.util.ArrayList;
import java.util.List;

public class StreamFlatMap {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 6.3);
        Student student2 = new Student("Bob", 'm', 25, 2, 8.3);
        Student student3 = new Student("Elena", 'f', 23, 3, 7.3);
        Student student4 = new Student("Petr", 'm', 24, 1, 2.3);
        Student student5 = new Student("Maria", 'f', 26, 4, 4.3);

        Faculty f1 = new Faculty("Economica");
        Faculty f2 = new Faculty("Applied mathematics");

        f1.addStudentToFaculty(student1);
        f1.addStudentToFaculty(student2);
        f1.addStudentToFaculty(student3);
        f2.addStudentToFaculty(student4);
        f2.addStudentToFaculty(student5);

        List<Faculty> facultyList = new ArrayList<>();
        facultyList.add(f1);
        facultyList.add(f2);

        facultyList.stream().flatMap(faculty -> faculty.getStudentsOnFaculty().stream()).forEach(e -> System.out.println(e.getName()));

    }
}

class Faculty{
    String name;
    List<Student> studentsOnFaculty;

    public Faculty(String name) {
        this.name = name;
        this.studentsOnFaculty = studentsOnFaculty;
    }

    public List<Student> getStudentsOnFaculty() {
        return studentsOnFaculty;
    }

    public void addStudentToFaculty(Student st) {
        studentsOnFaculty.add(st);
    }
}
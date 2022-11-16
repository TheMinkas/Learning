package JavaCore.OOP.lamda;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test_ArrayList_Methods2 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 'm', 22, 3, 6.3);
        Student student2 = new Student("Bob", 'm', 25, 2, 8.3);
        Student student3 = new Student("Elena", 'f', 23, 3, 7.3);
        Student student4 = new Student("Petr", 'm', 24, 1, 2.3);
        Student student5 = new Student("Maria", 'f', 26, 4, 4.3);
        List<Student> studentList = new ArrayList<>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);

        StudentInfo studentInfo = new StudentInfo();

        studentInfo.testStudents(studentList, (Student s) -> {return s.getAge()<24;});
        System.out.println("__________");

        //Равносильные строчки
        studentInfo.testStudents(studentList, (Student s) -> {return s.getAvgGrade() > 6;});
        studentInfo.testStudents(studentList, s -> s.getAvgGrade() > 6);

        System.out.println("__________");
        studentInfo.testStudents(studentList, (Student s) -> {return s.getAge()>24 && s.getCourse()>1 && s.getSex() == 'm';});

        System.out.println("__________");

    }


    /*public void printStudentOverGrade (List<Student> students, double grade) {
        for (Student s : students) {
            if (s.getAvgGrade() > grade) {
                System.out.println(s);
            }
        }
    }
    public void printStudentUnderAge (List<Student> students, int age) {
        for (Student a : students) {
            if (a.getAge() < age) {
                System.out.println(a);
            }
        }
    }
    public void printStudentMixCondition (List<Student> students, int age, double grade, char sex) {
        for (Student m : students) {
            if (m.getAge() > age && m.getAvgGrade() < grade && m.getSex() == sex) {
                System.out.println(m);
            }
        }
    }*/
}

class StudentInfo {
    void testStudents(List<Student> students, StudentCheck studentCheck) {
        for (Student student : students) {
            if(studentCheck.check(student)) {
                System.out.println(student);
            }
        }
    }
}

interface StudentCheck {
    boolean check(Student student);
}

package JavaCore.Strems;

import JavaCore.lamda.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
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

        studentList = studentList.stream().filter(element -> element.getAge()>22 && element.getAvgGrade()<7).collect(Collectors.toList());
        System.out.println(studentList);

        //Если нужно сосздать свой стрим
        Stream<Student> myStream = Stream.of(student1, student2, student3, student4, student5);
        myStream.filter(element -> element.getAge()>22 && element.getAvgGrade()<7).collect(Collectors.toList());

    }
}

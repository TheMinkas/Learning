package JavaCore.Strems;

import JavaCore.lamda.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSorted {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 12, 4, 21, 81, 7, 18};
        array = Arrays.stream(array).sorted().toArray();
        System.out.println(Arrays.toString(array));

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

        //Сортировка списка сдудентов
        studentList = studentList.stream().sorted((x,y) -> x.getName().compareTo(y.getName())).collect(Collectors.toList());
        System.out.println(studentList);
    }
}

package JavaCore.Strems;

import JavaCore.Collections.Collections_List;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapToInt {
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

        //Возвращает циферное значение, в данном случае int
        //boxed необходим для преобразования int в Integer
        List<Integer> courses = studentList.stream()
                .mapToInt(el -> el.getCourse())
                .boxed()
                .collect(Collectors.toList());
        System.out.println(courses);

        //сумма
        int sum = studentList.stream().mapToInt(el -> el.getCourse()).sum();
        System.out.println(sum);

        //среднее арефметическое
        double average = studentList.stream()
                .mapToInt(el -> el.getCourse())
                .average()
                .getAsDouble();
        System.out.println(average);

        //минимальное значение
        int min = studentList.stream()
                .mapToInt(el -> el.getCourse())
                .min()
                .getAsInt();
        System.out.println(min);

        //максимальное значение
        double max = studentList.stream()
                .mapToDouble(el -> el.getAvgGrade())
                .max()
                .getAsDouble();
        System.out.println(max);
    }
}

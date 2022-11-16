package JavaCore.Strems;

import java.util.ArrayList;
import java.util.List;

public class StreamMinMax {
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


        //обращаюсь к листу студентов, запускаю стрим и обращаюсь к методу min,
        //принимаю два параметра или элемента и как-то сравниваю....
        Student min = studentList.stream().min((x,y) -> x.getAge() - y.getAge()).get();
        System.out.println(min);

        Student max = studentList.stream().max((x,y) -> x.getAge() - y.getAge()).get();
        System.out.println(max);
    }
}

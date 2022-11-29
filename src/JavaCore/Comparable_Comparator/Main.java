package JavaCore.Comparable_Comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        Student student1 = new Student(3, "John", 21);
        Student student2 = new Student(1, "Jane", 18);
        Student student3 = new Student(2, "Tom", 20);

        list.add(student1);
        list.add(student2);
        list.add(student3);

        //Сортировка по имени (По алфавиту)
        //Collections.sort(list, new FirstComparator());

        //Сортировка по возрасту
        //Collections.sort(list, new SecondComparator());

        //Сортировка по личному номеру. Это дефолтная сортировка,
        //заданная в классе Student по умолчанию в методе compareTo
        Collections.sort(list);

        list.forEach(System.out::println);

    }
}

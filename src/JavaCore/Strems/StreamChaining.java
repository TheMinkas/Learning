package JavaCore.Strems;

import JavaCore.lamda.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamChaining {
    public static void main(String[] args) {
        int[] array = {3, 8, 1, 5, 9, 12, 4, 21, 81, 7, 18};

        //фильтруем масив по не чётным числам, если число делится на 3 без остатка,
        //то мы делим его на 3, после сумируем все числа в массиве
        int result = Arrays.stream(array).filter(e -> e % 2 == 1).map(e -> {
            if(e%3==0) {
                e=e/3;
            }
            return e;
        }).reduce((a,e) -> a+e).getAsInt();
        System.out.println(result);

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


        //Перевёл имена в верхний регистр, отфильтровал по возрасту,
        //отсортировал по возрасту и вывел на экран результат
        studentList.stream().map(e ->
        {
            e.setName(e.getName().toUpperCase());
            return e;
        })
                .filter(e -> e.getSex() == 'f')
                .sorted((x,y) -> x.getAge() - y.getAge())
                .forEach(System.out::println);

    }
}

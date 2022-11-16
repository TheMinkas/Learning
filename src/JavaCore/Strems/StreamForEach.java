package JavaCore.Strems;

import java.util.Arrays;

public class StreamForEach {
    public static void main(String[] args) {
        int[] array = {5, 9, 3, 8, 1};
        Arrays.stream(array).forEach(el -> System.out.print(el*2 + " "));
        //Если нужно вывести массив на экран
        Arrays.stream(array).forEach(System.out::println);
        System.out.println("--------");
        //Arrays.stream(array).forEach(el -> Utils.myMethod(el));
        //Короткий вариант написания верхней строчки
        Arrays.stream(array).forEach(Utils::myMethod);

    }
}

class Utils {
    public static void myMethod(int a) {
        a = a+5;
        System.out.println("Element = " + a);
    }
}

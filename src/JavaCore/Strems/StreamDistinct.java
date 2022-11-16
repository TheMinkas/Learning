package JavaCore.Strems;

import java.util.Arrays;

public class StreamDistinct {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 2, 3, 4, 5, 6};

        //метод уберает повторы в масивах или списках
        Arrays.stream(num).distinct().forEach(System.out::print);
        System.out.println("");
        Arrays.stream(num).distinct().forEach(value -> System.out.print(value + " "));
    }

}

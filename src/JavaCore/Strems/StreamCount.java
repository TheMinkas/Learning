package JavaCore.Strems;

import java.util.Arrays;

public class StreamCount {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 1, 2, 3, 4, 5, 6};

        //Метод count считает колличество элементов в масиве или листе
        //В данном примере считает колличество уникальных элементов массива
        long nums = Arrays.stream(num).distinct().count();
        System.out.println(nums);
    }
}

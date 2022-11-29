package Qvest;

import java.util.*;

public class ArrayShuffle {
    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

        Random random = new Random();
        for(int i = 0; i< array.length; i++) {
            int randomIndexToSwap = random.nextInt(array.length);
            int temp = array[randomIndexToSwap];
            array[randomIndexToSwap] = array[i];
            array[i] = temp;
        }
        System.out.println(Arrays.toString(array));

        List<String> list = new ArrayList<>();

        for (int i = 0; i<10; i++) {
            list.add("and" + i);
        }
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
    }


}

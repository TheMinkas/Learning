package Algorithms;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] array = {10, 0, 64, 20, 50, 1, 90, 100, 45, 20, 2, 55, 13};
        AlgorithmsSort algorithmsSort = new AlgorithmsSort();
        //algorithmsSort.minArray(array);
        //algorithmsSort.bubbleSort(array);
        //algorithmsSort.selectionSort(array);
        algorithmsSort.insertionSort(array);
        //System.out.println(Arrays.toString(array));
    }
}

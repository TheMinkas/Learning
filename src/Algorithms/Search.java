package Algorithms;

import java.util.Arrays;
import java.util.Scanner;

public class Search {
    Scanner scanner = new Scanner(System.in);
    AlgorithmsSort algorithmsSort = new AlgorithmsSort();

    public void searchLinear(int[] array) {
        System.out.print("Enter number: ");
        int inputNumber = scanner.nextInt();
        boolean checkFindIndexFlag = false;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == inputNumber) {
                System.out.println("Index = " + i);
                checkFindIndexFlag = true;
            }
        }
        if (checkFindIndexFlag == false) {
            System.out.println("Number not find");
        }
    }

    //При данном поиске массив должен быть отсортирован. Является более быстрым видом поиска
    public  void searchBinary(int[] array) {
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.print("Enter number: ");
        int inputNumber = scanner.nextInt();
        boolean checkFindIndexFlag = false;

        int startIndex = 0;
        int endIndex = array.length-1;
        int middleIndex;

        while (startIndex <= endIndex) {
            middleIndex = startIndex + (endIndex - startIndex) / 2;

            if (array[middleIndex] == inputNumber) {
                System.out.println("Index = " + middleIndex);
                checkFindIndexFlag = true;
            }

            if (array[middleIndex]  > inputNumber) {
                endIndex = middleIndex - 1;
            } else {
                startIndex = middleIndex + 1;
            }
        }

        if (checkFindIndexFlag == false) {
            System.out.println("Number not find");
        }
    }


}

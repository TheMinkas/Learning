package Algorithms;

public class AlgorithmsSort {

    //нахождение минимального и максимального элемента масива
    public void minArray(int [] array) {
        int min = array[0];
        int max = array[0];

        for (int i=0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Min value = " + min + "\n"
                + "Max value = " + max);
    }

    //Сортировка пузырьком по возрастанию
    //Сравнение чисел по парно - первый со вторым, второй с первым, если левый элемент больше чем правый,
    //то мы их меняем местами и так для каждого элемента массива
    public void bubbleSort(int[] array) {
        printArray(array);

        boolean isSorted = false;                       //Флаг, что масив отсортирован
        while(!isSorted) {                              //Пока масив не отсортирован
            isSorted = true;                            //Масив отсортирован
            for(int i = 1; i < array.length; i++) {     //Перебор масива
                if (array[i] < array[i-1]) {            //Если правый меньше левого
                    int temp = array[i];                //Меняем местами через временную переменную temp присвоив значение правого элемента
                    array[i] = array[i-1];              //первый элемент становится вторым элементом
                    array[i-1] =  temp;                 //второй элемент становится первым
                    isSorted = false;                   //Если была какая-либо перестановка то сбрасываем флажок на ложь и повторям пока не будет отсортирован массив
                }
            }
            printArray(array);
        }

    }

    //Сортировка выбором
    //Сортировка выбирает 0 элемент масива и сравнивает его с последующими
    //если n элемент < 0 элемента, то они меняются местами, дальше переходит к 1 элементу масива
    //и процесс повторяется пока масив не будет отсортирован
    public void selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            printArray(array);
            int minElementIndex = i;//
            for (int j = i + 1; j < array.length; j++) {        //Поиск минимального значения, перебирая индесы в массиве
                if (array[minElementIndex] > array[j]) {
                    minElementIndex = j;
                }
            }

            if (minElementIndex != i) {
                int temp = array[i];
                array[i] = array[minElementIndex];
                array[minElementIndex] = temp;
            }
        }
    }

    public void insertionSort (int[] array) {
        for (int i = 1; i < array.length; i++) {        //Перебор массива
            int actualValue = array[i];                 //Беру 1 элемент массива
            int j = i;
            while (j > 0 && array[j-1] > actualValue) { //Сдвигаю все элементы которые больше в право для того, чтобы освободить ячейку
                array[j] = array[j-1];
                j--;
            }
            array[j] = actualValue;                     //втавляю элемент в освободившуюся ячейку
            printArray(array);
        }
    }


    public void printArray(int[] array) {
        System.out.println("");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + ", ");
        }
    }
}

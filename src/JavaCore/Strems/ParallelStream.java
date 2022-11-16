package JavaCore.Strems;

import java.util.ArrayList;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Double> list = new ArrayList<>();
        list.add(10.1);
        list.add(5.1);
        list.add(7.5);
        list.add(8.1);
        list.add(20.1);


        //результат что и у stream, но parallelStream задействует больше ядер
        // тем самым если очень много элементов в листе,
        // задачи будут распределены между ядрами и процесс выполнения займёт меньше времени
        double sumResult = list.parallelStream()
                .reduce((x,y) -> x+y).get();
        System.out.println(sumResult);
    }
}

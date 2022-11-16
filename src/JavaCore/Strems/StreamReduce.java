package JavaCore.Strems;

import java.util.*;

public class StreamReduce {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(2);
        list.add(4);
        list.add(3);

        //5, 8, 2, 4, 3
        //accumulator = 5
        //element =     8
        //После присвоения первых двух элементов первый элемент умножается на второй (5*8) и
        //произведение приравнивается к accumulator, после берется 3 элемент и
        // упножается на произведение и так пока не будет получен результат
        //accumulator = 40   80   320   960
        //element =     2    4    3
        int result = list.stream().reduce((accumulator, element) ->
                accumulator*element).get();
        System.out.println(result);

        //Если лист пустой
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o = list100.stream().reduce((accumulator, element) -> accumulator*element);
        if (o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("List is empty");
        }
        //Если необходимо сделать из списка строку
        List<String> list2 = new ArrayList<>();
        list2.add("privet");
        list2.add("kak dela?");
        list2.add("Ok");
        list2.add("poka");

        String listResult = list2.stream().reduce((x,y) -> x + " " + y).get();
        System.out.println(listResult);
    }
}

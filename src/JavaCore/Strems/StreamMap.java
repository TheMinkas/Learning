package JavaCore.Strems;

import java.util.*;
import java.util.stream.Collectors;

public class StreamMap {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("22");
        list.add("333");
        list.add("4444");

        //Метод map позволяет перебрать каждый элемент листа или массива, и применить к ним какое, либо действие
        List<Integer> list2 = list.stream().map(element -> element.length()).collect(Collectors.toList());
        System.out.println(list2);
        System.out.println("_____");
        int[] array = {5, 9, 3, 8, 1};
        array = Arrays.stream(array).map(element -> {
            if(element%3 ==0) {
                element = element/3;
            }
            return element;
        }).toArray();
        System.out.println(Arrays.toString(array));
        System.out.println("_____");

        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela?");
        set.add("Ok");
        set.add("poka");

        Set<Integer> set2 = set.stream().map(element -> element.length()).collect(Collectors.toSet());
        System.out.println(set2);

    }
}

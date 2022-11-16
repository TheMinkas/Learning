package JavaCore.Strems;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class OOP_Stream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println(list);

        /*List<Integer> squaresList = new ArrayList<>();
        for (Integer i : list) {
            squaresList.add(i*i);
        }
        System.out.println(squaresList);*/

        List<Integer> squaresList = list.stream().map(i -> i*i).collect(Collectors.toList());
        System.out.println(squaresList);

        List<String> lang = new ArrayList<>();
        lang.add("super");
        lang.add("java");
        lang.add("c++");
        lang.add("python");
        lang.add("scala");


        //Фильтрация
        List<String> listFilter = lang.stream().filter(s -> s.contains("th")).collect(Collectors.toList());
        System.out.println(listFilter);

        //Сортировка коллекции
//        List<String> listFilter = lang.stream().sorted().collect(Collectors.toList());
//        System.out.println(listFilter);

        //перебор коллекции
//        lang.stream().forEach(y-> {
//            y +=y;
//                    System.out.println(y);
//                }
//                );

//        int sum = list.stream().reduce(0,(result,i) -> result+i);
//        System.out.println(sum);


    }
}

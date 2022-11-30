package JavaCore.Collections;

import java.util.*;

public class Collections_List {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i=1; i<=5; i++){
            list.add(i);
        }
        System.out.println(list);
        list.remove(2);

        for(int i : list) {
            System.out.print(i + " ");
        }

        list.addAll(2, Collections.singleton(5));
        System.out.println("________");
        System.out.println(list);
        System.out.println("-------------");

        for(int i = 0; i<list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        LinkedList<String> list2 = new LinkedList<>();

        list2.add("A");
        list2.add("B");
        list2.addFirst("C");
        list2.addLast("D");
        list2.add(2,"E");

        System.out.println("\n" + list2);

        System.out.println(list2.contains("A"));



    }
}

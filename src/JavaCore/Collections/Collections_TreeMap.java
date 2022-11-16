package JavaCore.Collections;

import java.util.TreeMap;

public class Collections_TreeMap {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        treeMap.put(3, "A");
        treeMap.put(2, "B");
        treeMap.put(1, "C");
        treeMap.put(4, "C");
        treeMap.put(5, "C");

        System.out.println(treeMap);
        System.out.println(treeMap.descendingMap()); //в обратном порядке

        System.out.println(treeMap.tailMap(3));
        System.out.println(treeMap.headMap(3));
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.firstEntry());
        System.out.println();

    }
}

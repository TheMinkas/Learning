package JavaCore.Collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Collections_Set {
    public static void main(String[] args) {
        Set<Integer> hashset = new HashSet<>();
        hashset.add(1);
        hashset.add(20);
        hashset.add(13);
        hashset.add(5);
        hashset.add(10);

        System.out.println(hashset);

        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(20);
        treeSet.add(5);
        treeSet.add(10);
        treeSet.add(3);

        System.out.println(treeSet);

        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(20);
        linkedHashSet.add(30);
        linkedHashSet.add(5);

        System.out.println(linkedHashSet);


    }
}

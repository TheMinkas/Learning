package JavaCore.Collections;

import java.util.Set;

public class HashSet {
    public static void main(String[] args) {
        Set<String> hashSet = new java.util.HashSet<>();

        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("C"); //Не добавляет дубликаты, при этом значение не перезаписывается

        System.out.println(hashSet);
    }
}

package JavaCore.Collections;

import java.util.HashMap;
import java.util.Map;

public class Collections_HashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);
        map.put("c", 30);

        System.out.println("Size: " + map.size());
        System.out.println(map);

        if (map.containsKey("a")) {
            int a = map.get("a");
            System.out.println(a);
        }
        //Перебор HashMap если не известны данные в <>
        for (String key : map.keySet()) {
            System.out.println("key: " + key + ", value: " + map.get(key));
        }

        System.out.println("");

        //Перебор HashMap если известны данные в <>
        for (Map.Entry<String,Integer> entry : map.entrySet()) {
            System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
        }
    }
}

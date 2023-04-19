package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("n0kky21rus@gmail.com", "Petya");
        map.put("n0kky21rus@gmail.com", "Ivan Popov");
        map.put("123@gmail.com", "Igor");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " = " + value);
        }
    }
}

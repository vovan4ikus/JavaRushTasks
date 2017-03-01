package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        map.put("A", 100);
        map.put("B", 200);
        map.put("C", 500);
        map.put("D", 100);
        map.put("E", 600);
        map.put("F", 700);
        map.put("G", 800);
        map.put("H", 1000);
        map.put("I", 1020);
        map.put("J", 1200);
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext())
        {
            Map.Entry<String, Integer> pair = iterator.next();
            if (pair.getValue()<500) iterator.remove();
        }
    }

    public static void main(String[] args) {
        removeItemFromMap(createMap());
    }
}
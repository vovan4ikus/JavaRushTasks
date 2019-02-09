package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();
        if (args.length != 0) {
            if (args[0].equals("-c")) {

                addNewProduct(args, fileName);
            }
        }
    }

    public static void addNewProduct(String[] args, String filename) throws Exception {
        int id = maxId(filename) + 1;
        StringBuilder sb = new StringBuilder();
        sb = sb.append(String.format("\n" + "%-8d" + "%-30s" + "%-8s" + "%-4s", id, args[1], args[2], args[3]));
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
        writer.write(sb.toString());
        writer.close();


    }

    public static Integer maxId(String name) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(name));
        ArrayList<Integer> list = new ArrayList<>();
        String s = reader.readLine();
        while (s != null) {
            list.add(Integer.parseInt(s.substring(0, 8).trim()));
            s = reader.readLine();
        }
        reader.close();
        Collections.sort(list);
        return list.get(list.size() - 1);
    }
}

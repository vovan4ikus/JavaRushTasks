package com.javarush.task.task18.task1828;

/* 
Прайсы 2
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
            if (args[0].equals("-u")) {

                updateProduct(args, fileName);
            }
            if (args[0].equals("-d")) {
                deleteProduct(args, fileName);
            }
        }
    }

    public static void updateProduct(String[] args, String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<String> list = new ArrayList<>();
        String s = reader.readLine();
        while (s != null) {
            list.add(s);
            s = reader.readLine();
        }
        reader.close();
        int id = Integer.parseInt(args[1]);
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i).substring(0, 8).trim()) == id) {
                StringBuilder sb = new StringBuilder();
                sb = sb.append(String.format("%-8d" + "%-30s" + "%-8s" + "%-4s", id, args[2], args[3], args[4]));
                list.set(i, sb.toString());
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String s1 : list) {
            System.out.println(s1);
            writer.write(s1);
            writer.write("\n");
        }
        writer.close();
    }

    public static void deleteProduct(String[] args, String filename) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<String> list = new ArrayList<>();
        String s = reader.readLine();
        while (s != null) {
            list.add(s);
            s = reader.readLine();
        }
        reader.close();
        int id = Integer.parseInt(args[1]);
        for (int i = 0; i < list.size(); i++) {
            if (Integer.parseInt(list.get(i).substring(0, 8).trim()) == id) {
                list.remove(i);
            }
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (String s1 : list) {
            System.out.println(s1);
            writer.write(s1);
            writer.write("\n");
        }
        writer.close();
    }

}

package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();

        BufferedReader fileReader1 = new BufferedReader(new FileReader(file1));
        BufferedReader fileReader2 = new BufferedReader(new FileReader(file2));

        String s1;
        while ((s1 = fileReader1.readLine()) != null) {
            list1.add(s1);
        }


        String s2;
        while ((s2 = fileReader2.readLine()) != null) {
            list2.add(s2);
        }


        fileReader1.close();
        fileReader2.close();

        for (int i = 0, j = 0; ; ) {
            if (j == list2.size()-1 && i == list1.size()) {
                list1.add("");
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                break;

            }
            if (i == list1.size()-1 && j == list2.size()) {
                list2.add("");
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                break;
            }
//            SAME
            if (list1.get(i).equals(list2.get(j))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                i++;
                j++;
                if (j == list2.size() && i == list1.size()) {break;}
                continue;
            }
            //            ADDED
            if (!list1.get(i).equals(list2.get(j)) && list1.get(i).equals(list2.get(j + 1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(j)));
                j++;
                continue;
            }
//            REMOVED
            if (!list1.get(i).equals(list2.get(j)) && list1.get(i + 1).equals(list2.get(j))) {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                i++;
                continue;
            }



        }



    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }

}

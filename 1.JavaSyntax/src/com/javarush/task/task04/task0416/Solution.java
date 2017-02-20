package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        float a = Float.parseFloat(reader.readLine());
        while (a >= 5)
            a-=5;
        if (a >= 0 && a < 3)
            System.out.println("зелёный");
        if (a >= 3 && a < 4)
            System.out.println("желтый");
        if (a >= 4 && a < 5)
            System.out.println("красный");
    }
}
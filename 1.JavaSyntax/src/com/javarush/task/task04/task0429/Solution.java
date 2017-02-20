package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int a = 0;
        int b = 0;
        int[] x = new int[3];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        x[0] = Integer.parseInt(reader.readLine());
        x[1] = Integer.parseInt(reader.readLine());
        x[2] = Integer.parseInt(reader.readLine());
        reader.close();

        for (int i = 0; i < x.length; i++) {
            if (x[i] > 0) b++;
            if (x[i] < 0) a++;
        }

        System.out.println("количество отрицательных чисел: " + a);
        System.out.println("количество положительных чисел: " + b);

    }
}

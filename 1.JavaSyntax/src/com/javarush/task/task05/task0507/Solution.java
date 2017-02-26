package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        int count = 0;

        while(true){
            int x = Integer.parseInt(reader.readLine());
            if (x == -1) break;
            a+=x;
            count++;
        }
        System.out.println((float)a/count);



    }
}


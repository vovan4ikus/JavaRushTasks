package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        reader.close();
        if (a==b && a ==c)
            System.out.println(a);
        if (a>c && a<b || a<c && a>b){
            System.out.println(a);
        }
        if (b>c && b<a || b<c && b>a){
            System.out.println(b);
        }
        if (c>a && c<b || c<a && c>b){
            System.out.println(b);
        }


    }
}

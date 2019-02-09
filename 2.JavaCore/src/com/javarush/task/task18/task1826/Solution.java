package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        switch (args[0]) {
            case ("-e"):
                encrypt(args);
                break;
            case ("-d"):
                decrypt(args);
                break;


        }

    }

    public static void encrypt(String[] arr) throws IOException {
        FileInputStream inFile = new FileInputStream(arr[1]);
        FileOutputStream outFile = new FileOutputStream(arr[2]);
        while (inFile.available() > 0) {
            outFile.write(inFile.read() + 1);
        }
        inFile.close();
        outFile.close();
    }

    public static void decrypt(String[] arr) throws IOException{
        FileInputStream inFile = new FileInputStream(arr[1]);
        FileOutputStream outFile = new FileOutputStream(arr[2]);
        while (inFile.available() > 0) {
            outFile.write(inFile.read() - 1);
        }
        inFile.close();
        outFile.close();
    }

}

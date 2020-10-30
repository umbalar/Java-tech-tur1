package com.company;

import java.io.*;
import java.util.Scanner;

public class D {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        String[] in1 = scan.nextLine().split(" ", 2);
        read.close();
        int arrayLength = Integer.parseInt(in1[0]);
        int ar1[] = new int[arrayLength];
        int k = 0;
        for (String i : in1[1].split(" ")){
            ar1[k] = Integer.parseInt(i);
            k+=1;
        }
        String stringOut = "";
        int temp;
        for (int j = 0; j < arrayLength-1; j++) {
            for (int i = 0; i < arrayLength - 1 - j; i++) {
                if (ar1[i] > ar1[i + 1]) {
                    temp = ar1[i];
                    ar1[i] = ar1[i + 1];
                    ar1[i + 1] = temp;
                }
            }
        }
        for (int i : ar1){
            stringOut += i + " ";
        }
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(stringOut);
        wr.close();
    }
}
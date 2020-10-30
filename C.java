package com.company;

import java.io.*;
import java.util.Scanner;

public class C {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        int arrayLength = Integer.parseInt(scan.nextLine());
        String[] arrayA = new String[arrayLength];
        int k = 0;
        for (String subString : scan.nextLine().split(" ")){
            arrayA[k] = subString;
            k+=1;
        }
        String[] arrayB = new String[arrayLength];
        k = 0;
        for (String subString : scan.nextLine().split(" ")){
            arrayB[k] = subString;
            k+=1;
        }
        read.close();
        String stringOut = "";
        for (int i = 0; i < arrayLength; i++){
            for (int j = 0; j < arrayLength; j++){
                if (arrayB[i].equals(arrayA[j])){
                    stringOut += j + " ";
                }
            }
        }
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(stringOut);
        wr.close();
    }
}
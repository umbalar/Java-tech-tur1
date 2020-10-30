package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        String stringIn = scan.nextLine();
        int arrayLength = Integer.parseInt(stringIn);
        int arrayLength1 = arrayLength;
        int[] arrayA = new int[arrayLength];
        stringIn = scan.nextLine();
        int k = 0;
        for (String subString : stringIn.split(" ")){
            arrayA[k] = Integer.parseInt(subString);
            k+=1;
        }
        int temp;
        for (int j = 0; j < arrayLength-1; j++) {
            for (int i = 0; i < arrayLength - 1 - j; i++) {
                if (arrayA[i] > arrayA[i + 1]) {
                    temp = arrayA[i];
                    arrayA[i] = arrayA[i + 1];
                    arrayA[i + 1] = temp;
                }
            }
        }
        //System.out.println(Arrays.toString(arrayA));
        k = 0;
        for (int i = 0; i < arrayLength-1-k; i++) {
            while (arrayA[i] == arrayA[i+1]) {
                k+=1;
                //System.out.println("i=" + i + "  " + Arrays.toString(arrayA));
                for (int j = i; j < arrayLength-1; j++) {
                    arrayA[j] = arrayA[j+1];
                    //System.out.println("j=" + j + "  " + Arrays.toString(arrayA));
                }
            }
        }
        arrayLength -= k;
        k = 0;
        for (int i = 0; i < arrayLength; i++){
            k+=arrayLength-i-1;
        }
        int[] arrayB = new int[k];
        //System.out.println("k=" + k + "    arrayLength=" + arrayLength);
        k = 0;
        for (int i = 0; i < arrayLength-1; i++){
            for (int j = i+1; j < arrayLength; j++){
                //System.out.println(arrayA[j] - arrayA[i]);
                arrayB[k] = arrayA[j] - arrayA[i];
                k +=1;
            }
        }
        for (int j = 0; j < k-1; j++) {
            for (int i = 0; i < k - 1 - j; i++) {
                if (arrayB[i] > arrayB[i + 1]) {
                    temp = arrayB[i];
                    arrayB[i] = arrayB[i + 1];
                    arrayB[i + 1] = temp;
                }
            }
        }
        k = 0;
        //System.out.println(Arrays.toString(arrayB));
        for (int i = 0; i < arrayB.length-1-k; i++) {
            while (arrayB[i] == arrayB[i+1]) {
                k+=1;
                //System.out.println("i=" + i + "  " + Arrays.toString(arrayB));
                for (int j = i; j < arrayB.length-1; j++) {
                    arrayB[j] = arrayB[j+1];
                    //System.out.println("j=" + j + "  " + Arrays.toString(arrayA));
                }
            }
        }
        k=0;
        while (arrayB[k]!=arrayB[k+1]){
            k+=1;
        }
        int arrayLength2=k+1;
        int maxCount = 0;
        int start = arrayA[0];
        int step = arrayB[0];
        System.out.println(Arrays.toString(arrayA));
        for (int i = 0; i<arrayLength2-1; i++){
            int count = 0;
            for (int j = 0; j<arrayLength; j++){
                System.out.println("i=" + i + "   j=" + j);
                while (cunt(arrayA, arrayA[i]+(arrayB[j]*count))) {
                    count += 1;
                }
                if (maxCount<count){
                    maxCount = count;
                    start = arrayA[i+1];
                    step = arrayB[j];
                }
            }
        }
//        System.out.println("chek");
        String strOut = "";
        for (int i = 0; i<maxCount; i++){
            System.out.println("i=" + i);
            strOut+=(start+i*step) + " ";
        }
//        System.out.println("maxCount=" + maxCount + "  start= " + start + "  step=" + step);
//        System.out.println("strOut=" + strOut);
//        System.out.println(Arrays.toString(arrayA));
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(strOut);
        wr.close();
    }
    public static boolean cunt (final int[]array, final int v){
        boolean result = false;
        for (int i : array){
            if (i==v){
                result = true;
                break;
            }
        }
        return result;
    }
}

//1, 2, 3, 4, 5
//0, 1, 3, 6, 10
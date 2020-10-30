package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class H {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        String[] input = scan.nextLine().split(" ");
        int mSize = Integer.parseInt(input[0]);
        int[][] mtrx= new int[mSize][mSize];
        int strNumber = Integer.parseInt(input[1])-1;
        read.close();
        int currentNumber = mSize * mSize;
        Arrays.fill(mtrx[1], 0);
        for (int i = 0; i<mSize; i++){
            Arrays.fill(mtrx[i], 0);
        }
        moveRight(mtrx,0,0,currentNumber,mSize);
        String strOut = "";
        for (int i = 0; i < mSize; i++){
            strOut+=mtrx[i][strNumber] + " ";
        }
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(strOut);
        wr.close();
    }
    public static int moveRight (final int[][]array, final int x, final int y, final int n, final int r){
        array[x][y] = n;
        if (n>1) {
            if (x < r - 1) {
                if (array[x + 1][y] == 0) {
                    moveRight(array, x + 1, y, n - 1, r);
                }
                else {
                    moveDown(array, x, y+1, n - 1, r);
                }
            }
            else {
                moveDown(array, x, y+1, n - 1, r);
            }
        }
        return 0;
    }
    public static int moveDown (final int[][]array, final int x, final int y, final int n, final int r){
        array[x][y] = n;
        if (n>1) {
            if (y < r - 1) {
                if (array[x][y+1] == 0) {
                    moveDown(array, x, y+1, n - 1, r);
                }
                else {
                    moveLeft(array, x-1, y, n - 1, r);
                }
            }
            else {
                moveLeft(array, x-1, y, n - 1, r);
            }
        }
        return 0;
    }
    public static int moveLeft (final int[][]array, final int x, final int y, final int n, final int r){
        array[x][y] = n;
        if (n>1) {
            if (x > 0) {
                if (array[x-1][y] == 0) {
                    moveLeft(array, x-1, y, n - 1, r);
                }
                else {
                    moveUp(array, x, y-1, n - 1, r);
                }
            }
            else {
                moveUp(array, x, y-1, n - 1, r);
            }
        }
        return 0;
    }
    public static int moveUp (final int[][]array, final int x, final int y, final int n, final int r){
        array[x][y] = n;
        if (n>1) {
            if (array[x][y-1] == 0) {
                moveUp(array, x, y-1, n - 1, r);
            }
            else {
                moveRight(array, x+1, y, n - 1, r);
            }
        }
        return 0;
    }
}
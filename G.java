package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class G {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        int mSize = Integer.parseInt(scan.nextLine());
        int[][] map= new int[mSize][mSize];
        for (int i = 0; i < mSize; i++){
            String[] line = scan.nextLine().split(" ");
            for (int j = 0; j < mSize; j++){
                map[i][j]=Integer.parseInt(line[j]);
            }
        }
        read.close();
        int max = 0;
        for (int i = 0; i < mSize - 1; i++){
            for (int j = 0; j < mSize; j++){
                if (Math.abs(map[i][j] - map[i+1][j]) > max){
                    max = Math.abs(map[i][j] - map[i+1][j]);
                }
                if (j < mSize - 1){
                    if (Math.abs(map[i][j] - map[i][j+1]) > max){
                        max = Math.abs(map[i][j] - map[i][j+1]);
                    }
                }
            }
        }
        for (int j = 0; j < mSize-1; j++){
            if (Math.abs(map[mSize-1][j] - map[mSize-1][j+1]) > max){
                max = Math.abs(map[mSize-1][j] - map[mSize-1][j+1]);
            }
        }
        String strOut = "" + max;
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(strOut);
        wr.close();
    }
}
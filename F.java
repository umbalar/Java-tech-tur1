package com.company;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class F {
    public static void main(String[] args) throws IOException {
        FileReader read = new FileReader("input.txt");
        Scanner scan = new Scanner(read);
        String coreString = scan.nextLine();
        int wordsCount = Integer.parseInt(scan.nextLine());
        String strOut = "";
        for (int i = 0; i < wordsCount; i++){
            if (coreString.contains(scan.nextLine())){
                strOut += "1 ";
            }
            else{
                strOut += "0 ";
            }
        }
        read.close();
        FileWriter wr = new FileWriter("output.txt", false);
        wr.write(strOut);
        wr.close();
    }
}
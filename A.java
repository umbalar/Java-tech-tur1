package com.company;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        System.out.println("Ты кто?");
        Scanner s = new Scanner(System.in);
        System.out.println("Ты обязательно изучишь Java и сдашь все задачи на Отлично, " + s.next());
    }
}
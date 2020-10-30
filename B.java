package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;

public class B {
    public static void main(String[] args) {
        SimpleDateFormat formatedDate = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        System.out.println(formatedDate.format(new Date()));
    }
}

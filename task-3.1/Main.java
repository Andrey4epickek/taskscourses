package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int a = new Random().nextInt(899) + 100;
        System.out.println(a);

        System.out.println(Integer.toString(a).chars().max().getAsInt()-'0');
    }
}

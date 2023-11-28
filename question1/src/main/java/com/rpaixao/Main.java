package com.rpaixao;

public class Main {
    public static void main(String[] args) {
        //1) Write a console application in Java which counts from 1 to 20. If the number is divisible by 3, print “A”; if it is divisible by 5, print
        //“B”. If it is divisible by 3 and by 5, print “C”.
        for (int i = 1; i <= 20; i++) {
            //We must take in consideration that: 1- the question never told us to not print "A" and "B" when
            //the number is both divisible by 3 and 5.
            //2- the question never told us to print the number itself when its not divisible by either 3 or 5.
            if(i%3==0) System.out.print("A");
            if(i%5==0) System.out.print("B");
            if(i%15==0) System.out.print("C");
        }
    }
}
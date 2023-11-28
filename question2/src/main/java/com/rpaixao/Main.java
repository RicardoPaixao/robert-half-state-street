package com.rpaixao;


import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 2) Write a console application in Java which:
        //a) reads the standard input,
        //b) breaks the string read into an array,
        //c) prints the array in the format { el1, el2, el3 } to the standard output,
        //d) sorts the elements of the array and prints it using the same format used before,
        //e) prints the array as a single string.
        System.out.print("Type anything: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] inputArray = input.toCharArray();
        System.out.print("Original Array: ");
        System.out.println(replaceWrappingCharactersWithBracesAndSpaces(Arrays.toString(inputArray)));
        Arrays.sort(inputArray);
        System.out.print("Sorted Array : ");
        System.out.println(replaceWrappingCharactersWithBracesAndSpaces(Arrays.toString(inputArray)));
        String output = new String(inputArray);
        System.out.print("Final String : "+output);
    }

    public static String replaceWrappingCharactersWithBracesAndSpaces(String input){
        return "{ "+input.substring(1,input.length()-2)+"}";
    }
}
package hometasks.task2.solutions.chapter1;

import java.io.*;
import java.util.Scanner;

public class FPS1 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_int = in.nextInt();
        System.out.println("Number in binary: " + Integer.toBinaryString(test_int));
        System.out.println("Number in octal: " + Integer.toOctalString(test_int));
        System.out.println("Number in hexadecimal: " + Integer.toHexString(test_int));
        System.out.println("Number in hexadecimal floating-point number: " + Float.toHexString(test_int));
    }
}

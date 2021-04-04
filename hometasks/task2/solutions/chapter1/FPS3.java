package hometasks.task2.solutions.chapter1;

import java.io.*;
import java.util.Scanner;

public class FPS3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_int_1 = in.nextInt();
        int test_int_2 = in.nextInt();
        int test_int_3 = in.nextInt();
        System.out.println("Max with MathMax: " + Math.max(test_int_1, Math.max(test_int_2, test_int_3)));
    }
}

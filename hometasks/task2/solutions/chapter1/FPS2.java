package hometasks.task2.solutions.chapter1;

import java.io.*;
import java.util.Scanner;

public class FPS2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int test_int = in.nextInt();
        int out = test_int % 360;
        out =  (out < 0) ? (out + 360) : (out);
        System.out.println("With %: " + out);
        System.out.println("With floorMod: " + Math.floorMod(test_int, 360));
    }

}

package hometasks.task2.solutions.chapter1;

import java.math.BigInteger;
import java.util.Scanner;
import java.io.*;

public class FPS6 {

    static BigInteger factorial(int n){
        if (n > 0)
            return  BigInteger.valueOf(n).multiply(factorial(n - 1));
        return BigInteger.valueOf(1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 1000;
        System.out.println(factorial(n));

    }
}

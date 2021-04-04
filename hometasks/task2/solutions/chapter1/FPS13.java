package hometasks.task2.solutions.chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;

public class FPS13 {

    public static void main(String[] args) {
        ArrayList<Integer> NumLottery = new ArrayList<Integer>();
        for (int i = 1; i <= 49; i++){
            NumLottery.add(i);
        }
        ArrayList<Integer> Lottery = new ArrayList<Integer>();
        for (int i = 0; i < 6; i++){
            //System.out.println("dsadas");
            int next_num = (int) (Math.random() * (49 - i));
            Lottery.add(NumLottery.get(next_num));
            NumLottery.remove(next_num);
        }
        Collections.sort(Lottery);
        for (int a : Lottery)
            System.out.println(a);
    }
}

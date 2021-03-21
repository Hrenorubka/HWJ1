package hometasks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Workspace {
    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<Integer>();
        testList.add(1);
        testList.add(4);
        testList.add(8);
        int tmp = 5;
        ListIterator<Integer> testIterator = testList.listIterator(testList.size());
        int i = 0;
        while(testIterator.hasPrevious())
            System.out.println(testIterator.previous().toString() + " ");
    }
}

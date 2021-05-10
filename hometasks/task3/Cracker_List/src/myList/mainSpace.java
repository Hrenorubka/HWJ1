package myList;

import java.util.LinkedList;
import java.util.List;

public class mainSpace {

    private static long testJavaListAdd(Integer[] inp) {
        LinkedList<Integer> testJavaList = new LinkedList<>();
        long t = System.nanoTime();
        for (Integer a: inp) {
            testJavaList.add(a);
        }
        return System.nanoTime() - t;
    }

    private static long testMyListAdd(Integer[] inp) {
        MyLinkedList<Integer> testMyList = new MyLinkedList<>();
        long t = System.nanoTime();
        for (Integer a: inp) {
            testMyList.add(a);
        }
        return System.nanoTime() - t;
    }

    private static long testJavaListRemove(Integer[] inp) {
        LinkedList<Integer> testJavaList = new LinkedList<>();
        for (Integer a: inp) {
            testJavaList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testJavaList.remove(i);
        }
        return System.nanoTime() - t;
    }

    private static long testMyListRemove(Integer[] inp) {
        MyLinkedList<Integer> testMyList = new MyLinkedList<>();
        for (Integer a: inp) {
            testMyList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testMyList.remove(i);
        }
        return System.nanoTime() - t;
    }

    private static long testJavaListGet(Integer[] inp) {
        LinkedList<Integer> testJavaList = new LinkedList<>();
        for (Integer a: inp) {
            testJavaList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testJavaList.get(i);
        }
        return System.nanoTime() - t;
    }

    private static long testMyListGet(Integer[] inp) {
        MyLinkedList<Integer> testMyList = new MyLinkedList<>();
        for (Integer a: inp) {
            testMyList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testMyList.get(i);
        }
        return System.nanoTime() - t;
    }

    private static long testJavaListIndexOf(Integer[] inp) {
        LinkedList<Integer> testJavaList = new LinkedList<>();
        for (Integer a: inp) {
            testJavaList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testJavaList.indexOf(i);
        }
        return System.nanoTime() - t;
    }

    private static long testMyListIndexOf(Integer[] inp) {
        MyLinkedList<Integer> testMyList = new MyLinkedList<>();
        for (Integer a: inp) {
            testMyList.add(a);
        }
        long t = System.nanoTime();
        for (int i = inp.length - 1; i >= 0; i--) {
            testMyList.indexOf(i);
        }
        return System.nanoTime() - t;
    }

    public static void main(String[] args) {
        int n = 1000;
        Integer[] testMas = new Integer[n];
        for (int i = 0; i < n; i++) {
            testMas[i] = i;
        }
        System.out.println("ADD: ");
        System.out.println("JavaLinkedList: " + testJavaListAdd(testMas));
        System.out.println("MyLinkedList: " + testMyListAdd(testMas));

        System.out.println("REMOVE: ");
        System.out.println("JavaLinkedList: " + testJavaListRemove(testMas));
        System.out.println("MyLinkedList: " + testMyListRemove(testMas));


        System.out.println("GET");
        System.out.println("JavaLinkedList: " + testJavaListGet(testMas));
        System.out.println("MyLinkedList: " + testMyListGet(testMas));


        System.out.println("INDEXOF");
        System.out.println("JavaLinkedList: " + testJavaListIndexOf(testMas));
        System.out.println("MyLinkedList: " + testMyListIndexOf(testMas));

    }

}

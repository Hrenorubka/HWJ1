package timeTest;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class timeTestCollections {

    public static long getTimeAddOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            testCol.add((Integer) a[i]);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeRemoveOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for(int i = 0; i < size; i++) {
            testCol.add((Integer) a[i]);
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            testCol.remove(i);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeGetOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
            testCol.add((Integer) a[i]);
        }
        long t1 = System.nanoTime();
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * size);
            testCol.get(index);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeIndexOfOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
            testCol.add((Integer) a[i]);
        }
        long t1 = System.nanoTime();
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * size);
            testCol.indexOf(index);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeAddOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            testCol.add((Integer) a[i]);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeRemoveOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for(int i = 0; i < size; i++) {
            testCol.add((Integer) a[i]);
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            testCol.remove((Integer) a[i]);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeContainsOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
            testCol.add(a[i]);
        }
        long t1 = System.nanoTime();
        for (int i = 0; i < numActions; i++) {
            int elem = (int) (Math.random() * size);
            testCol.contains(elem);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeAddOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            testCol.put(i, (Integer) a[i]);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeRemoveOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for(int i = 0; i < size; i++) {
            testCol.put(i, (Integer) a[i]);
        }
        long t1 = System.nanoTime();
        for(int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * size);
            testCol.remove(index, (Integer) a[index]);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }

    public static long getTimeGetOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
            testCol.put(i, a[i]);
        }
        long t1 = System.nanoTime();
        for (int i = 0; i < numActions; i++) {
            int key = (int) (Math.random() * size);
            testCol.get(key);
        }
        long t2 = System.nanoTime();
        testCol.clear();
        return t2 - t1;
    }


}

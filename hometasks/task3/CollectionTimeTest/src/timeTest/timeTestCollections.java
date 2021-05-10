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
        for (int i = 0; i < (int)50_000; i++) {
            testCol.add((int) (Math.random() * i), a[i]);
        }
        for (int i = (int)50_000; i < size; i++) {
            testCol.add(a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for(int i = 0; i < numActions; i++) {
            t1 = System.nanoTime();
            testCol.add(i);
            t2 = System.nanoTime();
            sum += t2 - t1;
            testCol.remove(size);
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeRemoveOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for (int i = 0; i < (int)50_000; i++) {
            testCol.add((int) (Math.random() * i), a[i]);
        }
        for (int i = (int)50_000; i < size; i++) {
            testCol.add(a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for(int i = 0; i < numActions; i++) {
            t1 = System.nanoTime();
            testCol.remove(i);
            t2 = System.nanoTime();
            sum += t2 - t1;
            testCol.add(i);
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeGetOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for (int i = 0; i < (int)50_000; i++) {
            testCol.add((int) (Math.random() * i), a[i]);
        }
        for (int i = (int)50_000; i < size; i++) {
            testCol.add(a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * size);
            t1 = System.nanoTime();
            testCol.get(index);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeIndexOfOperationList(List<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = i;
        }
        for (int i = 0; i < (int)50_000; i++) {
            testCol.add((int) (Math.random() * i), a[i]);
        }
        for (int i = (int)5e4; i < size; i++) {
            testCol.add(a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            int index = (int) (Math.random() * size);
            t1 = System.nanoTime();
            testCol.indexOf(index);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeAddOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        long t1;
        long sum = 0;
        long t2;
        for(int i = 0; i < numActions; i++) {
            t1 = System.nanoTime();
            testCol.add(-1);
            t2 = System.nanoTime();
            testCol.remove(-1);
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeRemoveOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        long t1;
        long sum = 0;
        long t2;
        for(int i = 0; i < numActions; i++) {
            testCol.add(-1);
            t1 = System.nanoTime();
            testCol.remove(-1);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeContainsOperationSet(Set<Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
            testCol.add(a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            int elem = (int) (Math.random() * size);
            t1 = System.nanoTime();
            testCol.contains(elem);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeAddOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        for(int i = 0; i < size; i++) {
            testCol.put(i, (Integer) a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            t1 = System.nanoTime();
            testCol.put(-1, i);
            t2 = System.nanoTime();
            sum += t2 - t1;
            testCol.remove(-1);
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeRemoveOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
        }
        for(int i = 0; i < size; i++) {
            testCol.put(i, (Integer) a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            testCol.put(-1, i);
            t1 = System.nanoTime();
            testCol.remove(-1);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }

    public static long getTimeGetOperationMap(Map<Integer, Integer> testCol, int size, int numActions) {
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = (int) (Math.random() * size);
            testCol.put(i, a[i]);
        }
        long t1;
        long sum = 0;
        long t2;
        for (int i = 0; i < numActions; i++) {
            int key = (int) (Math.random() * size);
            t1 = System.nanoTime();
            testCol.get(key);
            t2 = System.nanoTime();
            sum += t2 - t1;
        }
        testCol.clear();
        return sum / numActions;
    }


}

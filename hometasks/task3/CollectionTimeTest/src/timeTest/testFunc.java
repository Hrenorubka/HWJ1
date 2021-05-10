package timeTest;

import java.util.*;

public class testFunc {
    public static void main(String[] args) {
        int n = 1_000_000;
        int act = 10_000;
        ArrayList<Integer> testArrayList = new ArrayList<>();
        LinkedList<Integer> testLinkedList = new LinkedList<>();

        HashSet<Integer> testHashSet = new HashSet<>();
        LinkedHashSet<Integer> testLinkedHashSet = new LinkedHashSet<>();
        TreeSet<Integer> testTreeSet = new TreeSet<>();

        HashMap<Integer, Integer> testHashMap = new HashMap();
        LinkedHashMap<Integer, Integer> testLinkedHashMap = new LinkedHashMap<>();
        TreeMap<Integer, Integer> testTreeMap = new TreeMap<>();

       for(int i = 50_000; i <= n; i += 50_000) {
           System.out.println("ADD " + i + " actions");
           System.out.println("Map: ");
           System.out.println(testHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeAddOperationMap(testHashMap, i, act) + " ns");
           System.out.println(testTreeMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeAddOperationMap(testTreeMap, i, act) + " ns");
           System.out.println(testLinkedHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeAddOperationMap(testLinkedHashMap, i, act) + " ns");

           System.out.println("REMOVE "  + i + " actions");
           System.out.println("Map: ");
           System.out.println(testHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeRemoveOperationMap(testHashMap, i, act) + " ns");
           System.out.println(testTreeMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeRemoveOperationMap(testTreeMap, i, act) + " ns");
           System.out.println(testLinkedHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeRemoveOperationMap(testLinkedHashMap, i, act) + " ns");

           System.out.println("GET "  + i + " actions");
           System.out.println("Map: ");
           System.out.println(testHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeGetOperationMap(testHashMap, i, act) + " ns");
           System.out.println(testTreeMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeGetOperationMap(testTreeMap, i, act) + " ns");
           System.out.println(testLinkedHashMap.getClass().toString() + ": "
                   + timeTestCollections.getTimeGetOperationMap(testLinkedHashMap, i, act) + " ns");
       }
        /*
        System.out.println("ADD " + i + " size");

            System.out.println("List: ");
            System.out.println(testArrayList.getClass().toString() + ": "
                    + timeTestCollections.getTimeAddOperationList(testArrayList, i, act) + " ns");
            System.out.println(testLinkedList.getClass().toString() + ": "
                    + timeTestCollections.getTimeAddOperationList(testLinkedList, i, act) + " ns");

            System.out.println("REMOVE "  + i + " actions");

            System.out.println("List: ");
            System.out.println(testArrayList.getClass().toString() + ": "
                    + timeTestCollections.getTimeRemoveOperationList(testArrayList, i, act) + " ns");
            System.out.println(testLinkedList.getClass().toString() + ": "
                    + timeTestCollections.getTimeRemoveOperationList(testLinkedList, i, act) + " ns");

            System.out.println("GET "  + i + " actions");

            System.out.println("List: ");
            System.out.println(testArrayList.getClass().toString() + ": "
                    + timeTestCollections.getTimeGetOperationList(testArrayList, i, act) + " ns");
            System.out.println(testLinkedList.getClass().toString() + ": "
                    + timeTestCollections.getTimeGetOperationList(testLinkedList, i, act) + " ns");

        System.out.println("Set: ");
        System.out.println(testHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationSet(testHashSet, n, act) + " ns");
        System.out.println(testLinkedHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationSet(testLinkedHashSet, n, act) + " ns");
        System.out.println(testTreeSet.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationSet(testTreeSet, n, act) + " ns");

        System.out.println("Map: ");
        System.out.println(testHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationMap(testHashMap, n, act) + " ns");
        System.out.println(testTreeMap.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationMap(testTreeMap, n, act) + " ns");
        System.out.println(testLinkedHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeAddOperationMap(testLinkedHashMap, n, act) + " ns");

        System.out.println("REMOVE "  + act + " actions");

        System.out.println("List: ");
        System.out.println(testArrayList.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationList(testArrayList, n, act) + " ns");
        System.out.println(testLinkedList.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationList(testLinkedList, n, act) + " ns");

        System.out.println("Set: ");
        System.out.println(testHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationSet(testHashSet, n, act) + " ns");
        System.out.println(testLinkedHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationSet(testLinkedHashSet, n, act) + " ns");
        System.out.println(testTreeSet.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationSet(testTreeSet, n, act) + " ns");

        System.out.println("Map: ");
        System.out.println(testHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationMap(testHashMap, n, act) + " ns");
        System.out.println(testTreeMap.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationMap(testTreeMap, n, act) + " ns");
        System.out.println(testLinkedHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeRemoveOperationMap(testLinkedHashMap, n, act) + " ns");

        System.out.println("GET "  + act + " actions");

        System.out.println("List: ");
        System.out.println(testArrayList.getClass().toString() + ": "
                + timeTestCollections.getTimeGetOperationList(testArrayList, n, act) + " ns");
        System.out.println(testLinkedList.getClass().toString() + ": "
                + timeTestCollections.getTimeGetOperationList(testLinkedList, n, act) + " ns");

        System.out.println("Set: ");
        System.out.println(testHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeContainsOperationSet(testHashSet, n, act) + " ns");
        System.out.println(testLinkedHashSet.getClass().toString() + ": "
                + timeTestCollections.getTimeContainsOperationSet(testLinkedHashSet, n, act) + " ns");
        System.out.println(testTreeSet.getClass().toString() + ": "
                + timeTestCollections.getTimeContainsOperationSet(testTreeSet, n, act) + " ns");

        System.out.println("Map: ");
        System.out.println(testHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeGetOperationMap(testHashMap, n, act) + " ns");
        System.out.println(testTreeMap.getClass().toString() + ": "
                + timeTestCollections.getTimeGetOperationMap(testTreeMap, n, act) + " ns");
        System.out.println(testLinkedHashMap.getClass().toString() + ": "
                + timeTestCollections.getTimeGetOperationMap(testLinkedHashMap, n, act) + " ns");

         */
    }
}

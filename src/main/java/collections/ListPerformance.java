package collections;

import java.util.ArrayList;
import java.util.LinkedList;

class ListPerformance {

    private ArrayList<Integer> arrayList;
    private LinkedList<Integer> linkedList;
    private long startTime;

    ListPerformance() {
        arrayList = new ArrayList<>();
        linkedList = new LinkedList<>();
        startTime = System.nanoTime();
    }

    long arrayListAddDuration() {
        for (int i = 0; i < 10000; i++) arrayList.add(i);
        return duration(System.nanoTime());
    }

    long linkedListAddDuration() {
        for (int i = 0; i < 10000; i++) linkedList.add(i);
        return duration(System.nanoTime());
    }

    long arrayListGetDuration() {
        for (int i = 0; i < 10000; i++) arrayList.get(i);
        return duration(System.nanoTime());
    }

    long linkedListGetDuration() {
        for (int i = 0; i < 10000; i++) linkedList.get(i);
        return duration(System.nanoTime());
    }


    long arrayListRemoveDuration() {
        arrayList.subList(0, 10000).clear();
        return duration(System.nanoTime());
    }


    long linkedListRemoveDuration() {
        linkedList.subList(0, 10000).clear();
        return duration(System.nanoTime());
    }

    long duration(long endTime) {
        return endTime - startTime;
    }
}

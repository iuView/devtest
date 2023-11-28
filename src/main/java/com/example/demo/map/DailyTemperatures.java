package com.example.demo.map;

import java.util.*;

/**
 * https://leetcode.com/problems/daily-temperatures/description/
 * this should have been done in PriorityQueues (heaps)
 */
public class DailyTemperatures {
    TreeMap<Integer, EntryOfArray> map = new TreeMap<>();

    public int[] dailyTemperatures(int[] temperatures) {
        int[] retval = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            EntryOfArray indexes = map.get(temperatures[i]);

            if (indexes == null)
                indexes = new EntryOfArray(temperatures[i], Arrays.asList(i));
            indexes.indexes.add(i); // adding the index where this temperature occurred.
            map.put(temperatures[i], indexes);
        }

        for (int i = 0; i < temperatures.length; i++) {
            int temperature = temperatures[i];
            int space = findNextTemp(temperature, i);
            if (space == -1) {
                retval[i] = 0;
            } else
                retval[i] = space;
        }

        return retval;
    }

    private int findNextTemp(int temp, int myindex) {
        if (temp == 100)
            return -1;

        Map.Entry<Integer, List<Integer>> entry = null;

        int lookingt = temp + 1;
        int spaceval = Integer.MAX_VALUE; // the value that is between myindex and the index, set it to outside the range
        while (lookingt <= 100) {
            Map.Entry<Integer, EntryOfArray> entryOfArrayEntry = map.ceilingEntry(lookingt);
            if (entryOfArrayEntry == null) {
                // the end has reached
                break;
            } else {
                // compare the index values
                EntryOfArray val = entryOfArrayEntry.getValue();
                Set<Integer> indx = val.indexes;
                Iterator<Integer> iterator = indx.iterator();
                while (iterator.hasNext()) {
                    int newval = iterator.next();
                    if (newval > myindex) { // found some values
                        if (newval - myindex < spaceval) {
                            spaceval = newval - myindex;
                        }
                    }
                }
                lookingt = lookingt + 1;
            }
        }
        if (spaceval < Integer.MAX_VALUE)
            return spaceval;
        else
            return -1;
    }
}

class EntryOfArray {
    Integer temptr;
    TreeSet<Integer> indexes = new TreeSet<>();

    EntryOfArray(int temptr, List<Integer> indexes) {
        this.temptr = temptr;
        this.indexes.addAll(indexes);
    }

    @Override
    public String toString() {
        return "EntryOfArray{" +
                "temptr=" + temptr +
                ", indexes=" + indexes +
                '}';
    }
}

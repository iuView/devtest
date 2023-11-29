package com.example.demo.map;

import java.util.*;

/**
 * <a href="https://leetcode.com/problems/daily-temperatures/description/">...</a>
 * this should have been done in PriorityQueues (heaps)
 */
public class DailyTemperatures {
    TreeMap<Integer, Integer> map = new TreeMap<>(); // temp and index map

    public int[] dailyTemperatures(int[] temperatures) {
        int[] retval = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            // always just use the last index (the left-most)
            map.put(temperatures[temperatures.length - i - 1], temperatures.length - i - 1);
            int space = findNextTemp(temperatures[temperatures.length - i - 1], temperatures.length - i - 1);
            if (space == -1) {
                retval[temperatures.length - i - 1] = 0;
            } else
                retval[temperatures.length - i - 1] = space;
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
            Map.Entry<Integer, Integer> entryOfArrayEntry = map.ceilingEntry(lookingt);
            if (entryOfArrayEntry == null) {
                // the end has reached
                break;
            } else {
                // compare the index values
                int newval = entryOfArrayEntry.getValue();
                if (newval > myindex) { // found some values
                    if (newval - myindex < spaceval) {
                        spaceval = newval - myindex;
                    }
                }
            }
            lookingt = lookingt + 1;
        }
        if (spaceval < Integer.MAX_VALUE)
            return spaceval;
        else
            return -1;
    }
}


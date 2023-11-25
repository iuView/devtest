package com.example.demo.heap;

import java.util.*;
import java.util.stream.Collectors;

public class RelativeRank {
    public String[] findRelativeRanks(int[] score) {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(score.length, comparator);
        priorityQueue.addAll(Arrays.stream(score).mapToObj(x -> x).collect(Collectors.toList()));
        // get the top 3 scores:
        int firstp = -1;
        int secondp = -1;
        int thirdp = -1;
        Map<Integer, Integer> map = new HashMap<>();
        int p = 4;

        while (!priorityQueue.isEmpty()) {
            int val = priorityQueue.poll();
            if (firstp == -1) {
                firstp = val;
                map.put(val, 1);
            } else if (secondp == -1) {
                secondp = val;
                map.put(val, 2);
            } else if (thirdp == -1) {
                thirdp = val;
                map.put(val, 3);
            } else {
                map.put(val, p);
                p++;
            }
        }

//        The 1st place athlete's rank is "Gold Medal".
//        The 2nd place athlete's rank is "Silver Medal".
//        The 3rd place athlete's rank is "Bronze Medal".
        String[] retval = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int pl = map.get(score[i]);
            if (pl == 1) {
                retval[i] = "Gold Medal";
            } else if (pl == 2) {
                retval[i] = "Silver Medal";
            } else if (pl == 3) {
                retval[i] = "Bronze Medal";
            } else {
                retval[i] = pl + "";
            }
        }
        return retval;
    }
}

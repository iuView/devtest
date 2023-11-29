package com.example.demo.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/">leetcode</a>
 */
public class StockSpanner {
    int currentposition = 0;

    // need a hashmap to remember when the last time certain price occurred
    // also it should sort the map key, so the search time is log(n) time
    TreeMap<Integer, Set<Integer>> map = new TreeMap<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int retval = 1; // at least one
        // now find:
        int newprice = price + 1;
        int space = Integer.MIN_VALUE;
        Map<Integer, Set<Integer>> submap = map.headMap(newprice);
        // need to make sure the values are continuous
        if (!submap.isEmpty()) {
            // need to combine all the numbers in set:
            Comparator<? super Integer> comparator = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1.compareTo(o2);
                }
            };
            List<Integer> allvals = submap.values().stream().flatMap(Set::stream).sorted(comparator).collect(Collectors.toList());
            Iterator<Integer> iterator = allvals.iterator();
            // need to find the continues ones, starting from the largest index

            int minindex = allvals.stream().findFirst().get();
            int i = currentposition - 1;
            for (; i >= minindex; i--) {
                if (allvals.contains(i)) {
                    continue;
                } else {
                    break;
                }
            }
            space = currentposition - 1 - i;
        }

        if (space >= 1)
            retval += space;

        // but need to exclude the position that is larger than price
        // tail map and head map may give some clues

        // adding this data point:
        Set<Integer> indexes = map.get(price);
        if (indexes == null)
            indexes = new HashSet<>();
        indexes.add(currentposition);
        map.put(price, indexes); // the index of it
        currentposition++;
        // end adding this data point

        return retval;
    }
}

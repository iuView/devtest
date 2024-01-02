package com.example.demo.permutation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href="https://leetcode.com/problems/combinations/description/">leetcode problem</a>
 */
public class Combination {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> retval = new ArrayList<>();


        Set<Integer> numbers = IntStream.range(1, n + 1).mapToObj(x -> x).collect(Collectors.toSet());

        int iterCounter = n - k;

        while (iterCounter >= 0) {
            List<List<Integer>> temp = new ArrayList<>();
            retval.addAll(addToList(temp, numbers, k));

            iterCounter--;
            if (iterCounter >= 0) {
                numbers.remove(k - iterCounter);
            }
        }
        return retval;
    }

    private List<List<Integer>> addToList(List<List<Integer>> list, Set<Integer> numbers, int k) {
        if (k == 1) {
            // add each of the items in numbers into the list
            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                list.add(Arrays.asList(iterator.next()));
            }
            return list;
        }

        Iterator<Integer> iterator = numbers.iterator();
        if (iterator.hasNext()) {
            Integer item = iterator.next();

            numbers.remove(item);

            list = addToList(list, numbers, k - 1);

            List<List<Integer>> newList = new ArrayList<>();
            // for each of the returned, add this item to it
            for (int i = 0; i < list.size(); i++) {
                List<Integer> items = list.get(i);
                List<Integer> newitems = new ArrayList<>();
                newitems.addAll(items);
                newitems.add(item);
                newList.add(newitems);
            }
            return newList;
        }

        return list;
    }
}

package com.example.demo.map;

import org.hibernate.boot.model.source.internal.hbm.AttributesHelper;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/">leetcode</a>
 * looks like the TreeMap approach is not the best,
 * should use a stack to pop things off the list. it is quite better than this.
 * will have to work on it next. will get rid of most of the code.
 * second problem: when the input is crazy, with a lot of items, a lot of duplicates etc
 * this will time limit.
 * finally got it working with a simple trick of keeping min and max.
 */
public class StockSpanner {
    Deque<Integer> stack = new LinkedList<>();

    // keep a note of min and max of the whole thing, at least we can speed up a few edge cases
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    public StockSpanner() {

    }

    public int next(int price) {
        int retval = 1; // at least one
        int space = 0;

        // there is no need to compare if it is larger or equal to max
        if (price >= max) {
            // space is the size of the entire stack
            space = stack.size();
        } else if (price < min) {
            space = 0;
        } else {
            Deque<Integer> storestack = new LinkedList<>();
            while (!stack.isEmpty()) {

                int item = stack.pop();
                if (item > price) {
                    // the end of the search
                    storestack.push(item);
                    break;
                } else {
                    space++;
                }
                storestack.push(item);
            }

            // put back the items
            while (!storestack.isEmpty()) {
                stack.push(storestack.pop());
            }
        }

        // push the price on it
        stack.push(price);
        if (price < min)
            min = price;
        if (price > max)
            max = price;
        return retval + space;
    }

}

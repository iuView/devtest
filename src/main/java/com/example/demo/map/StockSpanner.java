package com.example.demo.map;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <a href="https://leetcode.com/problems/online-stock-span/">leetcode</a>
 * looks like the TreeMap approach is not the best,
 * should use a stack to pop things off the list. it is quite better than this.
 * will have to work on it next. will get rid of most of the code
 */
public class StockSpanner {
    Deque<Integer> stack = new LinkedList<>();

    public StockSpanner() {

    }

    public int next(int price) {
        int retval = 1; // at least one
        int space = 0;
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

        // push the price on it
        stack.push(price);
        return retval + space;
    }

}

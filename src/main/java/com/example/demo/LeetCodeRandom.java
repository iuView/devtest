package com.example.demo;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.util.*;

/**
 * sick and tired of creating single classes
 */
public class LeetCodeRandom {

    // here is another thing I don't know where to put, from leetcode

    /**
     * <a href="https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/">question</a>
     * the core of this problem is to understand what the hell is prime factors of a number
     * by the time I am done with all leetcode all the grade school math would be relearned
     *
     * @param n
     * @return
     */
    public int smallestValue(int n) {

        if (n == 4)
            return 4;

        List<Integer> nums = new ArrayList<>();

        // starting from 2 to the number itself
        int nextPrime = 1;
        int startnum = n;
        while (startnum > 1) {
            nextPrime = getNextPrime(startnum);
            startnum = startnum / nextPrime;
            nums.add(nextPrime);
        }

        // call smallestValue again with nums sum together
        // check end condition in order to exit the recursion
        if (nums.size() == 1)
            return nums.get(0);
        else
            return smallestValue(nums.stream().mapToInt(x -> x).sum());

    }

    private int getNextPrime(int n) {
        // this only returns the first prime
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * another tricky problem that could have an impact on your problem solving skills:
     * the unit test has the specs
     * so basically give me a true or false answer based on if any of two numbers in the
     * array has this logic:
     * a^2 + b^2 = c^2
     *
     * @param listOfInts
     * @return
     */
    public boolean giveMeTheSquares(int[] listOfInts) {
        boolean retval = false;
        // first square everything:
        List<Integer> sqvals = preProcess(listOfInts);

        for (int i = 0; i < sqvals.size(); i++) {
            int val = sqvals.get(i);
            int start = i + 1;
            int end = sqvals.size() - 1;

            retval = findIt(sqvals, val, start, end);
            if (retval)
                return true;
        }

        return retval;
    }

    // find two numbers that add up equal to 'val', start and end are inclusive indexes
    // list is sorted descending
    // all are positive numbers
    // this sounds like a leetcode question https://leetcode.com/problems/sum-of-square-numbers/description/
    boolean findIt(List<Integer> list, int val, int start, int end) {
        boolean retval = false;
        if (start >= end)
            return false;
        // todo:
        return retval;
    }

    private List<Integer> preProcess(int[] listOfInts) {
        List<Integer> retval = new ArrayList<>(listOfInts.length);
        for (int i = 0; i < listOfInts.length; i++) {
            retval.add((int) Math.pow(listOfInts[i], 2));
        }
        Comparator<? super Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        };
        Collections.sort(retval, comparator);
        System.out.println(retval.toString());
        return retval;
    }


    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(asteroids[0]);
        int index = 1; // the next index
        boolean hadColission = false;
        while (!stack.isEmpty() || index <= asteroids.length - 1) {
            if (stack.isEmpty()) {
                stack.push(asteroids[index]);
                index++;
            }
            if (index <= asteroids.length - 1) {
                int item = stack.pop();
                System.out.println("checking " + item);
                int val = asteroids[index];
                if ((item > 0 && val > 0) || (item < 0 && val < 0)) {
                    // same direction
                    stack.push(item);
                    stack.push(val);
                } else if ((item < 0 && val > 0)) {
                    stack.push(item);
                    stack.push(val);
                } else {
                    hadColission = true;
                    if (Math.abs(item) > Math.abs(val)) {
                        stack.push(item);
                    } else if (Math.abs(item) == Math.abs(val)) {
                        ; // don't do anything
                    } else {
                        stack.push(val);
                    }
                }
                index++;
                System.out.println("interim stack: " + stack.toString());
            } else { // need to work on the stack itself:
                if (!hadColission)
                    break;
                return asteroidCollision(getInts(stack));

            }

        }

        System.out.println(stack.toString());

        // what is on the stack are the values:
        int[] retval = getInts(stack);
        return retval;
    }

    private static int[] getInts(Deque<Integer> stack) {
        int[] retval = new int[stack.size()];
        int sizeOfArray = stack.size();
        for (int i = sizeOfArray - 1; i >= 0; i--) {
            retval[i] = stack.pop();
        }
        return retval;
    }


}

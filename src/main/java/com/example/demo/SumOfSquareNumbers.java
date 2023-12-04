package com.example.demo;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 */
public class SumOfSquareNumbers {
    public boolean judgeSquareSum(int c) {
        boolean retval = false;
        int csqrt = (int) Math.sqrt(c);

        System.out.printf("squireroot of %d is: %f and %d\n", c, Math.sqrt(c), csqrt);

        int end = csqrt;
        int start = 0;
        while (start <= end) {
            if (Math.pow(start, 2) + Math.pow(end, 2) == c) {
                return true;
            } else {
                start = start + 1;
            }
        }
        return retval;
    }
}

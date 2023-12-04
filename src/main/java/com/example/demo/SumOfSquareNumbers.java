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
            boolean innerreturn = innerLoop(c, start, end);
            if (!innerreturn) {
                start = start + 1;
                end = end - 1;
            } else {
                return true;
            }
        }

        return retval;
    }

    private static boolean innerLoop(int c, int start, int end) {
        while (start <= end) {
            if (Math.pow(start, 2) + Math.pow(end, 2) == c) {
                return true;
            } else {
                start = start + 1;
            }
        }

        // going backwards:
        start = 1;
        while (start <= end) {
            if (Math.pow(start, 2) + Math.pow(end, 2) == c) {
                return true;
            } else {
                end = end - 1;
            }
        }
        return false;
    }
}

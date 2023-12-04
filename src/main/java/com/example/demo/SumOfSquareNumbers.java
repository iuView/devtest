package com.example.demo;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/sum-of-square-numbers/description/
 * to fix the TLE problem that eventually will show up in this,
 * need to memorize the pow(x,2) values in a hashtable.
 */
public class SumOfSquareNumbers {
    Map<Integer, BigInteger> squareMap = new HashMap<>();

    public boolean judgeSquareSum(int c) {
        int csqrt = (int) Math.sqrt(c);

        int end = csqrt;
        int start = 0;

        boolean innerreturn = innerLoop(BigInteger.valueOf(c), start, end);


        return innerreturn;
    }

    private boolean innerLoop(BigInteger c, int start, int end) {
        while (start <= end) {
            Result result = getResult(start, end);
            BigInteger val = result.val().add(result.val2());
            if (val.compareTo(c) == 0) {
                return true;
            } else if (val.compareTo(c) < 0) { // val less than c
                //System.out.printf("val is: %d, c is: %d, start: %d, end: %d, increasing start by 1\n", val, c, start, end);
                start = start + 1;
            } else { // val larger than c
                end = end - 1;
                //break;
            }
        }

        return false;
    }

    private Result getResult(int start, int end) {
        BigInteger val = squareMap.computeIfAbsent(start, s -> BigInteger.valueOf((long) Math.pow(s, 2)));
        BigInteger val2 = start == end ? val : null;
        if (val2 == null) {
            val2 = squareMap.computeIfAbsent(end, e -> BigInteger.valueOf((long) Math.pow(e, 2)));
        }
        Result result = new Result(val, val2);
        return result;
    }

    private record Result(BigInteger val, BigInteger val2) {
    }
}

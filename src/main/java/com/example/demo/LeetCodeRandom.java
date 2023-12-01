package com.example.demo;

import java.util.Deque;
import java.util.LinkedList;

/**
 * sick and tired of creating single classes
 */
public class LeetCodeRandom {
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
//                int item = stack.pop();
//
//                if (stack.isEmpty()) {
//                    stack.push(item);
//                } else {
//                    int val = stack.peek();
//                    if ((item > 0 && val > 0) || (item < 0 && val < 0)) {
//                        // same direction
//                        stack.push(item);
//                    } else if ((item > 0 && val < 0)) {
//                        stack.push(item);
//                    } else {
//                        if (Math.abs(item) > Math.abs(val)) {
//                            stack.pop();
//                            stack.push(item);
//                        } else if (Math.abs(item) == Math.abs(val)) {
//                            stack.pop();
//                        } else {
//                            ;
//                        }
//                    }
//                }
//
//                break;
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

package com.javatrain;

import java.util.Arrays;
import java.util.Random;

public class ArrayLesson {

    public static void main(String[] args) {
        int[] input = getRandomArray();
        ArrayLesson arrayLesson = new ArrayLesson();
        int[] aftersort = arrayLesson.sortArray(input);
        System.out.println(Arrays.toString(aftersort));
    }

    public int[] sortArray(int[] input) {
        int[] retval = new int[input.length];
        Arrays.sort(input);
        int i = input.length - 1;
        for (Integer integer : input) {
            retval[i] = integer;
            i--;
        }
        return retval;
    }

    private static int[] getRandomArray() {
        Random random = new Random();
        int[] retval = random.ints(10, 0, 100).toArray(); // 10 random ints
        System.out.println(Arrays.toString(retval));
        return retval;
    }
}

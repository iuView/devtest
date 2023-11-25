package com.javatrain;

import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {

    public static int[] getIntegers(int size) {
        int[] retval = new int[size];
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (i < size) {
            System.out.println("next int: ");
            retval[i] = scanner.nextInt();
            i++;
        }
        return retval;
    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("Element %d contents %d%n", i, array[i]);
        }
    }

    public static int[] sortIntegers(int[] unsorted) {
        Arrays.sort(unsorted);
        int[] sorted = new int[unsorted.length];
        for (int i = 0; i < unsorted.length; i++) {
            sorted[i] = unsorted[unsorted.length - i - 1];
        }
        return sorted;
    }
}

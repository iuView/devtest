package com.javatrain;

import java.util.Scanner;

public class MinimumElement {
    private static int readInteger() {
        System.out.println("Enter a integer:");
        Scanner scanner = new Scanner(System.in);

        int retval = scanner.nextInt();

        return retval;
    }

    private static int[] readElements(int size) {
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

    private static int findMin(int[] ints) {
        int min = Integer.MAX_VALUE;

        for (int el : ints) {
            if (min > el) {
                min = el;
            }
        }
        return min;
    }
}

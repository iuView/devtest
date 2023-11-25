package com.javatrain;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayTest {

    @Test
    void getIntegers() {
        SortedArray.getIntegers(2);
    }

    @Test
    void printArray() {
    }

    @Test
    void sortIntegers() {
    }

    @Test
    public void testScanner() {
        String input = "Hello World";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String actualInput = scanner.nextLine();
        assertEquals(input, actualInput);
    }
}

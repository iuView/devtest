package com.javatrain;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayTest {

    @Test
    @Disabled
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
    @Disabled
    public void testScanner() {
        String input = "Hello World";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        String actualInput = scanner.nextLine();
        assertEquals(input, actualInput);
    }
}

package com.example.demo;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class UtilsTest {

    Utils utils = new Utils();

    @Test
    void getFirstFromList() {
        List<String> input = new ArrayList<>();
        input.add("astring");
        input.add("alongerstring");
        input.add("alONGERString");

        String val = utils.getFirstFromList(input);
        String expected = "alongerstring";
        assertEquals(expected, val);
    }

    @Test
    void getFromList() {
        List<String> input = new ArrayList<>();
        input.add("astring");
        input.add("alongerstring");
        input.add("alONGERString");

        String val = utils.getFromList(input);
        String expected = input.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()).stream().findFirst().orElse("");
        assertEquals(expected, val);
    }

    @Test
    void readFile() {

        try {
            List<Integer> data = utils.readFile();
            assertThat(data).isNotEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void writeFile() {
        utils.writeDataToFile();
    }

    @Test
    void readMoreFile() {
        try {
            List<Integer> data = utils.readMoreFile();
            assertThat(data).isNotEmpty();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void testTreeSet() {
        utils.addNumberToTreeSet();
    }

    @Test
    void isTidy() {
        assertThat(utils.isTidy(123)).isTrue();
        assertThat(utils.isTidy(321)).isFalse();
        assertThat(utils.isTidy(2)).isTrue();
        assertThat(utils.isTidy(333)).isTrue();
        assertThat(utils.isTidy(893237)).isFalse();
    }
}
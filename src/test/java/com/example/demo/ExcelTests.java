package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

public class ExcelTests {
    Excel excel = new Excel();

    @Test
    void testConvertIntToChar() {
        int inval = 1;
        String val = excel.convertIntToChar(inval);

        String expectedString = "A";
        assertEquals(expectedString, val);

    }

    @Test
    void testConvertToTitle() {

    }

    @Test
    void testCreateInitialSeq() {
        List<String> expected = new ArrayList<>();

        for (int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            expected.add("" + c);
        }

        List<String> vals = excel.createInitialSeq();

        assertLinesMatch(expected, vals);
    }

    @Test
    void testGetColumnTitles() {
        int seq = 1;
        List<String> vals = excel.getColumnTitles(seq);
        assertEquals(vals.get(0), "AA");
        assertEquals(vals.get(1), "AB");
        assertEquals(vals.get(2), "AC");

        seq = 2;
        vals = excel.getColumnTitles(seq);
        assertEquals(vals.get(0), "BA");
        assertEquals(vals.get(1), "BB");
        assertEquals(vals.get(2), "BC");
    }

    @Test
    void testGetWantedColumnsCount() {

    }
}

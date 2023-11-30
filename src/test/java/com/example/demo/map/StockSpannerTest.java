package com.example.demo.map;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class StockSpannerTest {


    @Test
    void next() {
        StockSpanner stockSpanner = new StockSpanner();
        int result = stockSpanner.next(100); // return 1
        assertThat(result).isEqualTo(1);
        result = stockSpanner.next(80);  // return 1
        assertThat(result).isEqualTo(1);
        result = stockSpanner.next(60);  // return 1
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(70);  // return 2
        assertThat(result).isEqualTo(2);

        result = stockSpanner.next(60);  // return 1
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(75);  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        assertThat(result).isEqualTo(4);

        result = stockSpanner.next(85);  // return 6
        assertThat(result).isEqualTo(6);

    }

    @Test
    void next2() {
        StockSpanner stockSpanner = new StockSpanner();
        int result = stockSpanner.next(73);
        assertThat(result).isEqualTo(1);
        result = stockSpanner.next(97);
        assertThat(result).isEqualTo(2);
        result = stockSpanner.next(35);
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(45);
        assertThat(result).isEqualTo(2);

        result = stockSpanner.next(73);
        assertThat(result).isEqualTo(3);

        result = stockSpanner.next(66);
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(27);
        assertThat(result).isEqualTo(1);

        // continue
        result = stockSpanner.next(68);
        assertThat(result).isEqualTo(3);
        result = stockSpanner.next(31);
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(36);
        assertThat(result).isEqualTo(2);

        result = stockSpanner.next(54);
        assertThat(result).isEqualTo(3);

        result = stockSpanner.next(74);
        assertThat(result).isEqualTo(10);

        result = stockSpanner.next(16);
        assertThat(result).isEqualTo(1);

        // last set
        result = stockSpanner.next(3);
        assertThat(result).isEqualTo(1);
        result = stockSpanner.next(63);
        assertThat(result).isEqualTo(3);
        result = stockSpanner.next(3);
        assertThat(result).isEqualTo(1);

        result = stockSpanner.next(5);
        assertThat(result).isEqualTo(2);

        result = stockSpanner.next(23);
        assertThat(result).isEqualTo(3);

        result = stockSpanner.next(66);
        assertThat(result).isEqualTo(7);
        result = stockSpanner.next(7);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void nextWorstCase() {
        // the numbers are all increasing.
        // when this happens there is an inefficiency shows up
        StockSpanner stockSpanner = new StockSpanner();
        int result = stockSpanner.next(10); // return 1
        assertThat(result).isEqualTo(1);
        result = stockSpanner.next(20);  // return 2
        assertThat(result).isEqualTo(2);
        result = stockSpanner.next(30);
        assertThat(result).isEqualTo(3);

        result = stockSpanner.next(40);
        assertThat(result).isEqualTo(4);

        result = stockSpanner.next(50);
        assertThat(result).isEqualTo(5);

        result = stockSpanner.next(60);
        assertThat(result).isEqualTo(6);

        result = stockSpanner.next(70);
        assertThat(result).isEqualTo(7);

    }
}
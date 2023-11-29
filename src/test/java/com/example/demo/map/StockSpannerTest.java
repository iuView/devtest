package com.example.demo.map;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

class StockSpannerTest {

    StockSpanner stockSpanner = new StockSpanner();
    
    @Test
    void next() {
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
}
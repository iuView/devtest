package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SumOfSquareNumbersTest {

    @Test
    void judgeSquareSum() {
        SumOfSquareNumbers sumOfSquareNumbers = new SumOfSquareNumbers();
        boolean result = sumOfSquareNumbers.judgeSquareSum(4);
        assertThat(result).isTrue();

        // also accept the same number used twice:
        result = sumOfSquareNumbers.judgeSquareSum(2);
        assertThat(result).isTrue();

        result = sumOfSquareNumbers.judgeSquareSum(5);
        assertThat(result).isTrue();

        result = sumOfSquareNumbers.judgeSquareSum(3);
        assertThat(result).isFalse();

        result = sumOfSquareNumbers.judgeSquareSum(8);
        assertThat(result).isTrue();

        result = sumOfSquareNumbers.judgeSquareSum(1000);
        assertThat(result).isTrue();
    }
}
package com.example.demo.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RelativeRankTest {

    RelativeRank relativeRank = new RelativeRank();

    @Test
    void findRelativeRanks() {
        int[] score = new int[]{5, 4, 3, 2, 1};
        String[] ranks = relativeRank.findRelativeRanks(score);
        assertThat(ranks).containsExactly("Gold Medal", "Silver Medal", "Bronze Medal", "4", "5");
    }

    // second test:
    // 10,3,8,9,4

    @Test
    void findRelativeRanks2() {
        int[] score = new int[]{10, 3, 8, 9, 4};
        String[] ranks = relativeRank.findRelativeRanks(score);
        assertThat(ranks).containsExactly("Gold Medal", "5", "Bronze Medal", "Silver Medal", "4");
    }
}
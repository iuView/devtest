package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LeetCodeRandomTest {

    @Test
    void asteroidCollision() {
        LeetCodeRandom leetCodeRandom = new LeetCodeRandom();
        int[] target = {-2, -2};
        int[] result = leetCodeRandom.asteroidCollision(new int[]{1, -1, -2, -2});
        assertThat(result).isEqualTo(target);

        // another input
        result = leetCodeRandom.asteroidCollision(new int[]{5, 10, -5});
        assertThat(result).isEqualTo(new int[]{5, 10});

        result = leetCodeRandom.asteroidCollision(new int[]{1, 1, -2, -2});
        assertThat(result).isEqualTo(new int[]{-2, -2});
    }
}
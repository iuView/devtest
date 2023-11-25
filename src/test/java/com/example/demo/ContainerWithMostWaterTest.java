package com.example.demo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

    ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

    @Test
    void maxArea() {
        int[] h = {1, 1};
        int max = containerWithMostWater.maxArea(h);
        assertThat(max).isEqualTo(1);

        int[] h2 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        max = containerWithMostWater.maxArea(h2);
        assertThat(max).isEqualTo(49);
    }
}
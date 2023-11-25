package com.example.demo.map;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class IceCreamTest {

    IceCream iceCream = new IceCream();

    @Test
    void icecreamParlor() {
        List<Integer> result = iceCream.icecreamParlor(6, Arrays.asList(1, 4, 3, 5, 6));
        assertThat(result).isEqualTo(Arrays.asList(1, 4));
    }
}
package com.example.demo.permutation;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationTest {

    @Test
    void combineMore() {
        Combination combination = new Combination();
        List<List<Integer>> result = combination.combine(4, 2);
        List<List<Integer>> target = new ArrayList<>();
        target.add(Arrays.asList(1, 2));
        target.add(Arrays.asList(1, 3));
        target.add(Arrays.asList(1, 4));
        target.add(Arrays.asList(2, 3));
        target.add(Arrays.asList(2, 4));
        target.add(Arrays.asList(3, 4));

        //assertThat(result.size()).isEqualTo(target.size());
        // further asserts are hard to do since will have to compare each list item
        // will be todos
        // but the assert can help debugging:
        assertThat(result).containsExactlyInAnyOrderElementsOf(target);
    }

    @Test
    void combineBasic() {
        Combination combination = new Combination();
        List<List<Integer>> result = combination.combine(4, 1);
        List<List<Integer>> target = new ArrayList<>();
        target.add(Arrays.asList(1));
        target.add(Arrays.asList(2));
        target.add(Arrays.asList(3));
        target.add(Arrays.asList(4));

        assertThat(result).containsExactlyInAnyOrderElementsOf(target);
    }
}
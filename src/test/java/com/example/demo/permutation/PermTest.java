package com.example.demo.permutation;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PermTest {

    @Test
    void permuteOneItem() {
        Perm perm = new Perm();

        List<List<Integer>> result = perm.permute(new int[]{1});
        List<List<Integer>> target = new ArrayList<>();
        target.add(Arrays.asList(1));

        assertThat(result).containsExactlyInAnyOrderElementsOf(target);
    }

    @Test
    void permute() {
        Perm perm = new Perm();

        List<List<Integer>> result = perm.permute(new int[]{1, 2, 3});
        List<List<Integer>> target = createTarget();

        assertThat(result).containsExactlyInAnyOrderElementsOf(target);
    }

    private List<List<Integer>> createTarget() {
        List<List<Integer>> retval = new ArrayList<>();
        retval.add(Arrays.asList(1, 2, 3));
        retval.add(Arrays.asList(1, 3, 2));
        retval.add(Arrays.asList(2, 1, 3));
        retval.add(Arrays.asList(2, 3, 1));
        retval.add(Arrays.asList(3, 1, 2));
        retval.add(Arrays.asList(3, 2, 1));

        return retval;
    }
}
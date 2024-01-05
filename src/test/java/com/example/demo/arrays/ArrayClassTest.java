package com.example.demo.arrays;

import com.example.demo.TreeNode;
import com.example.demo.arrays.ArrayClass;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
class ArrayClassTest {

    ArrayClass arrayClass = new ArrayClass();

    @Test
    void majorityElement() {
        int val = arrayClass.majorityElement(IntStream.of(3, 2, 3).toArray());
        System.out.println(val);
    }

    @Test
    void containsNearByDuplicate() {
        boolean val = arrayClass.containsNearbyDuplicate(Stream.of(1, 2, 3, 1).mapToInt(Integer::intValue).toArray(), 3);
        assertThat(val).isTrue();

        val = arrayClass.containsNearbyDuplicate
                (IntStream.of(1, 2, 3, 1, 2, 3).toArray(), 2);

        assertThat(val).isFalse();

        String string = """
                A test for textblocks
                    first line
                        second line
                    third line
                """;
        System.out.println(string);
    }

    @Test
    void findDisappearedNumbers() {
        int[] input = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> retval = arrayClass.findDisappearedNumbers(input);
        assertThat(retval).containsExactlyInAnyOrder(5, 6);

        input = new int[]{1, 1};
        retval = arrayClass.findDisappearedNumbers(input);
        assertThat(retval).containsExactlyInAnyOrder(2);
    }

    @Test
    void sortedArrayToBST() {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = arrayClass.sortedArrayToBST(nums);
        // int[] result = {0,-3,9,-10,null,5};
        TreeNode expected = new TreeNode(0);
        expected.left = new TreeNode(-10);
        expected.left.right = new TreeNode(-3);
        expected.right = new TreeNode(5);
        expected.right.right = new TreeNode(9);
        assertThat(root).isEqualTo(expected);


//        int[] nums = {1, 3};
//        TreeNode root = arrayClass.sortedArrayToBST(nums);
//        TreeNode expected = new TreeNode(3);
//        expected.left = new TreeNode(1);

    }
}
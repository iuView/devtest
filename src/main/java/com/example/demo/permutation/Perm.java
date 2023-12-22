package com.example.demo.permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * the permutation stuff deserves its own package
 * I can't imagine all the possible stuff are tested and therefore there on leetcode
 * what a terrible life we are heading into
 */
public class Perm {
    // https://leetcode.com/problems/permutations/description/
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> retval = new ArrayList<>();

        List<Integer> firstItem = new ArrayList<>();
        firstItem.add(nums[0]);
        retval.add(firstItem);
        return doPermute(retval, nums, 1);

    }

    private List<List<Integer>> doPermute(List<List<Integer>> retval, int[] nums, int index) {
        if (index <= nums.length - 1) {
            List<List<Integer>> newRows = new ArrayList<>();
            for (int i = 0; i < retval.size(); i++) {
                List<Integer> vals = retval.get(i);
                // insert the current item to the front of the list
                // then create new lists subsequently

                // the next few lines is to replicate:
                for (int j = 0; j < vals.size() + 1; j++) {
                    List<Integer> newRow = new ArrayList<>();
                    newRow.addAll(vals);
                    newRow.add(j, nums[index]);
                    newRows.add(newRow);
                }
            }

            return doPermute(newRows, nums, index + 1);
        }
        return retval;
    }
}

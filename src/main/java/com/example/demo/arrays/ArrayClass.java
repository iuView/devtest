package com.example.demo.arrays;

import com.example.demo.TreeNode;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayClass {
    public int majorityElement(int[] nums) {
        // hashmap that is a count
        Map<Integer, Integer> m = new HashMap<>();

        int midval = nums.length / 2;
        for (int i = 0; i < nums.length; i++) {
            Integer item = m.get(nums[i]);
            if (item != null) {
                item++;
            } else {
                item = 1;
            }

            if (item > midval) {
                return nums[i];
            }
            m.put(nums[i], item);
        }

        Map.Entry<Integer, Integer> theEntry =
                m.entrySet().stream().sorted((entry1, entry2) -> {
                    return entry2.getValue().compareTo(entry1.getValue());
                }).findFirst().orElse(null);

        return theEntry.getKey().intValue();

    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            // look left and right for values
            // look left:
            // just need to look forward
            if (i == nums.length - 1) {
                return false;
            }
            int maxindex = i + k; // inclusive
            boolean val = findIt(nums, i, maxindex, nums[i]);
            if (val)
                return val;
        }
        return false;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {

//        return IntStream.range(1, nums.length + 1).mapToObj(x -> x).filter(x -> !Arrays.stream(nums).anyMatch(y -> y == x))
//                .collect(Collectors.toList());
        char[] array = "1".repeat(nums.length).toCharArray();
        List<Integer> retval = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            array[nums[i] - 1] = '0';
        }
        for (int j = 0; j < array.length; j++) {
            if (array[j] == '1') {
                retval.add(j + 1);
            }
        }
        return retval;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;

        return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBSTHelper(int[] nums, int beginIndex, int endIndex) {
        // do not include the endIndex

        TreeNode root = new TreeNode();

        if (beginIndex == endIndex) {
            root.val = nums[beginIndex];
            return root;
        }

        // find the middle node, do a recursive on the left,
        // do a recursive on the right
        int middleindex = (beginIndex + endIndex) / 2;

        System.out.printf("middle index is: %d%n", middleindex);

        if (beginIndex == middleindex) {
            ;
        } else {
            TreeNode left = sortedArrayToBSTHelper(nums, beginIndex, middleindex - 1);
            root.left = left;
        }

        if (endIndex == middleindex) {
            ;
        } else {
            TreeNode right = sortedArrayToBSTHelper(nums, middleindex + 1, endIndex);
            root.right = right;
        }
        root.val = nums[middleindex];

        return root;
    }


    boolean findIt(int[] nums, int startIndex, int endIndex, int val) {
        boolean retval = false;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (i == nums.length)
                return false;
            if (nums[i] == val)
                return true;
        }
        return retval;
    }
}

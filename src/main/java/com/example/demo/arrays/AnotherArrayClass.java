package com.example.demo.arrays;

import java.util.*;

public class AnotherArrayClass {

    // here is for combination sum: (I didn't finish this one)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        return null;
    }

    // here another arrays medium.
    // I don't think I can do any of these anymore. I am defeated by now.
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
    public int[] searchRange(int[] nums, int target) {
        // will have to use device konquer since it is asking for log(n) time complexity
        int[] retval = {-1, -1};

        if (nums.length == 0)
            return retval;

        return searchRange(nums, 0, nums.length - 1, target);
    }

    int[] searchRange(int[] nums, int startindex, int endindex, int target) {
        if (startindex == endindex) {
            // what does it mean start equals end
        }
        int mid = (startindex + endindex) / 2;
        int[] firsthalf = searchRange(nums, startindex, mid, target);
        int[] secondhalf = searchRange(nums, mid, endindex, target);
        return null;
    }

    Validatable myvalidator = new Validator();

    public boolean isValidSudoku(char[][] board) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        boolean isvalid = true;
        int rownum = 0, colnum = 0;
        for (char[] row : board) {
            colnum = 0;
            for (char cell : row) {
                if (cell != '.') {
                    int val = Integer.parseInt(cell + "");
                    List<int[]> vals = map.get(val);
                    if (vals == null)
                        vals = new ArrayList<>();
                    vals.add(new int[]{rownum, colnum});
                    map.put(val, vals);
                }
                colnum++;
            }
            rownum++;
        }

        for (Integer key : map.keySet()) {
            List<int[]> entry = map.get(key);
            if (myvalidator.sameColumn(entry) || myvalidator.sameRow(entry) ||
                    myvalidator.sameSquare(entry))
                return false;
        }

        return isvalid;
    }

    void setMyvalidator(Validatable validatable) {
        this.myvalidator = validatable;
    }

}

class Validator implements Validatable {

    @Override
    public boolean sameRow(List<int[]> vals) {
        // every first element is the same
        List<Integer> rows = new ArrayList<>();
        for (int[] val : vals) {
            if (rows.contains(val[0]))
                return true;
            else
                rows.add(val[0]);
        }
        return false;
    }

    @Override
    public boolean sameColumn(List<int[]> vals) {
        // every second element is the same
        List<Integer> cols = new ArrayList<>();
        for (int[] val : vals) {
            if (cols.contains(val[1]))
                return true;
            else
                cols.add(val[1]);
        }
        return false;
    }

    @Override
    public boolean sameSquare(List<int[]> vals) {
        // left most corner: i/3 == 0, j/3 == 0
        // lower right bottom corner: i/3 = 2, j/3 = 2
        // each square has this kind of rule
        // 9 rules total
        Set<Integer> set = new HashSet<>();
        for (int[] val : vals) {
            set.add(whichSquare(val));
        }
        // if the vals are spread out into different squares
        // we should have a set that is equal size with the original points
        return set.size() == vals.size() ? false : true;
    }

    // here is the square numbers:
    // 1, 2, ....9
    int whichSquare(int[] val) {
        int retval = 1;
        int row = val[0] / 3;
        int col = val[1] / 3;
        if (row == 0) {
            if (col == 0) {
                retval = 1;
            } else if (col == 1) {
                retval = 2;
            } else {
                retval = 3;
            }
        } else if (row == 1) {
            if (col == 0) {
                retval = 4;
            } else if (col == 1) {
                retval = 5;
            } else {
                retval = 6;
            }
        } else {
            if (col == 0) {
                retval = 7;
            } else if (col == 1) {
                retval = 8;
            } else {
                retval = 9;
            }
        }
        return retval;
    }
}

interface Validatable {
    boolean sameRow(List<int[]> vals);

    boolean sameColumn(List<int[]> vals);

    boolean sameSquare(List<int[]> vals);
}
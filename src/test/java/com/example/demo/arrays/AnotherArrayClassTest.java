package com.example.demo.arrays;

import net.bytebuddy.agent.builder.AgentBuilder;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class AnotherArrayClassTest {

    AnotherArrayClass testclass = new AnotherArrayClass();

    @Test
    void hello() {
        assertThat(true).isTrue();
    }

//    ,['6','.','.','1','9','5','.','.','.']
//            ,['.','9','8','.','.','.','.','6','.']
//            ,['8','.','.','.','6','.','.','.','3']
//            ,['4','.','.','8','.','3','.','.','1']
//            ,['7','.','.','.','2','.','.','.','6']
//            ,['.','6','.','.','.','.','2','8','.']
//            ,['.','.','.','4','1','9','.','.','5']
//            ,['.','.','.','.','8','.','.','7','9']]

    @Test
    void isValidSudoku() {
        char[] row1 = {'8', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] row2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] row3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] row4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};

        char[] row5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] row6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] row7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] row8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};

        char[] row9 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};


        char[][] board = new char[][]{
                row1, row2, row3, row4, row5, row6, row7, row8, row9
        };
        boolean retval = testclass.isValidSudoku(board);
        assertThat(retval).isFalse();
    }

    @Test
    void isValidSudoku2() {
        char[] row1 = {'.', '.', '4', '.', '.', '.', '6', '3', '.'};
        char[] row2 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row3 = {'5', '.', '.', '.', '.', '.', '.', '9', '.'};
        char[] row4 = {'.', '.', '.', '5', '6', '.', '.', '.', '.'};

        char[] row5 = {'4', '.', '3', '.', '.', '.', '.', '.', '1'};
        char[] row6 = {'.', '.', '.', '7', '.', '.', '.', '.', '.'};
        char[] row7 = {'.', '.', '.', '5', '.', '.', '.', '.', '.'};
        char[] row8 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};

        char[] row9 = {'.', '.', '.', '.', '.', '.', '.', '.', '.'};


        char[][] board = new char[][]{
                row1, row2, row3, row4, row5, row6, row7, row8, row9
        };
        boolean retval = testclass.isValidSudoku(board);
        assertThat(retval).isFalse();
    }

    @Disabled
    @Test
    void combinationSum() {
        int[] cans = {2, 3, 6, 7};

        List<List<Integer>> result = testclass.combinationSum(cans, 7);
        List<List<Integer>> target = createTarget();
        assertThat(result).containsExactlyInAnyOrder(target.get(0), target.get(1));
    }

    List<List<Integer>> createTarget() {
        List<List<Integer>> retval = new ArrayList<>();
        retval.add(IntStream.of(2, 2, 3).mapToObj(x -> x).collect(Collectors.toList()));
        retval.add(IntStream.of(7).mapToObj(x -> x).collect(Collectors.toList()));
        return retval;
    }

    @Test
    void searchRange() {
        int[] nums = {};
        int[] result = testclass.searchRange(nums, 0);
        int[] target = {-1, -1};
        assertThat(result).isEqualTo(target);
        
    }
}

// this is supposed to be false, I returned true
// this is wrong [],[],[],[],[],[],[]]
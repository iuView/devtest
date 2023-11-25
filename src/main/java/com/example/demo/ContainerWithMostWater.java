package com.example.demo;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        // left wall: keep searching to the left, find a value >= to yourself
        // right wall: keep search to the right, find a value >= to self
        // area: the index diff of these walls
        // the area is that and multiply by self-value
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            int leftwall = findLeftWall(height, i);
            int rightWall = findRightWall(height, i);
            int leftindex = i;
            int rightindex = i;
            if (leftwall != -1) {
                leftindex = leftwall;
            }
            if (rightWall != -1) {
                rightindex = rightWall;
            }
            int newmax = (rightindex - leftindex) * height[i];
            max = (newmax > max) ? newmax : max;
        }

        return max;
    }

    int findLeftWall(int[] height, int i) {
        int retval = -1;
        for (int j = 0; j < i; j++) {
            if (height[j] >= height[i])
                return j;
        }

        return retval;
    }

    int findRightWall(int[] height, int i) {
        int retval = -1;
        for (int j = height.length - 1; j > i; j--) {
            if (height[j] >= height[i])
                return j;
        }
        return retval;
    }
}

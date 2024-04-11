package com.aug.twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

public class LeetCode54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        int top = 0, left = 0, down = matrix.length-1, right = matrix[0].length-1;

        while (true){
            for (int i = left; i <= right; i++) {
                res.add(matrix[top][i]);
            }
            if(++top > down) break;
            for (int i = top; i <= down; i++) {
                res.add(matrix[i][right]);
            }
            if(--right < left) break;
            for (int i = right; i >= left; i--) {
                res.add(matrix[down][i]);
            }
            if (--down < top) break;
            for (int i = down; i >= top; i--) {
                res.add(matrix[i][left]);
            }
            if (++left > right) break;
        }
        return res;
    }
}

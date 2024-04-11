package com.aug.twoDimensionalArray;

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 0;
        int top = 0, down = n-1, left = 0, right = n-1;
        while (true){
            for (int i = left; i <= right; i++) {
                res[top][i] = ++num;
            }
            if(++top > down) break;
            for (int i = top; i <= down; i++) {
                res[i][right] = ++num;
            }
            if(--right < left) break;
            for (int i = right; i >= left; i--) {
                res[down][i] = ++num;
            }
            if(--down < top) break;
            for (int i = down; i >= top; i--) {
                res[i][left] = ++num;
            }
            if(++left>right) break;
        }
        return res;
    }
}

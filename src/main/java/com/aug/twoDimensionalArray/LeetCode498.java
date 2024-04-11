package com.aug.twoDimensionalArray;

public class LeetCode498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] res = new int[n * m];

        for (int i = 0,idx = 0; i < n + m - 1; i++) {
            if (i % 2 == 0) //偶数对角线
                for (int x = Math.min(i, n - 1); x >= Math.max(0, i - m + 1); x -- ) //从下往上遍历
                    res[idx++] = mat[x][i - x];
            else   		    //奇数对角线
                for (int x = Math.max(0, i - m + 1); x <= Math.min(i, n - 1); x ++ )//从上往下遍历
                    res[idx++] = mat[x][i - x];
        }

        return res;
    }
}

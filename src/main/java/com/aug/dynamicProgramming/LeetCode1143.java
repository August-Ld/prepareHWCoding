package com.aug.dynamicProgramming;

public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp含义: 表示 以【i-1】结尾的 text1 ，和以【j-1】结尾的 text2 的   两个字符串的最长公共子序列长度。
        int[][] dp = new int[text1.length()+1][text2.length()+1];

//        //初始化
//        dp[i][0] = 0;
//        dp[0][j] = 0;
//
//        //动归公式
//        相等：dp[i][j] = dp[i-1][j-1] + 1;
//        不相等： dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);

        //遍历顺序: 从左到右、从上到下
        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i-1);
            for (int j = 1; j <= text2.length(); j++) {
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}

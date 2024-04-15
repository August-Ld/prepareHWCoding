package com.aug.recursionAndDynamicPro;

public class LeetCode10 {
    public boolean isMatch(String s, String p) {

        //dp[i][j] 含义： s字符串的前i个字符 是否和 p字符串的前j个字符 完成正则表达式的匹配
        //返回值：dp[s.size][p.size]

        //动归公式：
        //公示推导：https://www.bilibili.com/video/BV1Br4y1v7SA/?spm_id_from=333.337.search-card.all.click&vd_source=a1b2d5b9214f3edf616ae5b7d2fdeb7b

        int n = s.length(), m = p.length();
        s = " " + s;
        p = " " + p;
        boolean[][] dp = new boolean[n+1][m+1];

        dp[0][0] = true;

        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(j+1<m && p.charAt(j+1) == '*') continue;
                if(p.charAt(j) != '*'){
                    dp[i][j] = i>=1 && dp[i-1][j-1] && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
                }else {
                    dp[i][j] = j>=2 && dp[i][j-2] || i>=1 && dp[i-1][j] && (s.charAt(i) == p.charAt(j-1) || p.charAt(j-1) == '.');
                }
            }
        }

        return dp[n][m];

    }

}

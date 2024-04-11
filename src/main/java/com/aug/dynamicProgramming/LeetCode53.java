package com.aug.dynamicProgramming;

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        //dp含义： dp[i] 表示下标为 i (以 nums[i]结尾) 的 最大连续子数组和为 dp[i];
        int[] dp = new int[nums.length];

        //初始化：
        dp[0] = nums[0];
        //返回值
        int res = nums[0];

        //动归公式
//        dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);

        //遍历顺序:从左到右
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i],dp[i-1]+nums[i]);
            if(res <= dp[i]) res = dp[i];
        }
        return res;
    }
}

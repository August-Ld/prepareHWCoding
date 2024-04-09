package com.aug.greedy;

import java.util.Arrays;

public class LeetCode135 {
    public int candy(int[] ratings) {
        int sum = 0;
        int[] candyNum = new int[ratings.length];
        Arrays.fill(candyNum,1);

        for (int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i-1]){
                candyNum[i] = candyNum[i-1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1] && candyNum[i] <= candyNum[i+1]){
                candyNum[i] = candyNum[i+1] + 1;
            }
        }

        for (int i : candyNum) {
            sum += i;
        }
        return sum;
    }
}

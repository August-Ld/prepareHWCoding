package com.aug.twoDimensionalArray;

import java.util.ArrayList;
import java.util.List;

public class LeetCode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> numRes = new ArrayList<>();
        List<Integer> num = new ArrayList<>();
        num.add(1);
        numRes.add(num);

        for (int i = 1; i < numRows; i++) {
            List<Integer> curRow = new ArrayList<>();
            curRow.add(1);
            List<Integer> preRow = numRes.get(i-1);
            for (int j = 1; j < i; j++) {
                curRow.add(preRow.get(j) + preRow.get(j-1));
            }
            curRow.add(1);
            numRes.add(curRow);
        }
        return numRes;
    }
}

package com.aug.backTracking;

import java.util.ArrayList;
import java.util.List;

public class LeetCode17 {
    String[] stringMap = {
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    List<String> res = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0 || digits == null) return res;

        backTracking(digits,0);
        return res;
    }

    private void backTracking(String digits, int startIndex){
        if(startIndex == digits.length()) {
            res.add(sb.toString());
            return;
        }

        String str = stringMap[digits.charAt(startIndex) - '0' - 2];
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            backTracking(digits, startIndex + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}

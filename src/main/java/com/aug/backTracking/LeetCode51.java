package com.aug.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeetCode51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] chessBoard = new char[n][n];
        for (char[] c : chessBoard) {
            Arrays.fill(c,'.');
        }

        backTracking(chessBoard,0);
        return res;
    }

    private void backTracking(char[][] chessBoard, int startIndex){
        if(startIndex == chessBoard.length){
            // 二维字符数组 转 list
            List<String> r = new ArrayList<>();
            for (char[] chars : chessBoard) {
                r.add(String.valueOf(chars));
            }

            res.add(r);
            return;
        }

        for (int i = 0; i < chessBoard[startIndex].length; i++) {
            if(!safe(chessBoard,startIndex,i)){
                continue;
            }
            chessBoard[startIndex][i] = 'Q';
            backTracking(chessBoard,startIndex + 1);
            chessBoard[startIndex][i] = '.';
        }
    }

    private boolean safe(char[][] chessBoard, int startIndex, int i){

        //列
        boolean col = true;
        for (int j = 0; j <= startIndex; j++) {
            if(chessBoard[j][i] == 'Q'){
                col = false;
                break;
            }
        }

        //左斜
        boolean leftObl = true;
        for (int j = startIndex, k = i; j >= 0 && k>=0; j--,k--) {
            if (chessBoard[j][k] == 'Q') {
                leftObl = false;
                break;
            }
        }

        //左斜
        boolean rightObl = true;
        for (int j = startIndex, k = i; j >= 0 && k < chessBoard[j].length; j--,k++) {
            if (chessBoard[j][k] == 'Q') {
                rightObl = false;
                break;
            }
        }

        return col && leftObl && rightObl;
    }
}

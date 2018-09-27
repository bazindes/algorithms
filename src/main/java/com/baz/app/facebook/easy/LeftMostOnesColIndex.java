package com.baz.app.facebook.easy;

public class LeftMostOnesColIndex {

    /**
     * 给一个2d matrix，每个里面值要么是1要么是0， 假如出现1，后面的数都是1.
     * 找出最左边是1的列
     * [[0, 0, 1, 1, 1],
     * [0, 1, 1, 1, 1],
     * [0, 0, 1, 1, 1],
     * [0, 0, 0, 0, 0]]
     */

    public int getLeftMostOne(int[][] matrix){
        if(matrix == null || matrix.length == 0) return -1;

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0){
            if(matrix[i][j] == 1)
                j --;
            else
                i ++;
        }

        return j + 1;
    }

}

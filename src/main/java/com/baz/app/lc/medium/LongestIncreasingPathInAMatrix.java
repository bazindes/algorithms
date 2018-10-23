package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class LongestIncreasingPathInAMatrix implements Facebook {

    /**
     * Given an integer matrix, find the length of the longest increasing path.
     * From each cell, you can either move to four directions: left, right, up or down.
     * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
     * Example 1:
     * Input: nums =
     * [
     *   [9,9,4],
     *   [6,6,8],
     *   [2,1,1]
     * ]
     * Output: 4
     * Explanation: The longest increasing path is [1, 2, 6, 9].
     * Example 2:
     * Input: nums =
     * [
     *   [3,4,5],
     *   [3,2,6],
     *   [2,2,1]
     * ]
     * Output: 4
     * Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.
     */

    //O(mn) O(mn)
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int max = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int len = dfsHelper(matrix, i, j, Integer.MAX_VALUE, cache);
                max = Math.max(max, len);
            }
        }
        return max;
    }

    private int dfsHelper(int[][] matrix, int i, int j, int prev, int[][] cache){
        if(i < 0 || i > matrix.length || j < 0 || j > matrix[0].length || prev <= matrix[i][j])
            return 0;

        if(cache[i][j] > 0){
            return cache[i][j];
        }else {
            int tempMax = 0;
            tempMax = Math.max(tempMax, dfsHelper(matrix, i + 1, j, matrix[i][j], cache));
            tempMax = Math.max(tempMax, dfsHelper(matrix, i - 1, j, matrix[i][j], cache));
            tempMax = Math.max(tempMax, dfsHelper(matrix, i, j + 1, matrix[i][j], cache));
            tempMax = Math.max(tempMax, dfsHelper(matrix, i, j - 1, matrix[i][j], cache));
            cache[i][j] = ++ tempMax;
            return tempMax;
        }
    }

}

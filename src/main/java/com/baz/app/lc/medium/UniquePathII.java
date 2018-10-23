package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

public class UniquePathII implements Facebook {

    /**
     * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
     *
     * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
     *
     * Now consider if some obstacles are added to the grids. How many unique paths would there be?
     *
     * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
     *
     * Note: m and n will be at most 100.
     * Example 1:
     * Input:
     * [
     *   [0,0,0],
     *   [0,1,0],
     *   [0,0,0]
     * ]
     * Output: 2
     * Explanation:
     * There is one obstacle in the middle of the 3x3 grid above.
     * There are two ways to reach the bottom-right corner:
     * 1. Right -> Right -> Down -> Down
     * 2. Down -> Down -> Right -> Right
     */


    // TLE O(2^n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        return dfsHelper(obstacleGrid, 0, 0);
    }

    private int dfsHelper(int[][] og, int i, int j){
        if(i == og.length || j == og[0].length) return 0;
        if(i == og.length - 1 && j == og[0].length - 1) return 1;
        if(og[i][j] == 1) return 0;
        return dfsHelper(og, i + 1, j) + dfsHelper(og, i, j + 1);
    }

    // DP
    public int uniquePathsWithObstaclesBidfs(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] s = new int[m][n];
        s[0][0] = obstacleGrid[0][0]==0 ? 1:0;
        if(s[0][0] == 0) return 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j] == 1) s[i][j] = 0;
                else if(i==0){
                    if(j>0) s[i][j] = s[i][j-1];
                }
                else if(j==0){
                    if(i>0) s[i][j] = s[i-1][j];
                }
                else s[i][j] = s[i-1][j] + s[i][j-1];
            }
        }
        return s[m-1][n-1];
    }

    public void test(){
        int[][] og = {{0,0,0},
                {0,1,0},
                {0,0,0}};
        System.out.println(uniquePathsWithObstacles(og));
        System.out.println(uniquePathsWithObstaclesBidfs(og));
    }


}

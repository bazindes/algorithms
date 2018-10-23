package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

public class NumberOfIslands implements Facebook {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     *
     * Example 1:
     * Input:
     * 11110
     * 11010
     * 11000
     * 00000
     * Output: 1
     *
     * Example 2:
     * Input:
     * 11000
     * 11000
     * 00100
     * 00011
     * Output: 3
     */


    /**
     * for every position in matrix, use DFS and mark it to '0', O(n^2)
     * */

    private int n;
    private int m;
    public int numIsIslands(char[][] grid){
        int ans = 0;
        n = grid.length;
        if(n == 0) return 0;
        m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == '1'){
                    helper(grid, i, j);
                    ans ++;
                }
            }
        }
        return ans;
    }
    private void helper(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i>=n || j>=m || grid[i][j] != '1') return;
        grid[i][j] = '0';
        helper(grid, i - 1, j);
        helper(grid, i + 1, j);
        helper(grid, i, j - 1);
        helper(grid, i, j + 1);
    }

    public void test(){
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'0', '0', '1', '1', '1'}
        };
        System.out.println(numIsIslands(grid));
    }
}

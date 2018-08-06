package com.baz.app.facebook.medium;

public class NumberOfIslands {

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

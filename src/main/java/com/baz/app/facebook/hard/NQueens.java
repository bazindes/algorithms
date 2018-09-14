package com.baz.app.facebook.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    /**
     * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
     * Given an integer n, return all distinct solutions to the n-queens puzzle.
     * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
     * Example:
     * Input: 4
     * Output: [
     *  [".Q..",  // Solution 1
     *   "...Q",
     *   "Q...",
     *   "..Q."],
     *
     *  ["..Q.",  // Solution 2
     *   "Q...",
     *   "...Q",
     *   ".Q.."]
     * ]
     * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
     */

    //O(n*n!) O(n)
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];
        boolean[] diagOne = new boolean[2*n - 1];
        boolean[] diagTwo = new boolean[2*n - 1];
        helper(n, 0, ans, new ArrayList<>(), visited, diagOne, diagTwo);
        return ans;
    }

    private void helper(int col, int row, List<List<String>> ans, List<String> temp, boolean[] visited, boolean[] diagOne, boolean[] diagTwo){
        if(col == row){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < col; i++) {
            if(visited[i] || diagOne[row + i] || diagTwo[row - i + col - 1]) continue;
            char[] cur = new char[col];
            Arrays.fill(cur, '.');
            cur[i] = 'Q';
            String curStr = new String(cur);

            temp.add(curStr);
            visited[i] = true;
            diagOne[row + i] = true;
            diagTwo[row - i + col - 1] = true;

            helper(col, row + 1, ans, temp, visited, diagOne, diagTwo);

            temp.remove(temp.size() - 1);
            cur[i] = '.';
            visited[i] = false;
            diagOne[row + i] = false;
            diagTwo[row - i + col - 1] = false;
        }
    }

    public void test(){
        solveNQueens(4).forEach(i -> {
            i.forEach(j -> {
                System.out.print(j + " ");
                System.out.println();
            });
            System.out.println();
        });
    }

}

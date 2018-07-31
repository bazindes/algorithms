package com.baz.app.google.easy;

import java.util.HashSet;
import java.util.Set;

public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid){
        int num = 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
//                if(check(grid, i, j)){
                if(isMagic(grid, i, j)){
                    num ++;
                }
            }
        }
        return num;
    }

    private boolean check(int[][] grid , int col, int row){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.add(grid[i+col][j+row]);
            }
        }
        int a = grid[col][row]+grid[col+2][row+2];
        int b = grid[col+2][row]+grid[col][row+2];
        int c = grid[col+1][row+1]+grid[col+1][row+2];
        int d = grid[col][row]+grid[col+2][row+1];
        return set.size() == 9 && (a==b) && (c==d) && (a==c);
    }

    private boolean isMagic(int[][] grid, int row, int col) {
        int[] record = new int[10];
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9 || record[grid[i][j]] > 0) {
                    return false;
                }
                record[grid[i][j]] = 1;
            }
        }
        int sum1 = grid[row][col] + grid[row + 1][col + 1] + grid[row + 2][col + 2];
        int sum2 = grid[row][col + 2] + grid[row + 1][col + 1] + grid[row + 2][col];
        if (sum1 != sum2) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (grid[row + i][col] + grid[row + i][col + 1] + grid[row + i][col + 2] != sum1) {
                return false;
            }
            if (grid[row][col + i] + grid[row + 1][col + i] + grid[row + 2][col + i] != sum1) {
                return false;
            }
        }
        return true;
    }


    public void test(){
        int [][] grid = {{4,3,8,4},
                        {9,5,1,9},
                        {2,7,6,2}};
        int [][] grid2 = {
                {5,4,7,8,5,4,6,8,2,9},
                {5,3,6,8,1,5,1,1,8,5},
                {8,9,6,8,4,7,3,4,9,1},
                {9,3,8,9,2,8,3,8,7,1},
                {1,1,1,7,3,3,9,1,8,7},
                {1,5,5,7,1,6,7,9,3,4},
                {2,3,3,8,8,1,1,6,5,7},
                {7,8,5,4,7,9,4,6,5,3},
                {8,5,2,7,1,3,7,2,8,9},
                {4,9,4,3,9,4,5,4,7,1}
        };

        System.out.println(numMagicSquaresInside(grid));
        System.out.println(numMagicSquaresInside(grid2));
    }

}

package com.baz.app.google.easy;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid){
        int edges = 0;
        int square = 4;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) edges += 4;
                if(i>0)
                    if(grid[i-1][j] == 1) edges --;
                if(j>0)
                    if(grid[i][j-1] == 1) edges --;
            }
        }
        return edges;
    }
}

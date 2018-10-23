package com.baz.app.lc.easy;

public class ProjectionAreaOf3DShapes {

    public int projectionArea(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++){
            int maxJ = Integer.MIN_VALUE;
            for(int j=0; j<grid[0].length; j++){
                maxJ = Math.max(maxJ, grid[i][j]);
                if(grid[i][j]!=0) count ++;
            }
            count += maxJ;
            maxJ = Integer.MIN_VALUE;
        }
        for(int i=0; i<grid[0].length; i++){
            int maxJ = Integer.MIN_VALUE;
            for(int j=0; j<grid.length; j++){
                maxJ = Math.max(maxJ, grid[j][i]);
            }
            count += maxJ;
            maxJ = Integer.MIN_VALUE;
        }
        return count;
    }

    public void test(){
        int[][] g = {
                {1, 2},
                {3,4}
        };
        System.out.println(projectionArea(g));
    }

}

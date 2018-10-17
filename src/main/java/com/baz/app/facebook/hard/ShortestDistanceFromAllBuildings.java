package com.baz.app.facebook.hard;

import com.sun.org.apache.regexp.internal.RE;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceFromAllBuildings {

    /**
     * You want to build a house on an empty land which reaches all buildings in the shortest amount of distance. You can only move up, down, left and right.
     * You are given a 2D grid of values 0, 1 or 2, where:
     *
     *     Each 0 marks an empty land which you can pass by freely.
     *     Each 1 marks a building which you cannot pass through.
     *     Each 2 marks an obstacle which you cannot pass through.
     *
     * Example:
     *
     * Input: [[1,0,2,0,1],[0,0,0,0,0],[0,0,1,0,0]]
     *
     * 1 - 0 - 2 - 0 - 1
     * |   |   |   |   |
     * 0 - 0 - 0 - 0 - 0
     * |   |   |   |   |
     * 0 - 0 - 1 - 0 - 0
     *
     * Output: 7
     *
     * Explanation: Given three buildings at (0,0), (0,4), (2,2), and an obstacle at (0,2),
     *              the point (1,2) is an ideal empty land to build a house, as the total
     *              travel distance of 3+3+1=7 is minimal. So return 7.
     *
     * Note:
     * There will be at least one building. If it is not possible to build such house according to the above rules, return -1.
     */

    // O(m^2n^2) O(mn)
    public int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return -1;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        int buildings = 0;
        //Find how many buildings in grid
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1){
                    buildings ++;
                }
            }
        }
        //Store the distance for a spot to all the buildings
        int[][] distance = new int[rows][cols];
        //Store how many buildings a spot connects to
        int[][] count = new int[rows][cols];
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 1){
                    //If one building cannot connect to all the other buildings
                    //Then we cannot find a solution
                    if(!bfs(grid, i, j, distance, count, buildings)){
                        return -1;
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < cols; ++j){
                if(grid[i][j] == 0){
                    if(count[i][j] == buildings)
                        min = Math.min(min, distance[i][j]);
                }
            }
        }
        return Integer.MAX_VALUE != min ? min : -1;
    }

    private class Point{
        int x;
        int y;
        int distance;
        Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.distance = d;
        }
    }

    //Return true if the current building can connect to all the other buildings, false other wid=se
    private boolean bfs(int[][] grid, int startX, int startY, int[][] distance, int[][] count, int buildings){
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY, 0));
        visited[startX][startY] = true;
        int foundBuilds = 1; //All buildings should connect to each other
        // 4 directions
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while(!queue.isEmpty()){
            Point cur = queue.poll();
            for(int i = 0; i < 4; ++i){
                int x = dx[i] + cur.x;
                int y = dy[i] + cur.y;
                if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length){
                    continue;
                }
                //Connect to a building
                if(grid[x][y] == 1 && !visited[x][y]){
                    visited[x][y] = true;
                    foundBuilds ++;
                }
                //Connect to a spot
                if(grid[x][y] == 0 && !visited[x][y]){
                    visited[x][y] = true;
                    queue.offer(new Point(x, y, cur.distance + 1));
                    distance[x][y] += cur.distance + 1;
                    count[x][y] ++;
                }

            }
        }
        return foundBuilds == buildings;
    }

}

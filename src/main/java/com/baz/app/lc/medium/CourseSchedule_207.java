package com.baz.app.lc.medium;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule_207 {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * <p>
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * <p>
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     * <p>
     * Example 1:
     * <p>
     * Input: 2, [[1,0]]
     * Output: true
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0. So it is possible.
     * Example 2:
     * <p>
     * Input: 2, [[1,0],[0,1]]
     * Output: false
     * Explanation: There are a total of 2 courses to take.
     * To take course 1 you should have finished course 0, and to take course 0 you should
     * also have finished course 1. So it is impossible.
     * Note:
     * <p>
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     */

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return true;
        if(prerequisites == null || prerequisites.length == 0) return true;

        int[][] matrix = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];

        for (int i=0; i<prerequisites.length; i++){
            int cur = prerequisites[i][0];
            int pre = prerequisites[i][1];
            if(matrix[pre][cur] == 0)
                indegree[cur] ++;
            matrix[pre][cur] = 1;
        }

        //bfs
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < indegree.length; i ++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        while (!queue.isEmpty()){
            int cur = queue.poll();
            count ++;
            for (int i = 0; i < numCourses; i++) {
                if(matrix[cur][i] != 0){
                    indegree[i] --;
                    if(indegree[i] == 0){
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }

    // DFS
    public boolean canFinishDFS(int n, int[][] prerequisites) {
        if (n <= 1 || prerequisites.length <= 1) return true;

        int[] root1 = new int[n];
        int[] root2 = new int[n];
        for (int i=0; i<n; ++i)
            root1[i] = root2[i] = i;

        int[][] reverse = new int[prerequisites.length][2];
        for (int i=0; i<prerequisites.length; ++i) {
            reverse[i][0] = prerequisites[i][1];
            reverse[i][1] = prerequisites[i][0];
        }

        return noCycle(prerequisites, root1) && noCycle(reverse, root2);
    }

    private boolean noCycle(int[][] edges, int[] root) {
        for (int[] edge: edges) {
            int before = edge[1], after = edge[0];
            while (root[before] != before) {
                before = root[before];
                if (before == after) return false;
            }
            root[after] = before;
        }
        return true;
    }

}

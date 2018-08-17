package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] courseCount = new int[numCourses];
        List<List<Integer>> graph = initialGraph(numCourses, prerequisites, courseCount);
        return bfs(courseCount, graph);
    }

    private List<List<Integer>> initialGraph(int numCourses, int[][] prerequisites, int[] courseCount){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] i : prerequisites){
            courseCount[i[0]] ++;
            graph.get(i[1]).add(i[0]);
        }
        return graph;
    }

    private int[] bfs(int[]courseCount, List<List<Integer>> graph){
        int[] ans = new int[courseCount.length];
        Queue<Integer> queue = new LinkedList<>();
        for (int i=0; i<courseCount.length; i++){
            if(courseCount[i] == 0)
                queue.offer(i);
        }
        int index = 0;
        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            ans[index ++] = cur;
            for (int adj : graph.get(cur)){
                courseCount[adj] --;
                if(courseCount[adj] == 0){
                    queue.offer(adj);
                }
            }
        }
        return index == courseCount.length ? ans : new int[0];
    }

    public void test(){
        int[][] pre = {
                {0,1}
        };
        Utils.printArray(findOrder(2, pre));
    }

}

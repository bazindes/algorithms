package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.util.Utils;

import java.util.*;

public class CourseScheduleII implements Facebook {

    /**
     * There are a total of n courses you have to take, labeled from 0 to n-1.
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
     * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
     *
     * Example 1:
     * Input: 2, [[1,0]]
     * Output: [0,1]
     * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
     *              course 0. So the correct course order is [0,1] .
     * Example 2:
     * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
     * Output: [0,1,2,3] or [0,2,1,3]
     * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
     *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
     *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
     * Note:
     *
     * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
     * You may assume that there are no duplicate edges in the input prerequisites.
     */

    // O(n*m) O(n*m) n: count of courses, m: count of prerequisites
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // use an array to keep tracking how many prerequisites of one courses need to take first
        int[] courseCount = new int[numCourses];
        List<List<Integer>> graph = initialGraph(numCourses, prerequisites, courseCount);
        return bfs(courseCount, graph);
    }

    private List<List<Integer>> initialGraph(int numCourses, int[][] prerequisites, int[] courseCount){
        // initialize adjacent list
        List<List<Integer>> graph = new ArrayList<>();
        // build directed graph
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
        // initial answer array
        int[] ans = new int[courseCount.length];
        Queue<Integer> queue = new LinkedList<>();
        // 1. put all courses which do not need prerequisites into queue
        for (int i=0; i<courseCount.length; i++){
            if(courseCount[i] == 0)
                queue.offer(i);
        }
        // help with answer array
        int index = 0;
        while (!queue.isEmpty()){
            // pick out current course, which must be without prerequisite or already take all prerequisites
            Integer cur = queue.poll();
            // put into answer
            ans[index ++] = cur;
            // loop its adjacent courses
            for (int adj : graph.get(cur)){
                // means already take current course, so count of prerequisites of next course can decrease by one
                courseCount[adj] --;
                // if all prerequisites of a course are taken, put it into queue (enqueue)
                if(courseCount[adj] == 0){
                    queue.offer(adj);
                }
            }
        }
        // check all course can be taken or not
        return index == courseCount.length ? ans : new int[0];
    }

    private int[] dfs(List<List<Integer>> graph){
        BitSet hasCycle = new BitSet(1);
        BitSet visited = new BitSet(graph.size());
        BitSet onStack = new BitSet(graph.size());
        Deque<Integer> order = new ArrayDeque<>();
        for (int i = graph.size(); i >= 0 ; i --) {
            if(!visited.get(i) && !hasOrder(i, graph, visited, onStack, order))
                return new int[0];
        }
        int[] ans = new int[graph.size()];
        int i = 0;
        while (!order.isEmpty()) {
            ans[i ++] = order.pop();
        }
        return ans;
    }

    private boolean hasOrder(int from, List<List<Integer>> graph, BitSet visited, BitSet onStack, Deque<Integer> order){
        visited.set(from);
        onStack.set(from);
        for (int to : graph.get(from)){
            if(!visited.get(to)){
                if(! hasOrder(to, graph, visited, onStack, order))
                    return false;
            }else if(onStack.get(to)){
                return false;
            }
        }

        onStack.clear(from);
        order.push(from);
        return true;
    }


    public void test(){
        int[][] pre = {
                {0,1}
        };
        Utils.printArray(findOrder(2, pre));
    }

}

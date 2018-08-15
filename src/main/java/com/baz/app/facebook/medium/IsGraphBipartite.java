package com.baz.app.facebook.medium;

import java.util.LinkedList;
import java.util.Queue;

public class IsGraphBipartite {

    //DFS O(n) O(n)
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];

        for (int i = 0; i < graph.length; i++) {
            if(colors[i] == 0 && !helper(graph, colors, -1, i)){
                return false;
            }
        }

        return true;
    }

    private boolean helper(int[][] graph, int[] colors, int color, int node){
        if(colors[node] != 0){
            return colors[node] == color;
        }

        colors[node] = color;

        for (int i : graph[node]){
            if(!helper(graph, colors, 0 - color, i)){
                return false;
            }
        }

        return true;
    }


    //BFS O(n) O(n)
    private boolean isBipartiteBFS(int [][] graph){
        int [] colors = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if(colors[i] == 0 && graph[i].length != 0){
                colors[i] = 1;
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);

                while (!queue.isEmpty()){
                    int cur = queue.poll();
                    for (int j : graph[cur]){
                        if(colors[j] != 0){
                            if(colors[j] == colors[cur])
                                return false;
                        }else {
                            colors[j] = 0 - colors[cur];
                            queue.offer(j);
                        }
                    }
                }
            }
        }

        return true;
    }

    public void test(){
        int[][] g = {{1,3}, {0,2}, {1,3}, {0,2}};
        System.out.println(isBipartite(g));
        System.out.println(isBipartiteBFS(g));
        g = new int[][]{{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        System.out.println(isBipartite(g));
        System.out.println(isBipartiteBFS(g));
    }

}

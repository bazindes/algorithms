package com.baz.app.TwoSigma.medium;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {

    /**
     * UF
     * @param M
     * @return
     */
    public int findCircleNum(int[][] M) {
        //corner case
        if (M == null || M.length == 0) return 0;
        //initialization: count = n, each id = id
        int m = M.length;
        int count = m;
        int[] roots = new int[m];
        for (int i = 0; i < m; i++) roots[i] = i;
        //for loop and union find
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                //if there is an edge, do union find
                if (M[i][j] == 1) {
                    int root0 = find (roots, i);
                    int root1 = find (roots, j);
                    if (root0 != root1) {
                        roots[root1] = root0;
                        count--;
                    }
                }
            }
        }
        //return count
        return count;
    }

    private int find (int[] roots, int id) {
        while (id != roots[id]) {
            roots[id] = roots[roots[id]];
            id = roots[id];
        }
        return id;
    }

    public void test(){
        int[][] fs = {
                {1,1,0},
                 {1,1,1},
                 {0,1,1}
        };
        System.out.println(findCircleNum(fs));
    }


    public class Unionfind {
         int[] ids;
         int count;
         public Unionfind(int num) {
             this.ids = new int[num];
             this.count = num;
             for (int i=0; i<num; i++) {
                 ids[i] = i;
             }
         }

         public int findId(int i) {
             return ids[i];
         }

         public boolean isConnected(int i, int j) {
             return findId(i)==findId(j);
         }

         public boolean union(int i, int j) {
             if (!isConnected(i, j)) {
                 for (int k=0; k<ids.length; k++) {
                     if (ids[k] == findId(j)) {
                         ids[k] = findId(i);
                     }
                 }
                 count--;
                 return true;
             }
             return false;
         }
     }

}

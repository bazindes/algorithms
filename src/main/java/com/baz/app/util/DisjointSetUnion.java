package com.baz.app.util;

public class DisjointSetUnion {

    int[] parent;
    public DisjointSetUnion(){
        parent = new int[10001];
        for (int i = 0; i <= 10000; i++) {
            parent[i] = i;
        }
    }

    public int find(int x){
        if(parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int i, int j){
        parent[find(i)] = find(j);
    }

}

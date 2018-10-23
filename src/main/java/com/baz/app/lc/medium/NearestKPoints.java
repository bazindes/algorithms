package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class NearestKPoints implements Facebook {

    /**
     *第一题是给n个点，找出离原点(0,0)最近的k个点。
     * 用priority queue做就行，只需要注意comparator没有写错。
     * followup是用pq的time complexity是nlogn，能否improve。
     * 我的思路是用类似找array里第k大的element，select一个点然后做partition，看看是不是第k个，expected runtime是O(n)，
     * 小姐姐也没说思路对不对，就直接做下一题了。
     */

    // O(nlogk) O(k)
    public List<int[]> nearestKPoints(List<int[]> points, int k){
        List<int[]> ans = new ArrayList<>();
        //corner case
        if(points == null || points.size() == 0) return ans;

        // maxHeap, top element is the maximum
        // or use Pair class
        PriorityQueue<Map.Entry<Integer, int[]>> priorityQueue = new PriorityQueue<>( (i,j) -> j.getKey() - i.getKey() );

        // calculate and put point into PQ
        for (int[] p : points){
            int dis = p[0] * p[0] + p[1] * p[1];
            priorityQueue.offer(new AbstractMap.SimpleEntry(dis, p));
            if(priorityQueue.size() > k)
                priorityQueue.poll();
        }

        // extract nearest points
        for (int i = 0; i < k; i++) {
            ans.add(priorityQueue.poll().getValue());
        }

        return ans;
    }

    public void test(){
        Random random = new Random();
        List<int[]> ps = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ps.add(new int[]{random.nextInt(10), random.nextInt(10)});
        }
        ps.forEach( i -> {
            System.out.print("[" + i[0] + ", " + i[1] + "] ");
        });

        System.out.println();

        nearestKPoints(ps, 3).forEach(i -> {
            System.out.print("[" + i[0] + ", " + i[1] + "] ");
        });
    }

}

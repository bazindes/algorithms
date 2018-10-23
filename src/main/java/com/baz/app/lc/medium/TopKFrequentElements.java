package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class TopKFrequentElements implements Facebook {

    /**
     * Given a non-empty array of integers, return the k most frequent elements.
     * Example 1:
     * Input: nums = [1,1,1,2,2,3], k = 2
     * Output: [1,2]
     * Example 2:
     * Input: nums = [1], k = 1
     * Output: [1]
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
     */


    public List<Integer> topKFrequentMaxHeap(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;

        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            map.put(i , map.getOrDefault(i , 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<Map.Entry<Integer, Integer>>((i , j) -> j.getValue() - i.getValue());

        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            maxHeap.add(en);
        }

        for (int i = 0; i < k; i++) {
            list.add(maxHeap.poll().getKey());
        }

        return list;
    }


    public void test(){
        int[] nums = {1,1,1,2,2,3};
        System.out.println(topKFrequentMaxHeap(nums , 2));
    }

}

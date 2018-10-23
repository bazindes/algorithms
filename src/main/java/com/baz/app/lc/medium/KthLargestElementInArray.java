package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.Utils;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementInArray implements Facebook {

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * Example 1:
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     */

    //O(nlogn) O(n)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //O(nlogn) O(n)
    public int findKthLargestPQ(int[] nums, int k){
        if(nums == null) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.offer(i);
            if(pq.size() > k)
                pq.poll();
        }

        return pq.peek();

    }

    //O(n) O(1)
    public int findKthLargestSelect(int[] nums, int k){
        shuffle(nums);
        k = nums.length - k;

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi){
            int j = partition(nums, lo, hi);
            if(j < k){
                lo = j + 1;
            }else if(j > k){
                hi = j - 1;
            }else{
                break;
            }
        }

        return nums[k];
    }

    private void shuffle(int[]a){
        Random random = new Random();
        for (int i = 0; i < a.length; i++) {
            int r = random.nextInt(i + 1);
            exch(a, i, r);
        }
    }

    private int partition(int[] a, int lo, int hi){
        int i = lo;
        int j = hi;
        while (true){
            while (i < hi && a[++i] < a[lo]);
            while (j > lo && a[lo] > a[--j]);
            if(i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public void test(){
        int[] ns = {3,2,1,5,6,4};
        System.out.println(findKthLargestPQ(ns, 2));
        Utils.printArray(ns);
        ns = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargestPQ(ns, 4));
        Utils.printArray(ns);

    }

}

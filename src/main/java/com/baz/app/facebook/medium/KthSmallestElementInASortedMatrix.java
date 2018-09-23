package com.baz.app.facebook.medium;

import java.util.PriorityQueue;

public class KthSmallestElementInASortedMatrix {

    /**
     * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element in the matrix.
     * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
     *
     * Example:
     * matrix = [
     *    [ 1,  5,  9],
     *    [10, 11, 13],
     *    [12, 13, 15]
     * ],
     * k = 8,
     *
     * return 13.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ n2.
     */

    //O(nlogk) O(k)
    public int kthSmallest(int[][] matrix, int k) {
        if(k == 0) return matrix[0][0];
        PriorityQueue<Integer> pq = new PriorityQueue<>((i,j) -> j - i);
        for (int[] i: matrix) {
            for (int n : i){
                pq.offer(n);
                if(pq.size() > k)
                    pq.poll();
            }
        }
        return pq.poll();
    }


    public int kthSmallestBS(int[][] matrix, int k){
        if(k == 0) return matrix[0][0];
        int lo = matrix[0][0];
        int hi = matrix[matrix.length - 1][matrix[0].length - 1];
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            int j = matrix[0].length - 1;
            for (int i = 0; i < matrix.length; i++) {
                while (j >= 0 && matrix[i][j] > mid) j --;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }

        return lo;
    }
}

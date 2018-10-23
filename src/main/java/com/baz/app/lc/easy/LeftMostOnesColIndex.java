package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

public class LeftMostOnesColIndex implements Facebook {

    /**
     * 给一个2d matrix，每个里面值要么是1要么是0， 假如出现1，后面的数都是1.
     * 找出最左边是1的列
     * [[0, 0, 1, 1, 1],
     * [0, 1, 1, 1, 1],
     * [0, 0, 1, 1, 1],
     * [0, 0, 0, 0, 0]]
     */

    //O(m + n) O(1)
    public int getLeftMostOne(int[][] matrix){
        if(matrix == null || matrix.length == 0) return -1;

        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;

        while (i < m && j >= 0){
            if(matrix[i][j] == 1)
                j --;
            else
                i ++;
        }

        return j + 1;
    }

    // O(nlogm)
    // traverse per line, use binary search to find left most 1
    public int getLeftMostOneBS(int[][] matrix){
        if(matrix == null || matrix.length == 0) return -1;

        int m = matrix.length;
        int ans = m;
        for (int[] i : matrix){
            ans = Math.min(ans, bsHelper(i));
        }

        return ans;
    }

    private int bsHelper(int[] nums){
        int lo = 0;
        int hi = nums.length - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == 1)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return lo;
    }


    public void test(){
        int [][] m = {{0, 0, 1, 1, 1},
                      {0, 0, 1, 1, 1},
                      {0, 0, 0, 1, 1},
                      {0, 1, 1, 1, 1}};
        System.out.println(getLeftMostOne(m));
        System.out.println(getLeftMostOneBS(m));
    }
}

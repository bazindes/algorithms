package com.baz.app.lc.easy;

import com.baz.app.Interface.facebook.Facebook;

public class MonotonicArray implements Facebook {

    /**
     * An array is monotonic if it is either monotone increasing or monotone decreasing.
     * An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
     * Return true if and only if the given array A is monotonic.
     *
     * Example 1:
     * Input: [1,2,2,3]
     * Output: true
     * Example 2:
     * Input: [6,5,4,4]
     * Output: true
     * Example 3:
     * Input: [1,3,2]
     * Output: false
     * Example 4:
     * Input: [1,2,4,5]
     * Output: true
     * Example 5:
     * Input: [1,1,1]
     * Output: true
     *
     * Note:
     * 1 <= A.length <= 50000
     * -100000 <= A[i] <= 100000
     */

    // O(n) O(1)
    public boolean isMonotonic(int[] A) {
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 0; i < A.length - 1; ++i) {
            if (A[i] > A[i+1])
                increasing = false;
            if (A[i] < A[i+1])
                decreasing = false;
        }

        return increasing || decreasing;
    }

    // O(n) O(1)
    public boolean isMonotonic2(int[] A) {
        if(A == null || A.length == 0) return true;
        boolean flag = A[0] < A[A.length - 1];
        for(int i=0; i<A.length - 1; i++){
            if(flag){
                if(A[i] > A[i+1])
                    return false;
            }else{
                if(A[i] < A[i+1])
                    return false;
            }
        }
        return true;
    }

}

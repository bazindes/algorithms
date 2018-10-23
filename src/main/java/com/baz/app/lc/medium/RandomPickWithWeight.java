package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomPickWithWeight implements Facebook {

    /**
     * Given an array w of positive integers, where w[i] describes the weight of index i,
     * write a function pickIndex which randomly picks an index in proportion to its weight.
     *
     * Note:
     * 1 <= w.length <= 10000
     * 1 <= w[i] <= 10^5
     * pickIndex will be called at most 10000 times.
     * Example 1:
     *
     * Input:
     * ["Solution","pickIndex"]
     * [[[1]],[]]
     * Output: [null,0]
     * Example 2:
     *
     * Input:
     * ["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
     * [[[1,3]],[],[],[],[],[]]
     * Output: [null,0,1,1,1,0]
     * Explanation of Input Syntax:
     *
     * The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument,
     * the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
     */

    List<Integer> sums = new ArrayList<>();
    int total = 0;
    Random r = new Random();

    // O(n)
    public RandomPickWithWeight(int[] w) {
        for(int i : w){
            total += i;
            sums.add(total);
        }
    }

    // O(logn)
    public int pickIndex() {
        int tar = r.nextInt(total);
        int lo = 0;
        int hi = sums.size() - 1;
        while(lo != hi){
            int mid = (lo + hi) / 2;
            if(tar >= sums.get(mid))
                lo = mid + 1;
            else
                hi = mid;
        }
        return lo;
    }

}

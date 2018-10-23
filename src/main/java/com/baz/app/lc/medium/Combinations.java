package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations implements Google {

    /***
     * BackTracking O(n) O(n)
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list, new ArrayList<>(), k , 1, n);
        return list;
    }

    private void helper(List<List<Integer>> list, List<Integer> temp, int k, int s, int n){
        if(k == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for (int i = s; i <= n; i++) {
            temp.add(i);
            helper(list, temp, k - 1, i + 1, n);
            temp.remove(temp.size() - 1);
        }
    }

    /***
     * fast
     */
    public List<List<Integer>> recursive( int n, int k){
        List<List<Integer>> list = new ArrayList<>();
        if(k > n || k < 0) return list;
        if(k == 0){
            list.add(new ArrayList<>());
            return list;
        }
        list = recursive( n - 1, k - 1);
        for (List<Integer> l : list){
            l.add(n);
        }
        list.addAll(recursive(n - 1 , k));
        return list;
    }

    /**
     * extremely fast
     */
    public List<List<Integer>> combineFast(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();

        if (k <= 0 || k > n)
            return result;

        Integer[] array = new Integer[k];
        fetchNumber(result, array, 0, 1, n, k);

        return result;
    }

    private void fetchNumber(List<List<Integer>> result, Integer[] pool, int poolIndex, int from, int to, int count) {
        if (count == 0) {
            Integer[] arr = new Integer[pool.length];
            System.arraycopy(pool, 0, arr, 0, pool.length);
            result.add(Arrays.asList(arr));
        } else {
            int freeCount = (to - from + 1) - (count - 1);
            for (int i = 0; i < freeCount; i++) {
                pool[poolIndex] = from + i;
                fetchNumber(result, pool, poolIndex + 1, from + i + 1, to, count - 1);
            }
        }
    }

    public void test(){
        recursive(4, 2).forEach( i -> {
            i.forEach( j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}

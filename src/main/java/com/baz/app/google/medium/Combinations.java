package com.baz.app.google.medium;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

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
     *
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

    public void test(){
        recursive(4, 2).forEach( i -> {
            i.forEach( j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}

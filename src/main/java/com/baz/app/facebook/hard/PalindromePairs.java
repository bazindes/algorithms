package com.baz.app.facebook.hard;

import java.util.*;

public class PalindromePairs {

    /**
     * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
     * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
     * Example 1:
     * Input: ["abcd","dcba","lls","s","sssll"]
     * Output: [[0,1],[1,0],[3,2],[2,4]]
     * Explanation: The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
     * Example 2:
     * Input: ["bat","tab","cat"]
     * Output: [[0,1],[1,0]]
     * Explanation: The palindromes are ["battab","tabbat"]
     */

    //TLE O(n^2 * k) O(n)
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        Map< Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < words.length; i ++){
            for (int j = 0; j < words.length; j ++){
                if(words[i].equals(words[j])) continue;
                String cur1 = words[i] + words[j];
                String cur2 = words[j] + words[i];
                if(check(cur1)){
                    if(!map.containsKey(i))
                        map.put(i, new HashSet<>());
                    map.get(i).add(j);
                }

                if(check(cur2)){
                    if(!map.containsKey(j))
                        map.put(j, new HashSet<>());
                    map.get(j).add(i);
                }
            }
        }
        for (Map.Entry<Integer, Set<Integer>> en : map.entrySet()){
            Set<Integer> set = en.getValue();
            for(Integer i : set){
                List<Integer> l = new ArrayList<>();
                l.add(en.getKey());
                l.add(i);
                ans.add(l);
            }
        }
        return ans;
    }

    //O(n * k^2) O(n)
    public List<List<Integer>> palindromePairsImpr(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if(words == null || words.length < 2) return ans;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i] , i);
        }

        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String cur1 = words[i].substring(0 , j);
                String cur2 = words[i].substring(j);
                if(check(cur1)){
                    String str = new StringBuilder(cur2).reverse().toString();
                    if(map.containsKey(str) && map.get(str) != i){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(map.get(str));
                        temp.add(i);
                        ans.add(temp);
                    }
                }
                if(check(cur2)){
                    String str = new StringBuilder(cur1).reverse().toString();
                    if(map.containsKey(str) && map.get(str) != i && cur2.length() != 0){
                        List<Integer> temp = new ArrayList<>();
                        temp.add(i);
                        temp.add(map.get(str));
                        ans.add(temp);
                    }
                }
            }
        }

        return ans;
    }

    private boolean check(String s){
        if(s == null || "".equals(s)) return true;
        int i = 0;
        int j = s.length() - 1;

        while (i <= j){
            if(s.charAt(i ++ ) != s.charAt(j --))
                return false;
        }

        return true;
    }

    public void test(){
        String[] ws = {"abcd","dcba","lls","s","sssll"};
        palindromePairsImpr(ws).forEach(i -> {
            i.forEach(j -> System.out.print(j + " "));
            System.out.println();
        });
    }

}

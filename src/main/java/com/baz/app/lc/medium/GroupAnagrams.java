package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class GroupAnagrams implements Facebook {

    /**
     * Given an array of strings, group anagrams together.
     * Example:
     * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Output:
     * [
     *   ["ate","eat","tea"],
     *   ["nat","tan"],
     *   ["bat"]
     * ]
     * Note:
     * All inputs will be in lowercase.
     * The order of your output does not matter.
     */

    //O(n * klogk) O(n)
    public List<List<String>> groupAnagramsMap(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs == null || strs.length == 0) return list;
        Map<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[]cs = s.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(map.containsKey(key)){
                map.get(key).add(s);
            }else {
                map.put(key, new ArrayList<String>(){{add(s);}});
            }
        }
        for(List<String> l : map.values()){
            list.add(l);
        }
        return list;
    }

    //O(N*M) O(N)
    //Hashing solution
    public List<List<String>> anagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs == null || strs.length == 0) return list;
        int[] PRIMES = new int[]{2, 3, 5, 7, 11 ,13, 17, 19, 23, 29, 31, 37, 41, 43,
                47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 107};
        Map<Integer, List<String>> map = new HashMap<>();
        int result = -1;
        for(String s: strs){
            int mapping = 1;
            for (int i = 0; i < s.length(); i++) {
                mapping *= PRIMES[s.charAt(i) - 'a'];
            }
            List<String> cur = map.get(mapping);
            if(cur == null){
                cur = new ArrayList<>();
                map.put(mapping, cur);
            }
            cur.add(s);
        }
        for(List<String> l : map.values())
            list.add(l);
        return list;
    }

    // O(nk) O(n)
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        if(strs == null || strs.length == 0) return list;
        Map<String, List<String>> map = new HashMap<>();
        int[]nums = new int[26];
        for (int i = 0; i < strs.length; i++) {
            String cur = strs[i];
            for (int j = 0; j < nums.length; j++) {
                nums[j] = 0;
            }
            for (int j = 0; j < cur.length(); j++) {
                nums[cur.charAt(j) - 'a'] ++;
            }
            StringBuilder sb = new StringBuilder();
            for(int j : nums){
                sb.append('#');
                sb.append(j);
            }
            if(map.containsKey(sb.toString())){
                List<String> temp = map.get(sb.toString());
                temp.add(cur);
            }else {
                map.put(sb.toString(), new ArrayList<String>(){{add(cur);}});
            }
        }

        list.addAll(map.values());

        return list;
    }

    public void test(){
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        strs = new String[]{"", ""};
        anagrams(strs).forEach(
                i -> {
                 i.forEach( s -> System.out.print(s + " "));
                    System.out.println();
                }
        );
    }

}

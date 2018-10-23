package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class TopKFrequentWords implements Facebook {

    /**
     * Given a non-empty list of words, return the k most frequent elements.
     * Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency,
     * then the word with the lower alphabetical order comes first.
     * Example 1:
     * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Output: ["i", "love"]
     * Explanation: "i" and "love" are the two most frequent words.
     *     Note that "i" comes before "love" due to a lower alphabetical order.
     * Example 2:
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *     with the number of occurrence being 4, 3, 2 and 1 respectively.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
     * Input words contain only lowercase letters.
     * Follow up:
     * Try to solve it in O(n log k) time and O(n) extra space.
     */

    public List<String> topKFrequent(String[] words, int k) {
        List<String> ans = new ArrayList<>();
        if(words == null || words.length == 0 || k == 0) return ans;
        Map<String, Integer> map = new HashMap<>();
        for(String cur : words){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (i,j) -> i.getValue() == j.getValue() ? i.getKey().compareTo(j.getKey()) : j.getValue() - i.getValue()
        );
        for(Map.Entry<String, Integer> cur : map.entrySet()){
            pq.offer(cur);
        }
        for (int i = 0; i < k; i++) {
            ans.add(pq.poll().getKey());
        }
        return ans;
    }

    public void test(){
        String[] cs = {"i", "love", "leetcode", "i", "love", "coding"};
        topKFrequent(cs, 2).forEach( i -> System.out.print(i + " "));
    }

}

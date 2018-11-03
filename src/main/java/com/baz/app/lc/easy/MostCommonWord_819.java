package com.baz.app.lc.easy;

import com.baz.app.Interface.Amazon.Amazon;

import java.util.*;

public class MostCommonWord_819 implements Amazon {

    /**
     * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
     * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
     * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.
     * The answer is in lowercase.
     *
     * Example:
     * Input:
     * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
     * banned = ["hit"]
     * Output: "ball"
     * Explanation:
     * "hit" occurs 3 times, but it is a banned word.
     * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
     * Note that words in the paragraph are not case sensitive,
     * that punctuation is ignored (even if adjacent to words, such as "ball,"),
     * and that "hit" isn't the answer even though it occurs more because it is banned.
     *
     * Note:
     * 1 <= paragraph.length <= 1000.
     * 1 <= banned.length <= 100.
     * 1 <= banned[i].length <= 10.
     * The answer is unique, and written in lowercase (even if its occurrences in paragraph may have uppercase symbols, and even if it is a proper noun.)
     * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
     * There are no hyphens or hyphenated words.
     * Words only consist of letters, never apostrophes or other punctuation symbols.
     */

    // O(l + p) O(l)
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph == null || "".equals(paragraph)) return "";
        Set<String> ban = new HashSet<>();
        for (String s : banned){
            ban.add(s.toLowerCase());
        }
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        String ans = "";
        int max = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            char c = paragraph.charAt(i);
            if(c == '.' || c == '!' || c == '?' || c == ',' || c == ';' || c == ' ' || c == '\''){
                String cur = sb.toString().toLowerCase();
                sb.setLength(0);
                if(!"".equals(cur) && !ban.contains(cur)){
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                    if(map.get(cur) > max){
                        ans = cur;
                        max = map.get(cur);
                    }
                }
            }else {
                sb.append(c);
            }
        }

        String cur = sb.toString().toLowerCase();
        if(!"".equals(cur) && !ban.contains(cur)){
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            if(map.get(cur) > max){
                ans = cur;
            }
        }

        return ans;
    }

    public String mostCommonWord2(String paragraph, String[] banned) {
        String[] words = paragraph.toLowerCase().split("[ !?',;.]+");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }

    // O(l) O(l)
    public String mostCommonWordUsingTrie(String paragraph, String[] banned) {
        Trie root = new Trie();
        Trie node;

        // insert banned words into Trie
        for (String s : banned) {
            node = root;

            for (char c : s.toCharArray()) {
                int idx = c - 'a';
                if (node.next[idx] == null) node.next[idx] = new Trie();
                node = node.next[idx];
            }

            node.ban = true; // set as banned
        }

        String res = "";
        int maxCount = 0;
        String par = paragraph.toLowerCase();
        char[] ch = par.toCharArray();
        int len = ch.length;

        // insert every char of paragraph one by one
        for (int i = 0, j = 0; i < len; i = ++j) { // i: start, j: end. i only increase with j. ++j: skip char that isn't letter
            node = root;

            // after while loop, ch[j] is not a letter (or end of ch)
            while (j < len && ch[j] >= 'a' && ch[j] <= 'z') {
                int idx = ch[j] - 'a';
                if (node.next[idx] == null) node.next[idx] = new Trie();
                node = node.next[idx];
                j++;
            }

            if (j > i && !node.ban) {
                if (++node.count > maxCount) { // ++node.count: increase count
                    res = par.substring(i, j);
                    maxCount = node.count;
                }
            }
        }

        return res;
    }

    private class Trie {
        private Trie[] next;
        private int count;
        private boolean ban;

        public Trie() {
            next = new Trie[26];
        }
    }

    public void test(){
        String p = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] b = { "hit" };

        System.out.println(mostCommonWord(p, b));
    }

}

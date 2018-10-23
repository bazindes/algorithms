package com.baz.app.lc.medium;

import java.util.*;

public class WordLadder {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     *
     * Only one letter can be changed at a time.
     * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
     * Note:
     *
     * Return 0 if there is no such transformation sequence.
     * All words have the same length.
     * All words contain only lowercase alphabetic characters.
     * You may assume no duplicates in the word list.
     * You may assume beginWord and endWord are non-empty and are not the same.
     * Example 1:
     *
     * Input:
     * beginWord = "hit",
     * endWord = "cog",
     * wordList = ["hot","dot","dog","lot","log","cog"]
     *
     * Output: 5
     *
     * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * Example 2:
     *
     * Input:
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     *
     * Output: 0
     *
     * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
     */

    //Bfs O(n)
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)) return 0;
        Set<String> toVisited = new HashSet<>();
        toVisited.addAll(wordList);
        toVisited.remove(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int ans = 0;

        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                char[] curStr = queue.poll().toCharArray();
                for (int i = 0; i < curStr.length; i++) {
                    char temp = curStr[i];
                    for (int j = 0; j < 26; j++) {
                        curStr[i] = (char)(j + 'a');
                        String tempStr = new String(curStr);
                        if(toVisited.contains(tempStr)){
                            if(endWord.equals(tempStr)){
                                return ans;
                            }
                            queue.offer(tempStr);
                            toVisited.remove(tempStr);
                            ans ++;
                        }
                    }
                    curStr[i] = temp;
                }
            }
        }
        return 0;
    }

    //Bidirection bfs
    public int ladderLengthBiBFS(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String w: wordList)
            set.add(w);
        if(!set.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet(), endSet = new HashSet();
        beginSet.add(beginWord); endSet.add(endWord);
        int step = 0;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            step++;
            if(beginSet.size() > endSet.size()){
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            Set<String> q = new HashSet<>();
            for(String s: beginSet){
                char[] ch = s.toCharArray();
                for(int i = 0; i < ch.length; i++){
                    char chac = ch[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == chac) continue;
                        ch[i] = c;
                        String t = new String(ch);
                        if(endSet.contains(t)) return step+1;
                        if(!set.contains(t)) continue;
                        q.add(t);
                        set.remove(t);
                    }
                    ch[i] = chac;
                }
            }
            beginSet = q;
        }
        return 0;
    }

    public void test(){
        String[] list = {"hot","dot","dog","lot","log","cog"};
        String bw = "hit";
        String ew = "cog";
        System.out.println(ladderLength(bw, ew, Arrays.asList(list)));
    }

}

package com.baz.app.lc.hard;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class AlienDictionary implements Facebook {

    /**
     * There is a new alien language which uses the latin alphabet.
     * However, the order among letters are unknown to you.
     * You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
     * Derive the order of letters in this language.
     *
     * Example 1:
     *
     * Input: [ "wrt", "wrf", "er", "ett", "rftt" ]
     * Output: "wertf"
     *
     * Example 2:
     * Input: ["z", "x"]
     * Output: "zx"
     *
     * Example 3:
     * Input: [ "z", "x", "z" ]
     * Output: ""
     *
     * Explanation: The order is invalid, so return "".
     * Note:
     *     You may assume all letters are in lowercase.
     *     You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
     *     If the order is invalid, return an empty string.
     *     There may be multiple valid order of letters, return any one of them is fine.
     */

    // BFS
    public String alienOrderBFS(String[] words) {
        // adjacent list to build graph
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            adj.add(new HashSet<Integer>());
        }
        int[] degree = new int[26];
        // initially assign all in-degrees as -1
        Arrays.fill(degree, -1);
        // build graph
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                // set to 0
                if (degree[c - 'a'] < 0) {
                    degree[c - 'a'] = 0;
                }
            }
            // build direction between two words
            if (i > 0) {
                String w1 = words[i - 1];
                String w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for (int j = 0; j < len; j++) {
                    int c1 = w1.charAt(j) - 'a';
                    int c2 = w2.charAt(j) - 'a';
                    if (c1 != c2) {
                        if (!adj.get(c1).contains(c2)) {
                            // build neighbors
                            adj.get(c1).add(c2);
                            // increase degree
                            degree[c2]++;
                        }
                        break;
                    }
                    // edge case, "abcd" -> "ab"
                    if (j == w2.length() - 1 && w1.length() > w2.length()) {
                        return "";
                    }
                }
            }
        }

        // BFS
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < degree.length; i++) {
            // Enqueue all nodes that in-degrees are 0
            if (degree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int i = q.poll();
            // append to result
            sb.append((char) ('a'  + i));
            // loop neighbors,
            for (int j : adj.get(i)) {
                // decrease the degree
                degree[j]--;
                // if in-degree == 0, Enqueue current node
                if (degree[j] == 0)
                    q.add(j);
            }
        }

        // check whether there is node unvisited
        for (int d : degree) {
            if (d > 0) {
                return "";
            }
        }

        return sb.toString();
    }

    /**
     * The key to this problem is:
     *     A topological ordering is possible if and only if the graph has no directed cycles
     * Let's build a graph and perform a DFS. The following states made things easier.
     *
     *     visited[i] = -1. Not even exist.
     *     visited[i] = 0. Exist. Non-visited.
     *     visited[i] = 1. Visiting.
     *     visited[i] = 2. Visited.
     *
     * Similarly, there is another simple BFS version.
     */
    // DFS
    private final int N = 26;
    public String alienOrder(String[] words) {
        boolean[][] adj = new boolean[N][N];
        int[] visited = new int[N];
        buildGraph(words, adj, visited);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            if(visited[i] == 0) {                 // unvisited
                if(!dfs(adj, visited, sb, i)) return "";
            }
        }
        return sb.reverse().toString();
    }

    public boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;                            // 1 = visiting
        for(int j = 0; j < N; j++) {
            if(adj[i][j]) {                        // connected
                if(visited[j] == 1) return false;  // 1 => 1, cycle
                if(visited[j] == 0) {              // 0 = unvisited
                    if(!dfs(adj, visited, sb, j)) return false;
                }
            }
        }
        visited[i] = 2;                           // 2 = visited
        sb.append((char) (i + 'a'));
        return true;
    }

    public void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);                 // -1 = not even existed
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray())
                visited[c - 'a'] = 0;
            if(i > 0) {
                String w1 = words[i - 1], w2 = words[i];
                int len = Math.min(w1.length(), w2.length());
                for(int j = 0; j < len; j++) {
                    char c1 = w1.charAt(j), c2 = w2.charAt(j);
                    if(c1 != c2) {
                        adj[c1 - 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }

}

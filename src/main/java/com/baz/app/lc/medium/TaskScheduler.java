package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;

import java.util.*;

public class TaskScheduler implements Facebook {

    /**
     * Given a char array representing tasks CPU need to do.
     * It contains capital letters A to Z where different letters represent different tasks.Tasks could be done without original order.
     * Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
     *
     * However, there is a non-negative cooling interval n that means between two same tasks,
     * there must be at least n intervals that CPU are doing different tasks or just be idle.
     *
     * You need to return the least number of intervals the CPU will take to finish all the given tasks.
     *
     * Example 1:
     * Input: tasks = ["A","A","A","B","B","B"], n = 2
     * Output: 8
     * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
     * Note:
     * The number of tasks is in the range [1, 10000].
     * The integer n is in the range [0, 100].
     */

    // counting idle slots
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for (char c: tasks)
            map[c - 'A']++;
        Arrays.sort(map);
        int max_val = map[25] - 1, idle_slots = max_val * n;
        for (int i = 24; i >= 0 && map[i] > 0; i--) {
            idle_slots -= Math.min(map[i], max_val);
        }
        return idle_slots > 0 ? idle_slots + tasks.length : tasks.length;
    }

    //Using sort approach
    public int leastIntervalUsingSort(char[] tasks , int n){
        char[] cs = new char[26];
        for (int i = 0; i < tasks.length; i++) {
            cs[tasks[i] - 'A'] ++;
        }
        Arrays.sort(cs);
        int ans = 0;
        while (cs[25] > 0){
            int i = 0;
            while (i <= n){
                if(cs[25] == 0){
                    break;
                }
                if(cs[25-i] > 0 && i < 26){
                    cs[25 - i] --;
                }
                ans ++;
                i ++;
            }

            Arrays.sort(cs);
        }
        return ans;
    }

    //O(n) O(n)
    public int leastIntervalUsingPQ(char[] tasks, int n){
        if(tasks == null || tasks.length == 0) return 0;

        int[] map = new int[26];
        for (char c : tasks)
            map[c - 'A'] ++;

        //use pq, in order to pick largest task for each round
        PriorityQueue<Integer> pq = new PriorityQueue<>(26, Collections.reverseOrder());
        for (int f : map){
            if (f > 0)
                pq.add(f);
        }

        int ans = 0;
        while (!pq.isEmpty()){
            int i = 0;
            List<Integer> temp = new ArrayList<>();

            while (i <= n){
                if(!pq.isEmpty()){
                    if(pq.peek() > 1)
                        temp.add(pq.poll() - 1);
                    else
                        pq.poll();
                }
                ans ++;
                if(pq.isEmpty() && temp.size() == 0)
                    break;
                i ++;
            }

            for (int x : temp){
                pq.offer(x);
            }
        }

        return ans;
    }

    /**
     * ⾯试的题⽬中，执⾏task的顺序是给定的，cooling down time只存在于相同种类
     * task之间，不同种类之间不存在cooling down time。
     * 例⼦：[1,1,2,3,1,3,4] cooling down time = 2
     * output: 1 _ _ 1 2 3 1 _ 3 4
     */

    public void test(){
        char[] cs = {'A','A','A','B','B','B'};
        System.out.println(leastIntervalUsingPQ(cs, 2));
    }


    //my approach O(n) O(n)
//    public int leastInterval(char[] tasks , int n){
//        Map<Character, Integer> tasksMap = sortTasksByAppearanceTimes(tasks);
//        StringBuilder sb = new StringBuilder();
//        int left = 0;
//        for (Integer i: tasksMap.values()){
//            left += i;
//        }
//        String ans = helper(tasksMap, left, sb, n);
//        return ans.length();
//    }
//
//    private String helper(Map<Character, Integer> tasks, int left, StringBuilder sb, int n){
//        if(left == 0) return sb.toString();
//        out: for (Map.Entry<Character, Integer> e : tasks.entrySet()){
//            if(e.getValue() == 0) continue;
//            else{
//                if(sb.length() >= n){
//                    char cur = e.getKey();
//                    int temp = 0;
//                    while (temp < n){
//                        if(cur == sb.charAt(sb.length()-1 - temp)){
//                            sb.append(' ');
//                            break out;
//                        }
//                        temp ++;
//                    }
//                    sb.append(e.getKey());
//                    e.setValue(e.getValue() - 1);
//                    left --;
//                }else {
//                    sb.append(e.getKey());
//                    e.setValue(e.getValue() - 1);
//                    left --;
//                }
//            }
//        }
//        return helper(tasks, left, sb, n);
//    }
//
//    private Map<Character, Integer> sortTasksByAppearanceTimes(char[] tasks){
//        Map<Character, Integer> tasksMap = new LinkedHashMap<>();
//        for (int i = 0; i < tasks.length; i++) {
//            tasksMap.put(tasks[i] , tasksMap.getOrDefault(tasks[i] , 0) + 1);
//        }
//        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
//        for(Map.Entry<Character,Integer> e : tasksMap.entrySet()){
//            list.add(e);
//        }
//        tasksMap.clear();
//        list.sort((i,j) -> i.getValue() - j.getValue());
//        for(Map.Entry<Character,Integer> e : list)
//            tasksMap.put(e.getKey(), e.getValue());
//        return tasksMap;
//    }
}

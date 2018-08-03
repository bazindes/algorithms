package com.baz.app.facebook.medium;

import java.util.*;

public class TaskScheduler {

    //my approach O(n) O(n)
    public int leastInterval(char[] tasks , int n){

        Map<Character, Integer> tasksMap = sortTasksByAppearanceTimes(tasks);

        StringBuilder sb = new StringBuilder();
        int left = 0;
        for (Integer i: tasksMap.values()){
            left += i;
        }
        String ans = helper(tasksMap, left, sb, n);
        return ans.length();
    }

    private String helper(Map<Character, Integer> tasks, int left, StringBuilder sb, int n){
        if(left == 0) return sb.toString();
        out: for (Map.Entry<Character, Integer> e : tasks.entrySet()){
            if(e.getValue() == 0) continue;
            else{
                if(sb.length() >= n){
                    char cur = e.getKey();
                    int temp = 0;
                    while (temp < n){
                        if(cur == sb.charAt(sb.length()-1 - temp)){
                            sb.append(' ');
                            break out;
                        }
                        temp ++;
                    }
                    sb.append(e.getKey());
                    e.setValue(e.getValue() - 1);
                    left --;
                    continue;
                }else {
                    sb.append(e.getKey());
                    e.setValue(e.getValue() - 1);
                    left --;
                    continue;
                }
            }
        }
        return helper(tasks, left, sb, n);
    }

    private Map<Character, Integer> sortTasksByAppearanceTimes(char[] tasks){
        Map<Character, Integer> tasksMap = new LinkedHashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            tasksMap.put(tasks[i] , tasksMap.getOrDefault(tasks[i] , 0) + 1);
        }
        List<Map.Entry<Character,Integer>> list = new ArrayList<>();
        for(Map.Entry<Character,Integer> e : tasksMap.entrySet()){
            list.add(e);
        }
        tasksMap.clear();
        list.sort((i,j) -> i.getValue() - j.getValue());
        for(Map.Entry<Character,Integer> e : list)
            tasksMap.put(e.getKey(), e.getValue());
        return tasksMap;
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

    public void test(){
        char[] cs = {'A','A','A','B','B','B'};
        System.out.println(leastInterval(cs, 2));
        System.out.println(leastIntervalUsingSort(cs, 2));
    }

}

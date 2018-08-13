package com.baz.app.facebook.medium;

import java.util.*;

public class GroupAnagrams {

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
        groupAnagrams(strs).forEach(
                i -> {
                 i.forEach( s -> System.out.print(s + " "));
                    System.out.println();
                }
        );
    }

}

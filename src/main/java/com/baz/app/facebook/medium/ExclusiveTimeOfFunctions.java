package com.baz.app.facebook.medium;

import com.baz.app.util.Utils;

import java.util.*;

public class ExclusiveTimeOfFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] cs = logs.get(0).split(":");
        stack.push(Integer.parseInt(cs[0]));
        int prev = Integer.parseInt(cs[2]);

        for (int i = 1; i < logs.size(); i++) {
            String[] log = logs.get(i).split(":");

            if("start".equals(log[1])) {

                if(!stack.isEmpty()){
                    ans[stack.peek()] += Integer.parseInt(log[2]) - prev;
                }
                stack.push(Integer.parseInt(log[0]));
                prev = Integer.parseInt(log[2]);

            }else {
                ans[stack.peek()] += Integer.parseInt(log[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(log[2]) + 1;
            }

        }

        return ans;
    }

    public void test(){
        int n = 2;
        List<String> logs = Arrays.asList(new String[]{"0:start:0", "1:start:2", "1:end:5", "0:end:6"});
        Utils.printArray(exclusiveTime(n, logs));
    }

}

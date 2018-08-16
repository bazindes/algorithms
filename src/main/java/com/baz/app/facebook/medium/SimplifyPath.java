package com.baz.app.facebook.medium;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();

        String[] cs = path.split("/");
        for (int i = 0; i < cs.length; i++) {
            if("".equals(cs[i])){
                if(i == 0){
                    stack.push(cs[i]);
                }else {
                    continue;
                }
            }else if(".".equals(cs[i])){
                continue;
            } else if("..".equals(cs[i])){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else {
                stack.push(cs[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.insert(0, stack.pop());
            if(!stack.isEmpty()) {
                sb.insert(0, "/");
            }
        }
        if(sb.length() == 0)
            sb.append("/");
        if(sb.charAt(0) != '/')
            sb.insert(0, "/");
        return sb.toString();
    }

    public void test(){
        String p = "/home/";
        System.out.println(simplifyPath(p));
        p = "/a/./b/../../c/";
        System.out.println(simplifyPath(p));
        p = "/../";
        System.out.println(simplifyPath(p));
        p = "/home//foo/";
        System.out.println(simplifyPath(p));
        p = "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///";
        System.out.println(simplifyPath(p));

    }

}

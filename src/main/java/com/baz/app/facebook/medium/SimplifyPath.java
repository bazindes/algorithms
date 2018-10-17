package com.baz.app.facebook.medium;

import java.util.*;

public class SimplifyPath {

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     *
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * path = "/a/../../b/../c//.//", => "/c"
     * path = "/a//b////c/d//././/..", => "/a/b/c"
     *
     * In a UNIX-style file system, a period ('.') refers to the current directory, so it can be ignored in a simplified path.
     * Additionally, a double period ("..") moves up a directory, so it cancels out whatever the last directory was.
     * For more information, look here: https://en.wikipedia.org/wiki/Path_(computing)#Unix_style
     *
     * Corner Cases:
     * Did you consider the case where path = "/../"?
     * In this case, you should return "/".
     * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
     * In this case, you should ignore redundant slashes and return "/home/foo".
     */

    // O(n) O(n)
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

    // Using Deque
    public String simplifyPathDQ(String path) {
        Deque<String> stack = new LinkedList<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..",".",""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) stack.pop();
            else if (!skip.contains(dir)) stack.push(dir);
        }
        String res = "";
        for (String dir : stack) res = "/" + dir + res;
        return res.isEmpty() ? "/" : res;
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

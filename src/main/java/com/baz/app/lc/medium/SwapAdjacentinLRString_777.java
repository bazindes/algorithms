package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;

public class SwapAdjacentinLRString_777 implements Google {

    /**
     * In a string composed of 'L', 'R', and 'X' characters, like "RXXLRXRXL",
     * a move consists of either replacing one occurrence of "XL" with "LX",
     * or replacing one occurrence of "RX" with "XR". Given the starting string start and the ending string end,
     * return True if and only if there exists a sequence of moves to transform one string to the other.
     *
     * Example:
     * Input: start = "RXXLRXRXL", end = "XRLXXRRLX"
     * Output: True
     * Explanation:
     * We can transform start to end following these steps:
     * RXXLRXRXL ->
     * XRXLRXRXL ->
     * XRLXRXRXL ->
     * XRLXXRRXL ->
     * XRLXXRRLX
     * Note:
     *
     * 1 <= len(start) = len(end) <= 10000.
     * Both start and end will only consist of characters in {'L', 'R', 'X'}.
     */

    // DFS O(l^l) O(l^l)
    public boolean canTransform(String start, String end) {
        if(start == null || end == null) return false;
        if(start.equals(end)) return true;

        return dfsHelper(start, end, 0);
    }

    private boolean dfsHelper(String cur, String tar, int pos){
        if(pos == tar.length() - 1) return cur.equals(tar);
        char[] cs = cur.toCharArray();
        boolean modify = false;
        if(cs[pos] == 'R' && cs[pos + 1] == 'X'){
            cs[pos] = 'X';
            cs[pos + 1] = 'R';
            modify = dfsHelper(String.valueOf(cs), tar, 0);
        }
        if(cs[pos] == 'X' && cs[pos + 1] == 'L'){
            cs[pos] = 'L';
            cs[pos + 1] = 'X';
            modify = dfsHelper(String.valueOf(cs), tar, 0);
        }
        return modify || dfsHelper(cur , tar, pos + 1);
    }

    // O(n) O(1)
    public boolean conTransFrom(String start, String end){
        char[] S = start.toCharArray();
        char[] E = end.toCharArray();
        int p1 = 0;
        int p2 = 0;
        while (p1 < S.length && p2 < E.length) {
            // get the non-X positions of 2 strings
            while (p1 < S.length && S[p1] == 'X') p1++;
            while (p2 < E.length && E[p2] == 'X') p2++;

            if (p1 < S.length && p2 < E.length) {
                if (S[p1] != E[p2]){
                    return false;
                } else {
                    // if the character is 'L', it can only be moved to the left. p1 should be greater or equal to p2.
                    if (S[p1] == 'L') { // E[p2] == 'L'
                        if(p1 < p2){
                            return false;
                        } else {
                            p1++;p2++;
                        }
                    } else { // S[p1] == 'R' && E[p2] == 'R', if the character is 'R', it can only be moved to the right. p2 should be greater or equal to p1.
                        if(p1 > p2){
                            return false;
                        } else {
                            p1++;p2++;
                        }
                    }
                }
            } else {
                // if both of the pointers reach the end the strings are transformable
                // if only one of the pointer reach the end they are not transformable
                return p1 == p2;
            }
        }
        return true;
    }

    public void test(){
        String s = "RXXLRXRXL";
        String e = "XRLXXRRLX";
        System.out.println(conTransFrom(s, e));
    }

}
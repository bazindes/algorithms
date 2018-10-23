package com.baz.app.lc.medium;

import com.baz.app.Interface.facebook.Facebook;
import com.baz.app.util.DisjointSetUnion;
import com.baz.app.util.ListNode;

import java.util.*;

public class AccountsMerge implements Facebook {

    /**
     * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
     * and the rest of the elements are emails representing emails of the account.
     *
     * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that is common to both accounts.
     * Note that even if two accounts have the same name, they may belong to different people as people could have the same name.
     * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
     *
     * After merging the accounts, return the accounts in the following format: the first element of each account is the name,
     * and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
     *
     * Example 1:
     * Input:
     * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
     * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
     * Explanation:
     * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
     * The second John and Mary are different people as none of their email addresses are used by other accounts.
     * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
     * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
     * Note:
     *
     * The length of accounts will be in the range [1, 1000].
     * The length of accounts[i] will be in the range [1, 10].
     * The length of accounts[i][j] will be in the range [1, 30].
     */

    //O(AlogA) A is sum of accounts[i] O(A)
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        if(accounts == null || ans.size() == 0) return ans;

        DisjointSetUnion disjointSetUnion = new DisjointSetUnion();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToID = new HashMap<>();
        int id = 0;
        for (List<String> l : accounts){
            String name = "";
            for (String cur : l){
                if("".equals(name)){
                    name = cur;
                    continue;
                }

                emailToName.put(cur, name);
                if(!emailToID.containsKey(cur)){
                    emailToID.put(cur, id ++);
                }

                disjointSetUnion.union(emailToID.get(l.get(1)) , emailToID.get(cur));
            }
        }

        Map<Integer, List<String>> map = new HashMap<>();
        for (String email : emailToName.keySet()){
            int i = disjointSetUnion.find(emailToID.get(email));
            map.computeIfAbsent(i, x -> new ArrayList<>()).add(email);
        }

        for (List<String> temp : map.values()){
            Collections.sort(temp);
            temp.add(0, emailToName.get(temp.get(0)));
        }
        ans.addAll(map.values());
        return ans;
    }

    /**
     *
     int[] parent;
     public DisjointSetUnion(){
     parent = new int[10001];
     for (int i = 0; i <= 10000; i++) {
     parent[i] = i;
     }
     }

     public int find(int x){
     if(parent[x] != x)
     parent[x] = find(parent[x]);
     return parent[x];
     }

     public void union(int i, int j){
     parent[find(i)] = find(j);
     }

     */

    public void test(){

    }

}

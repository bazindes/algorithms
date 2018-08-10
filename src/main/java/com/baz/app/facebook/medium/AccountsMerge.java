package com.baz.app.facebook.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AccountsMerge {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();

        return ans;
    }

    private void helper(List<List<String>> accounts, List<List<String>> ans){


        List<Set<String>> ls = new ArrayList<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> cur = accounts.get(i);
            String curName = cur.get(0);
            cur.remove(0);
            Set<String> emails = new HashSet<>(cur);
            ls.add(emails);
        }


    }

    public void test(){

    }

}

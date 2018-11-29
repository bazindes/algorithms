package com.baz.app.lc.medium;

import com.baz.app.Interface.Google.Google;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation_320 implements Google {

    /**
     * Write a function to generate the generalized abbreviations of a word.
     *
     * Note: The order of the output does not matter.
     * Example:
     * Input: "word"
     * Output:
     * ["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
     */

    public List<String> generateAbbreviations(String word) {
        List<String> ans = new ArrayList<>();

       dfsHelper(word, 0, "", 0, ans);

        return ans;
    }

    private void dfsHelper(String word, int n, String cur, int count, List<String> ans){
        if(n == word.length()){
            if(count > 0)
                cur += count;
            ans.add(cur);
        }else {
            dfsHelper(word, n + 1, cur, count + 1, ans);
            dfsHelper(word, n + 1, cur + (count > 0 ? count : "") + word.charAt(n), 0, ans);
        }
    }

    public void test(){
        generateAbbreviations("word").forEach( i -> System.out.printf(i + " "));
    }


}

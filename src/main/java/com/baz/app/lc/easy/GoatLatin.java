package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.HashSet;
import java.util.Set;

public class GoatLatin implements Facebook {

    public String toGoatLatin(String S){
        Set<Character> vowels = new HashSet<>();
        vowels.add('a'); vowels.add('A');
        vowels.add('e'); vowels.add('E');
        vowels.add('i'); vowels.add('I');
        vowels.add('o'); vowels.add('O');
        vowels.add('u'); vowels.add('U');
        String[]cs = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cs.length; i++) {
            if(vowels.contains(cs[i].charAt(0))){
                sb.append( cs[i] + "ma" + buildHelper(i) );
            }else {
                sb.append(  cs[i].substring(1) );
                sb.append(  cs[i].charAt(0) );
                sb.append( "ma" + buildHelper(i) );
            }
            if(i < cs.length -1)sb.append(" ");
        }
        return sb.toString();
    }

    private String buildHelper(int index){
        String cur = "a";
        for (int i = 0; i < index; i++) {
            cur += "a";
        }
        return cur;
    }

    public void test(){
        String s = "I speak Goat Latin";
        System.out.println(toGoatLatin(s));
        s = "The quick brown fox jumped over the lazy dog";
        System.out.println(toGoatLatin(s));
    }

}

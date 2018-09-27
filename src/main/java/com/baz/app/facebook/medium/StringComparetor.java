package com.baz.app.facebook.medium;

public class StringComparetor {

    /**
     *
     * 第二题是给两个字符串，比较字符串大小，返回字符串比较小的那个数。
     * 定义的比较规则是：a < b < c < d < ... < z < 0 < 1 < 2 < 100...如果两个字符串当前的字符串均为char，则根据a <b < c <...z来比较，
     * 如果当前字符是数字，则应该抽象出所有数字比较数字大小；
     * e,g1: str1 : a17; str2: a7 返回的str2, 因为a == a and 17 > 7;
     * eg2: ac < ad(c < d) ; e.g.3: a12 > ad(12 > d);
     * (数字总是大于字母），连续出现的数字应该作为一体，也不知道这样解释大家听得懂的啦~听不懂再问
     * a07 == a7(a == a; 07 == 7);
     *
     * case1: str1.charAt(i) && str.charAt(j)都是char，直接比较大小;
     * case2：str1.charAt(i)是数字，str2.charAt(j)是字母，直接返回str2;
     * case3: str1.charAt(i)是字母，str2.charAt(j)是数字，直接返回str1；. 留学申请论坛-一亩三分地
     * case4: str1.charAt(i)是数字,str.charAt(j)是数字，抽出来俩数字，比较大小；
     * 面试官的意思就是在当前字符下能够比较出大小，就直接返回小的字符串，不用再继续下去了~
     */



}

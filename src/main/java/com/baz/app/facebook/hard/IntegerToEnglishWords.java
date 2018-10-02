package com.baz.app.facebook.hard;

public class IntegerToEnglishWords {

    /**
     * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.
     *
     * Example 1:
     *
     * Input: 123
     * Output: "One Hundred Twenty Three"
     * Example 2:
     *
     * Input: 12345
     * Output: "Twelve Thousand Three Hundred Forty Five"
     * Example 3:
     *
     * Input: 1234567
     * Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     * Example 4:
     *
     * Input: 1234567891
     * Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
     */

    // group English words
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand,", "Million,", "Billion,"};

    public String numberToWords(int num) {
        // corner case
        if(num == 0)
            return "Zero";
        // i indicates Thousands
        int i = 0;
        // answer
        String ans = "";

        while (num > 0){
            // pick last three digits
            if(num % 1000 != 0){
                ans = helper(num % 1000) + THOUSANDS[i] + " " + ans;
            }
            num /= 1000;
            i ++;
        }
        return ans.trim();
    }

    private String helper(int num){
        // depends on
        if(num == 0){
            return "";
        }else if(num < 20){
            return LESS_THAN_20[num] + " ";
        }else if (num < 100){
            return TENS[num/10] + " " + helper(num % 10);
        }else {
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
        }
    }

    public void test(){
        int a = 1111134;
        System.out.println(numberToWords(a));
    }

}

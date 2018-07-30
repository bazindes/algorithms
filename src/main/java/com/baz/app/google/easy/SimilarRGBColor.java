package com.baz.app.google.easy;

import java.util.HashMap;
import java.util.Map;

public class SimilarRGBColor {

    public String similarRGB(String color){
        String [] hex = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
        int result = Integer.MIN_VALUE;
//        Map<String, Integer> map = new HashMap<>();
        String resStr = "";
        for (int i = 0; i < hex.length; i++) {
            for (int j = 0; j < hex.length; j++) {
                for (int k = 0; k < hex.length; k++) {
                    int first = (Integer.parseInt(color.substring(1, 3) , 16) - Integer.parseInt(hex[i] + hex[i] , 16));
                    int second = (Integer.parseInt(color.substring(3, 5) , 16) - Integer.parseInt(hex[j] + hex[j] , 16));
                    int third = (Integer.parseInt(color.substring(5, 7) , 16) - Integer.parseInt(hex[k] + hex[k] , 16));
                    int re = - (first * first) - (second * second) - (third * third);
                    if(result <= re){
                        result = re;
                        resStr = hex[i] + hex[i] + hex[j]+ hex[j]+ hex[k]+ hex[k];
//                        map.put(resStr , result);
                    }
                }
            }
        }
//        for (String e : map.keySet()){
//            System.out.println(e + " " + map.get(e));
//        }
        return resStr;
    }

    public void test(){
        //0, 1, 2, 3, 4, 5, 6, 7, 8, 9, a, b, c, d, e, f
        String s = "#AABBCC";
//        System.out.println(similarRGB(s));
        String color = "#09f166";
        System.out.println(similarRGB(color));
//        similarRGB(color);

    }

}

package com.baz.app.google.easy;

import java.util.concurrent.ConcurrentHashMap;

public class LoggerRateLimiter {

    private ConcurrentHashMap<String,Integer> concurrentHashMap;

    public LoggerRateLimiter(){
        concurrentHashMap = new ConcurrentHashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message){
        if(concurrentHashMap.contains(message)){
            int lastTime = concurrentHashMap.get(message);
            if(timestamp - lastTime > 9){
                concurrentHashMap.put(message , timestamp);
                return true;
            }else {
                return false;
            }
        }else{
            concurrentHashMap.put(message , timestamp);
            return true;
        }
    }
}

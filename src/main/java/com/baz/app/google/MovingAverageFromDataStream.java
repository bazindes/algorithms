package com.baz.app.google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverageFromDataStream {
    //my approach
    private List<Integer> list;
    private int size;

    public MovingAverageFromDataStream(int size){
        this.size = size;
        list = new LinkedList<Integer>();
    }

    public double next(int val){
        double d = 0.0;
        list.add(val);
        if(list.size() == size) list.remove(0);
        for (int i = 0; i < list.size(); i++) {
            d += list.get(i);
        }
        return d/(size>list.size() ? list.size():size);
    }

    //O(1) approach
    Queue<Integer> queue = new LinkedList<>();
    int count = 0;
    int sum = 0;

    public double next2(int val){
        if(count == size){
            sum = sum - (int)queue.remove();
            sum += val;
            queue.add(val);
        }else{
            count ++;
            sum += val;
            queue.add(val);
        }
        return (double) sum / (double) count;
    }


}

package com.baz.app.google;

import java.util.LinkedList;
import java.util.List;

public class MovingAverageFromDataStream {

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
}

package com.baz.app.lc.easy;

import com.baz.app.Interface.Facebook.Facebook;
import com.baz.app.Interface.Google.Google;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MovingAverageFromDataStream implements Facebook, Google {

    /**
     * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
     *
     * Example:
     *
     * MovingAverage m = new MovingAverage(3);
     * m.next(1) = 1
     * m.next(10) = (1 + 10) / 2
     * m.next(3) = (1 + 10 + 3) / 3
     * m.next(5) = (10 + 3 + 5) / 3
     */

    Queue<Integer> q;
    double sum;
    int size;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        q = new LinkedList<>();
        sum = 0;
        this.size = size;
    }

    public double next(int val) {
        q.offer(val);
        sum += val;

        if(q.size() > size)
            sum -= q.poll();

        if(q.size() < size)
            return sum / q.size();
        else return sum / size;
    }


    //my approach
    private List<Integer> list;

    public void MovingAverageFromDataStream2(int size){
        this.size = size;
        list = new LinkedList<Integer>();
    }

    public double next1(int val){
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

    public double next2(int val){
        if(count == queue.size()){
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

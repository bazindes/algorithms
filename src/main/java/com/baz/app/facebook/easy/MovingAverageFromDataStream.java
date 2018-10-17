package com.baz.app.facebook.easy;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageFromDataStream {

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

}

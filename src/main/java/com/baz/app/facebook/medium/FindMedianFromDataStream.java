package com.baz.app.facebook.medium;

import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value.
     * So the median is the mean of the two middle value.
     *
     * For example,
     * [2,3,4], the median is 3
     * [2,3], the median is (2 + 3) / 2 = 2.5
     *
     * Design a data structure that supports the following two operations:
     * void addNum(int num) - Add a integer number from the data stream to the data structure.
     * double findMedian() - Return the median of all elements so far.
     *
     * Example:
     *
     * addNum(1)
     * addNum(2)
     * findMedian() -> 1.5
     * addNum(3)
     * findMedian() -> 2
     *
     *
     * Follow up:
     *
     * If all integer numbers from the stream are between 0 and 100, how would you optimize it?
     * If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?
     */

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    /** initialize your data structure here. */
    public FindMedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((i,j) -> j - i);
    }

    public void addNum(int num) {
        min.offer(num);
        max.offer(min.peek());
        min.poll();

        if(min.size() < max.size()){
            min.offer(max.peek());
            max.poll();
        }

    }

    public double findMedian() {
        return min.size() > max.size() ? min.peek() : (min.peek() + max.peek()) * 0.5;
    }

}

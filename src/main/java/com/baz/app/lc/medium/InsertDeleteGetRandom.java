package com.baz.app.lc.medium;

import com.baz.app.Interface.Facebook.Facebook;

import java.util.*;

public class InsertDeleteGetRandom implements Facebook {

    /**
     * Design a data structure that supports all following operations in average O(1) time.
     *
     * insert(val): Inserts an item val to the set if not already present.
     * remove(val): Removes an item val from the set if present.
     * getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
     * Example:
     *
     * // Init an empty set.
     * RandomizedSet randomSet = new RandomizedSet();
     *
     * // Inserts 1 to the set. Returns true as 1 was inserted successfully.
     * randomSet.insert(1);
     *
     * // Returns false as 2 does not exist in the set.
     * randomSet.remove(2);
     *
     * // Inserts 2 to the set, returns true. Set now contains [1,2].
     * randomSet.insert(2);
     *
     * // getRandom should return either 1 or 2 randomly.
     * randomSet.getRandom();
     *
     * // Removes 1 from the set, returns true. Set now contains [2].
     * randomSet.remove(1);
     *
     * // 2 was already in the set, so return false.
     * randomSet.insert(2);
     *
     * // Since 2 is the only number in the set, getRandom always return 2.
     * randomSet.getRandom();
     */

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else {
            map.put(val, list.size());
            list.add(val);
            return true;
        }
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val)){
            int temp = map.get(val);
            if(temp < list.size() - 1){
                int cur = list.get(list.size() - 1);
                list.set(temp , cur);
                map.put(cur , temp);
            }
            map.remove(val);
            list.remove(list.size() - 1);
            return true;
        }else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }


    public void test(InsertDeleteGetRandom insertDeleteGetRandom){
    // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        System.out.println(insertDeleteGetRandom.insert(1));

    // Returns false as 2 does not exist in the set.
        System.out.println(insertDeleteGetRandom.remove(2));

    // Inserts 2 to the set, returns true. Set now contains [1,2].
        System.out.println(insertDeleteGetRandom.insert(2));

    // getRandom should return either 1 or 2 randomly.
        System.out.println(insertDeleteGetRandom.getRandom());

    // Removes 1 from the set, returns true. Set now contains [2].
        System.out.println(insertDeleteGetRandom.remove(1));

    // 2 was already in the set, so return false.
        System.out.println(insertDeleteGetRandom.insert(2));

    // Since 2 is the only number in the set, getRandom always return 2.
        System.out.println(insertDeleteGetRandom.getRandom());
    }
}

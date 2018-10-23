package com.baz.app.lc.easy;

import com.baz.app.Interface.Google.Google;

import java.util.ArrayList;
import java.util.List;

public class StudentsLine implements Google {

    /**
     * . 给一个int array分组，比如[7,8,4,9,1,6,5,7], 就要分成三组[7] [8,4] [9,1,6,5,7], 因为每组头一个都是最大的数，输出是一共能分成多少组。
     * 我就定义了一个count，一个height = array[0], 然后loop整个array，如果有比height小的那就continue，如果比height大，那就把那个数给height然后count++,
     * 最后输出count
     */

    public int count(int[] nums){
        // corner case
        if(nums == null || nums.length == 0) return -1;
        // at least 1 line
        List<Integer> groups = new ArrayList<>();
        groups.add(nums[0]);

        for (int i = 1; i< nums.length; i ++){
            if(groups.get(groups.size() - 1) < nums[i])
                groups.add(nums[i]);
            else
                bsHelper(groups, nums[i]);
        }

        return groups.size();
    }

    private void bsHelper(List<Integer> nums, int tar){
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi){
            int mid = lo + (hi - lo) / 2;
            if(nums.get(mid) == tar) {
                lo = mid;
                break;
            } else if(nums.get(mid) > tar){
                hi = mid - 1;
            } else{
                lo = mid + 1;
            }
        }
        nums.set(lo, tar);
    }

    public void test(){
        int[] nums = {7,8,4,9,1,6,5,7};
        System.out.println(count(nums));
        nums = new int[]{5, 4, 3, 6, 1};
        System.out.println(count(nums));
        nums = new int[]{3,1,2,5,3};
        System.out.println(count(nums));
        nums = new int[]{1,2,3,4,5};
        System.out.println(count(nums));
    }


    public int solution(int[] A) {
        // write your code in Java SE 8
        // corner case, no students
        if(A == null || A.length == 0) return 0;

        // general code
        // use list to store created rows
        List<Integer> rows = new ArrayList<>();

        // simulate students arrive one by one
        for(int i = 0; i < A.length; i ++){
            // if the first one, create a new row
            if(i == 0){
                rows.add(A[i]);
            }else{
                // otherwise, check the previous rows, look for one row that all students in this row are taller than current student, pick the minimum height one in order to create less row,
                // since we stored previous rows in ascending order, we can use binary search to find the minimum height in each row, and we only need to track the minimum height in each row since only when the next student is not taller than previous students in one row, we can put next student in that row
                // if the previous students are smaller than next one, create new row
                if(rows.get(rows.size() - 1) < A[i]){
                    rows.add(A[i]);
                }else{
                    // otherwise find one row to insert current student
                    bsHelper2(rows, A[i]);
                }

            }
        }

        // how many rows created
        return rows.size();

    }

    // binary search helper, binary search the smallest number in rows which is greater than tar, then change it to tar
    private void bsHelper2(List<Integer> rows, int tar){
        if(rows == null || rows.size() == 0) return;
        int lo = 0;
        int hi = rows.size() - 1;
        // search for smallest one
        while(lo < hi){
            int mid = lo + (hi - lo) / 2;
            // if the previous students in one row are taller than next one, seach in left side
            if(rows.get(mid) >= tar){
                hi = mid - 1;
            }else{
                // otherwise, seach in right side
                lo = mid + 1;
            }
        }
        // update rows, keep tracking the smallest height in each row
        rows.set(lo, tar);
    }



}

package com.anurag.binarysearch;

/*
    Problem:
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
*/

import java.util.Arrays;

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] ans = new int[2];
        ans[0] = binarysearch(nums, target, true);
        ans[1] = binarysearch(nums, target, false);

        System.out.println(Arrays.toString(ans));
    }
    static int binarysearch(int[] nums, int target, boolean isStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(target > nums[mid]) {
                start = mid + 1;
            } else if(target < nums[mid]) {
                end = mid - 1;
            } else {
                ans = mid;

                if(isStartIndex) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return ans;
    }
}


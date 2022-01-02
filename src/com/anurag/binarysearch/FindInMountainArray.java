package com.anurag.binarysearch;

/*
    Problems:
    https://leetcode.com/problems/find-in-mountain-array/
*/

public class FindInMountainArray {
    int binarySearch(MountainArray mountainArr, boolean isAsc, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == mountainArr.get(mid)) {
                return mid;
            }

            if(isAsc) {
                if(target > mountainArr.get(mid)) {
                    start = mid + 1;
                } else if(target < mountainArr.get(mid)) {
                    end = mid - 1;
                }
            } else {
                if(target > mountainArr.get(mid)) {
                    end = mid - 1;
                } else if(target < mountainArr.get(mid)) {
                    start = mid + 1;
                }
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int len = mountainArr.length();
        int end = len - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }


        int firstTry = binarySearch(mountainArr, true, 0, start, target);

        if(firstTry != -1) {
            return firstTry;
        }

        return binarySearch(mountainArr, false, start+1, len-1, target);

    }
}

package com.anurag.binarysearch;

/*
    Problem:
    https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
*/

public class PositionInInfiniteSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;

        System.out.println(ans(arr, target));
    }

    static int ans(int[] arr, int target) {
        int start = 0;
        int end = 1;

        while(target > arr[end]) {
            int newStart = end + 1;

            end += (end - start + 1) * 2;
            start = newStart;
        }

        return binarysearch(arr, start, end, target);
    }

    static int binarysearch(int[] arr, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == arr[mid]) {
                return mid;
            }

            if(target > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}

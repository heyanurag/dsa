package com.anurag.binarysearch;

/**
 * Find the floor of a number
 *
 * ex.
 * arr = [12,17,25,27,45]
 *
 * if target is 19,
 * floor will be 17
 *
 */

public class Floor {
    public static void main(String[] args) {
        int[] arr = {-18, -12, -4, 0, 2, 3, 4, 15, 16, 18, 22, 45, 89};
        int target = -19;
        int ans = floor(arr, target);
        System.out.println("Floor: " + ans);
    }

    static int floor(int[] arr, int target) {
        if(target < arr[0]) {
            return -1;
        }

        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == arr[mid]) {
                return mid;
            }

            if(target > arr[mid]) {
                start = mid + 1;
            } else if(target < arr[mid]) {
                end = mid - 1;
            }
        }

        return end;
    }
}

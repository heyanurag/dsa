package com.anurag.binarysearch;

/*
    Problem:
    https://leetcode.com/problems/find-smallest-letter-greater-than-target/
*/

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'd';
        System.out.println(nextGreatestLetter(letters, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int n = letters.length;
        int end = n - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target < letters[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return letters[start % n];
    }
}

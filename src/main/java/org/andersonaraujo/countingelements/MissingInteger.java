package org.andersonaraujo.countingelements;

import java.util.Arrays;

/**
 * Result at codility: https://codility.com/demo/results/demoS2Q8P5-82W/
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int solution(int[] A); }
 * <p>
 * that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0)
 * that does not occur in A.
 * <p>
 * For example, given:
 * <p>
 * A[0] = 1
 * A[1] = 3
 * A[2] = 6
 * A[3] = 4
 * A[4] = 1
 * A[5] = 2
 * the function should return 5.
 * <p>
 * Assume that:
 * <p>
 * N is an integer within the range [1..100,000];
 * each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].
 * Complexity:
 * <p>
 * expected worst-case time complexity is O(N);
 * expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input
 * arguments).
 * Elements of input arrays can be modified.
 *
 * @author andersonaraujo on 07/09/2015.
 */
public class MissingInteger {

    public int solution(int[] values) {

        // Sort the array
        Arrays.sort(values);

        // Iterates over the array to find the missing element
        int previousValue = -1;
        int possibleMissingValue = 1;
        for (int value : values) {
            // Ignore negative numbers and numbers that appears more than one time in the array
            if (value <= 0 || value == previousValue) {
                continue;
            }
            if (value != possibleMissingValue) {
                return possibleMissingValue;
            }
            possibleMissingValue++;
            previousValue = value;
        }

        return possibleMissingValue;
    }

}

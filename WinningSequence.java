// Amazon 2021 OA
// WinningSequence
// Construct sequence using a specified number of integers within a range. The sequence must be strictly increasing at first and then strictly decreasing. The goal is to maximize the sequence array elements starting from the beginning.

// For example, [4, 5, 4, 3, 2] beats [3,4,5,4,3] because its first element is larger, and [4, 5, 6, 5, 4]
// beats [4,5,4,3,2] because its third element is larger. Given the length of the sequence and the range
// of integers, return the winning sequence. If it is not possible to construct such a sequence, return -1.
// Write an algorithm that returns a winning sequence and -1 if the sequence is not possible

// Input
// The input to the function/method consists of three arguments:
// num : an integer representing the size of sequence to create
// lowerEnd : an integer representing the lower end of integer range
// upperEnd :an integer representing the upper end of integer range.

// Output
// Return a list of integers representing the winning sequence and if the sequence is not possible then
// return a list with an integer -1.

// Constraints
// 3 <= num <= 10^5
// 1 < = lowerEnds <= upperEnds <= 10^5

// Examples
// Example 1:
// Input: num = 5, LowerEnd = 3 , upperEnd = 10
// Output: [9,10,9,8,7]

import java.util.*;
import java.lang.*;

class WinningSequence {

    public static List<Integer> winningSequence(int n, int lower, int upper) {
        System.out.println(String.format("input n = %d, lower = %d, upper = %d", n, lower, upper));


        List<Integer> result = new ArrayList<>();

        int rangeLength = upper - lower + 1;

        // We can construct the max length equals to (length of range) * 2 - 1
        if (n > rangeLength * 2 - 1) {
            result.add(-1);
            return result;
        }

        // Construct a sequence from lower to upper (index 0 ~ range.length-1)
        int[] range = new int[rangeLength * 2 - 1];
        int index = 0;
        for (int i = lower; i <= upper; i++) {
            range[index] = i;
            index++;
        }

        for (int i = upper-1; i >= lower; i--) {
            range[index] = i;
            index++;
        }
        // range = [lower, lower +1 , ...., upper, upper-1, ... , lower]

        // The start index should be the upper - 1 element index
        // or range.length - n (if n > rangeSize or range / 2)
        int start = Math.min(rangeLength - 2, range.length - n);

        for (int i = start; i < range.length; i++) {
            result.add(range[i]);
            if (result.size() == n) {
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(winningSequence(5, 3, 10));
        System.out.println(winningSequence(8, 3, 10));
    }
}
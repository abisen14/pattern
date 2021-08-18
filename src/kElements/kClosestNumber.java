package kElements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

//Given a sorted number array and two integers ‘K’ and ‘X’, find ‘K’ closest numbers to ‘X’ in the array.
// Return the numbers in the sorted order. ‘X’ is not necessarily present in the array.

//Utilizing a similar approach, we can find the numbers closest to ‘X’ through the following algorithm:
//
//Since the array is sorted, we can first find the number closest to ‘X’ through Binary Search. Let’s say that number is ‘Y’.
//The ‘K’ closest numbers to ‘Y’ will be adjacent to ‘Y’ in the array. We can search in both directions of ‘Y’ to find the closest numbers.
//We can use a heap to efficiently search for the closest numbers. We will take ‘K’ numbers in both directions of ‘Y’ and push them in a
// Min Heap sorted by their absolute difference from ‘X’. This will ensure that the numbers with the smallest difference from ‘X’ (i.e., closest to ‘X’)
// can be extracted easily from the Min Heap.
//Finally, we will extract the top ‘K’ numbers from the Min Heap to find the required numbers.

//Input: [5, 6, 7, 8, 9], K = 3, X = 7
//Output: [6, 7, 8]

public class kClosestNumber {
    static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class KClosestElements {

        public  List<Integer> findClosestElements(int[] arr, int K, Integer X) {
            int index = binarySearch(arr, X);
            int low = index - K, high = index + K;
            low = Math.max(low, 0); // 'low' should not be less than zero
            high = Math.min(high, arr.length - 1); // 'high' should not be greater the size of the array

            PriorityQueue<Entry> minHeap = new PriorityQueue<>((n1, n2) -> n1.key - n2.key);
            // add all candidate elements to the min heap, sorted by their absolute difference from 'X'
            for (int i = low; i <= high; i++)
                minHeap.add(new Entry(Math.abs(arr[i] - X), i));

            // we need the top 'K' elements having smallest difference from 'X'
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < K; i++)
                result.add(arr[minHeap.poll().value]);

            Collections.sort(result);
            return result;
        }

        private  int binarySearch(int[] arr, int target) {
            int low = 0;
            int high = arr.length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[mid] == target)
                    return mid;
                if (arr[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if (low > 0) {
                return low - 1;
            }
            return low;
        }
    }
}

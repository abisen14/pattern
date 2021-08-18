package twoHeap;

import java.util.Collections;
import java.util.PriorityQueue;

//The time complexity of our algorithm is O(N*K)O(N∗K) where ‘N’ is the total number of elements in the input array and ‘K’ is the size of the sliding window. This is due to the fact that we are going through all the ‘N’ numbers and, while doing so, we are doing two things:
//
//Inserting/removing numbers from heaps of size ‘K’. This will take O(logK)O(logK)
//Removing the element going out of the sliding window. This will take O(K)O(K) as we will be searching this element in an array of size ‘K’ (i.e., a heap).

public class slidingWindowMedian {
    class SlidingWindowMedian {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public double[] findSlidingWindowMedian(int[] nums, int k) {
            double[] result = new double[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {
                if (maxHeap.size() == 0 || maxHeap.peek() >= nums[i]) {
                    maxHeap.add(nums[i]);
                } else {
                    minHeap.add(nums[i]);
                }
                rebalanceHeaps();

                if (i - k + 1 >= 0) { // if we have at least 'k' elements in the sliding window
                    // add the median to the the result array
                    if (maxHeap.size() == minHeap.size()) {
                        // we have even number of elements, take the average of middle two elements
                        result[i - k + 1] = maxHeap.peek() / 2.0 + minHeap.peek() / 2.0;
                    } else { // because max-heap will have one more element than the min-heap
                        result[i - k + 1] = maxHeap.peek();
                    }

                    // remove the element going out of the sliding window
                    int elementToBeRemoved = nums[i - k + 1];
                    if (elementToBeRemoved <= maxHeap.peek()) {
                        maxHeap.remove(elementToBeRemoved);
                    } else {
                        minHeap.remove(elementToBeRemoved);
                    }
                    rebalanceHeaps();
                }
            }
            return result;
        }

        private void rebalanceHeaps() {
            // either both the heaps will have equal number of elements or max-heap will have
            // one more element than the min-heap
            if (maxHeap.size() > minHeap.size() + 1)
                minHeap.add(maxHeap.poll());
            else if (maxHeap.size() < minHeap.size())
                maxHeap.add(minHeap.poll());
        }
    }
}

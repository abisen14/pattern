package twoHeap;

//Input: Intervals [[2,3], [3,4], [5,6]]
//Output: [1, 2, -1]
//Explanation: The next interval of [2,3] is [3,4] having index ‘1’.
// Similarly, the next interval of [3,4] is [5,6] having index ‘2’. There is no next interval for [5,6] hence we have ‘-1’.

import java.util.PriorityQueue;

//We can utilize the Two Heaps approach. We can push all intervals into two heaps: one heap to sort the intervals on maximum start time (let’s call it maxStartHeap)
// and the other on maximum end time (let’s call it maxEndHeap). We can then iterate through all intervals of the `maxEndHeap’ to find their next interval.
// Our algorithm will have the following steps:
//
//Take out the top (having highest end) interval from the maxEndHeap to find its next interval. Let’s call this interval topEnd.
//Find an interval in the maxStartHeap with the closest start greater than or equal to the start of topEnd. Since maxStartHeap is sorted by ‘start’ of intervals,
// it is easy to find the interval with the highest ‘start’. Let’s call this interval topStart.
//Add the index of topStart in the result array as the next interval of topEnd. If we can’t find the next interval, add ‘-1’ in the result array.
//Put the topStart back in the maxStartHeap, as it could be the next interval of other intervals.
//Repeat the steps 1-4 until we have no intervals left in maxEndHeap.
public class nextInterval {
    class Interval {
        int start = 0;
        int end = 0;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    class NextInterval {
        public int[] findNextInterval(Interval[] intervals) {
            int n = intervals.length;
            // heap for finding the maximum start
            PriorityQueue<Integer> maxStartHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].start - intervals[i1].start);
            // heap for finding the minimum end
            PriorityQueue<Integer> maxEndHeap = new PriorityQueue<>(n, (i1, i2) -> intervals[i2].end - intervals[i1].end);
            int[] result = new int[n];
            for (int i = 0; i < intervals.length; i++) {
                maxStartHeap.offer(i);
                maxEndHeap.offer(i);
            }

            // go through all the intervals to find each interval's next interval
            for (int i = 0; i < n; i++) {
                int topEnd = maxEndHeap.poll(); // let's find the next interval of the interval which has the highest 'end'
                result[topEnd] = -1; // defaults to -1
                if (intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                    int topStart = maxStartHeap.poll();
                    // find the the interval that has the closest 'start'
                    while (!maxStartHeap.isEmpty() && intervals[maxStartHeap.peek()].start >= intervals[topEnd].end) {
                        topStart = maxStartHeap.poll();
                    }
                    result[topEnd] = topStart;
                    maxStartHeap.add(topStart); // put the interval back as it could be the next interval of other intervals
                }
            }
            return result;
        }
    }
}

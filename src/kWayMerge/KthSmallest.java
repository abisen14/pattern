package kWayMerge;

import java.util.List;
import java.util.PriorityQueue;
//Problem 1: Given ‘M’ sorted arrays, find the median number among all arrays.
//
//Solution: This problem is similar to our parent problem with K=Median.
//atrix
// So if there are ‘N’ total numbers in all the arrays we need to find the K’th minimum number where K=N/2K=N/2.
//
//Problem 2: Given a list of ‘K’ sorted arrays, merge them into one sorted list.
//
//Solution: This problem is similar to Merge K Sorted Lists except that the input is a list of arrays compared to LinkedLists.
// To handle this, we can use a similar approach as discussed in our parent problem by keeping a track of the array and the element indices.
public class KthSmallest {
    class Node {
        int elementIndex;
        int arrayIndex;

        Node(int elementIndex, int arrayIndex) {
            this.elementIndex = elementIndex;
            this.arrayIndex = arrayIndex;
        }
    }

    class KthSmallestInMSortedArrays {

        public int findKthSmallest(List<Integer[]> lists, int k) {
            PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
                    (n1, n2) -> lists.get(n1.arrayIndex)[n1.elementIndex] - lists.get(n2.arrayIndex)[n2.elementIndex]);

            // put the 1st element of each array in the min heap
            for (int i = 0; i < lists.size(); i++)
                if (lists.get(i) != null)
                    minHeap.add(new Node(0, i));

            // take the smallest (top) element form the min heap, if the running count is equal to k return the number
            // if the array of the top element has more elements, add the next element to the heap
            int numberCount = 0, result = 0;
            while (!minHeap.isEmpty()) {
                Node node = minHeap.poll();
                result = lists.get(node.arrayIndex)[node.elementIndex];
                if (++numberCount == k)
                    break;
                node.elementIndex++;
                if (lists.get(node.arrayIndex).length > node.elementIndex)
                    minHeap.add(node);
            }
            return result;
        }
    }
}

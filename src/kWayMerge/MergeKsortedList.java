package kWayMerge;

import java.util.PriorityQueue;

public class MergeKsortedList {
    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    class MergeKSortedLists {

        public ListNode merge(ListNode[] lists) {
            PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>((n1, n2) -> n1.value - n2.value);

            // put the root of each list in the min heap
            for (ListNode root : lists)
                if (root != null)
                    minHeap.add(root);

            // take the smallest (top) element form the min-heap and add it to the result;
            // if the top element has a next element add it to the heap
            ListNode resultHead = null, resultTail = null;
            while (!minHeap.isEmpty()) {
                ListNode node = minHeap.poll();
                if (resultHead == null) {
                    resultHead = resultTail = node;
                } else {
                    resultTail.next = node;
                    resultTail = resultTail.next;
                }
                if (node.next != null)
                    minHeap.add(node.next);
            }

            return resultHead;
        }
    }
}

package linkedListReversal;
//head
//    1
//    2
//    3
//    4
//    5
//    null
//    1
//    4
//    3
//    2
//    5
//    null
public class reverseSubList {
    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    class ReverseSubList {

        public static ListNode reverse(ListNode head, int p, int q) {
            if (p == q)
                return head;

            // after skipping 'p-1' nodes, current will point to 'p'th node
            ListNode current = head, previous = null;
            for (int i = 0; current != null && i < p - 1; ++i) {
                previous = current;
                current = current.next;
            }

            // we are interested in three parts of the LinkedList, part before index 'p', part between 'p' and
            // 'q', and the part after index 'q'
            ListNode lastNodeOfFirstPart = previous; // points to the node at index 'p-1'
            // after reversing the LinkedList 'current' will become the last node of the sub-list
            ListNode lastNodeOfSubList = current;
            ListNode next = null; // will be used to temporarily store the next node
            // reverse nodes between 'p' and 'q'
            for (int i = 0; current != null && i < q - p + 1; i++) {
                next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }

            // connect with the first part
            if (lastNodeOfFirstPart != null)
                lastNodeOfFirstPart.next = previous; // 'previous' is now the first node of the sub-list
            else // this means p == 1 i.e., we are changing the first node (head) of the LinkedList
                head = previous;

            // connect with the last part
            lastNodeOfSubList.next = current;

            return head;
        }
}

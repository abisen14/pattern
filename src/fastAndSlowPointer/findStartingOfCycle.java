package fastAndSlowPointer;

public class findStartingOfCycle {
    class ListNode {
        int value = 0;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }
    }

    class LinkedListCycleStart {

        public ListNode findCycleStart(ListNode head) {
            int cycleLength = 0;
            // find the LinkedList cycle
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
                if (slow == fast) { // found the cycle
                    cycleLength = calculateCycleLength(slow);
                    break;
                }
            }

            return findStart(head, cycleLength);
        }

        private  int calculateCycleLength(ListNode slow) {
            ListNode current = slow;
            int cycleLength = 0;
            do {
                current = current.next;
                cycleLength++;
            } while (current != slow);

            return cycleLength;
        }

        private  ListNode findStart(ListNode head, int cycleLength) {
            ListNode pointer1 = head, pointer2 = head;
            // move pointer2 ahead 'cycleLength' nodes
            while (cycleLength > 0) {
                pointer2 = pointer2.next;
                cycleLength--;
            }

            // increment both pointers until they meet at the start of the cycle
            while (pointer1 != pointer2) {
                pointer1 = pointer1.next;
                pointer2 = pointer2.next;
            }

            return pointer1;
        }
    }
}

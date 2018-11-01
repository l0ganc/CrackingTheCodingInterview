package LinkedLists;

import CtCILibrary.LinkedListNode;

public class LongDectection_2_8 {


    public static void main(String[] args) {
        int list_length = 100;
        int k = 10;

        // Create linked list
        LinkedListNode[] nodes = new LinkedListNode[list_length];
        for (int i = 0; i < list_length; i++) {
            nodes[i] = new LinkedListNode(i, null, i > 0 ? nodes[i - 1] : null);
        }

        // Create loop;
        nodes[list_length - 1].next = nodes[list_length - k];

        LinkedListNode loop = FindBeginning(nodes[0]);
        if (loop == null) {
            System.out.println("No Cycle.");
        } else {
            System.out.println(loop.data);
        }
    }

    private static LinkedListNode FindBeginning(LinkedListNode head) {
        LinkedListNode slow = head;
        LinkedListNode fast = head;

        // finding meeting point
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // error check - there is no meeting point, and therefore no loop
        if (fast == null || fast.next == null) {
            return null;
        }

        /**
         * move slow to head
         * keep fast at meeting point
         * each are k steps from the loop start
         * if they move at the same pace, they must meet at the same point
         */
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }


        // both now point to the start of the loop
        return slow;


    }
}

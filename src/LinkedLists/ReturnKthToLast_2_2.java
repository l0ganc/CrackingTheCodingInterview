package LinkedLists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;


public class ReturnKthToLast_2_2 {



    public static void main(String[] args) {
        int[] array = {0, 1, 2, 3, 4, 5, 6};
        LinkedListNode head = AssortedMethods.createLinkedListFromArray(array);
        for (int i = 0; i <= array.length + 1; i++) {
            printKthToLast(head, i);
        }
    }

    // recursive way，O(n) space and n is the number of elements in the linkedlist
    private static int printKthToLast(LinkedListNode head, int k) {
        if (head == null) {
            return 0;
        }

        int index = printKthToLast(head.next, k) + 1;
        if (index == k) {
            System.out.println(k + "th to last node is " + head.data);
        }
        return index;
    }


    // iterative

    /**
     *  We can use twp pointers p1 and p2. We place them k nodes apart in the linked list by
     *  putting p2 at the beginning and moving p1 k nodes into the list.
     *  Then we move them in the same pace, p1 will hit the end of the list after LENGTH - k steps,
     *  At that point, p2 will be LENGTH - k nodes into the list,
     *  or k nodes from the end
     * @param head
     * @param k
     * @return
     */
    private static LinkedListNode printKthToLast2(LinkedListNode head, int k) {
        LinkedListNode p1 = head;
        LinkedListNode p2 = head;

        // move p1 k nodes into the list
        for (int i = 0; i < k; i++) {
            if (p1 == null) {
                return null;
            }
            p1 = p1.next;
        }

        // move them in the same pace. When p1 hit the end, p2 will be in the right place;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }


}

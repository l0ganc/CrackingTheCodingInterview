package LinkedLists;

import CtCILibrary.AssortedMethods;
import CtCILibrary.LinkedListNode;


public class DeleteMiddleNode_2_3 {
    public static void main(String[] args) {
        LinkedListNode head = AssortedMethods.randomLinkedList(10, 0, 10);
        System.out.println(head.printForward());
        deleteNode(head.next.next.next.next); // delete node 4
        System.out.println(head.printForward());
    }

    private static boolean deleteNode(LinkedListNode n) {
        if (n == null || n.next == null) {
            return false;
        }

        LinkedListNode next = n.next;
        n.data = next.data;
        n.next = next.next;
        return true;
    }


}

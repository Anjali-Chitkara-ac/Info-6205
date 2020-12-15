package Final;

import java.util.List;

class ListNode{
    int val;
    ListNode next;

    public ListNode(){

    }
    public ListNode(int val){
        this.val= val;
        this.next = null;
    }
}

public class MergeSortedLL {
    /*Q2
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/
    public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while (l1!=null && l2!=null){
            if(l1.val<=l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }

        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        MergeSortedLL obj = new MergeSortedLL();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(9);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        l2.next.next.next = new ListNode(8);
        l2.next.next.next.next = new ListNode(10);

        ListNode result = obj.mergeTwoLists(l1,l2);
        while (result!=null){
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

}

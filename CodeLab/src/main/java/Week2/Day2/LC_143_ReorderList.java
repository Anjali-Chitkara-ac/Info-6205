package Week2.Day2;

public class LC_143_ReorderList {
    //break in half -> return the second node
    //reverse the second node
    //merge the 2

    public void reorderList(ListNode head) {
        if(head==null){
            return;
        }
        ListNode secondHalf = breakInHalf(head);
        secondHalf = reverseList(secondHalf);
        ListNode temp = head;
        while (temp!=null && secondHalf!=null){
            ListNode n = temp.next;
            ListNode m = secondHalf.next;

            temp.next = secondHalf;
            secondHalf.next = n;
            secondHalf=m;
            temp = n;
        }
    }

    public ListNode breakInHalf(ListNode head){
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = head;
        ListNode slow = head;
        while (fast!=null){
            fast=fast.next;
            if(fast!=null){
                fast=fast.next;
                slow=slow.next;
            }
        }
        ListNode n = slow.next;
        slow.next = null;
        return n;
    }

    public ListNode reverseList(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode prev = head;
        ListNode curr = prev.next;
        ListNode next = curr.next;
        head.next=null;
        while (curr!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            if(curr!=null) {
                next = next.next;
            }
        }
        return prev;
    }

}

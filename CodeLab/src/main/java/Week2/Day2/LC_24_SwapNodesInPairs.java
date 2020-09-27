package Week2.Day2;

public class LC_24_SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode next = curr.next;

        while (curr!=null && next!=null){ //1234
                int a = curr.val;
                int b = next.val;
                curr.val = b;
                next.val = a;

                curr = curr.next.next;
                if(curr!=null) {
                    next = curr.next;
                }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        LC_24_SwapNodesInPairs obj = new LC_24_SwapNodesInPairs();
        ListNode n = obj.swapPairs(head);
        while (n!=null){
            System.out.print(n.val+"->");
            n=n.next;
        }
    }
}

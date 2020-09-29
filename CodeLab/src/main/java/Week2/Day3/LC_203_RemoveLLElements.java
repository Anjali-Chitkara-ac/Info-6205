package Week2.Day3;

public class LC_203_RemoveLLElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode();
        ListNode maintain = dummy;
        dummy.next = head;

        ListNode temp = dummy;
        while (temp.next!=null){
            if(temp.next.val!=val){//01263456
                temp=temp.next;
                dummy=dummy.next;
            }else {// if == val
                if(temp.next!=null) {
                    dummy.next = dummy.next.next;//0123456
                }else {
                    dummy.next=null;
                }
            }
        }
        return maintain.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);


        LC_203_RemoveLLElements obj = new LC_203_RemoveLLElements();
        ListNode n = obj.removeElements(head,6);
        while (n!=null){
            System.out.print(n.val+"->");
            n=n.next;
        }
    }
}

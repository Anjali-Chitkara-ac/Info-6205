package Sep16;

public class BinaryToInt {

    public ListNode reverseList(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode back = null;
        ListNode middle = head;
        ListNode front = middle.next;

        while (middle!=null){
            middle.next = back;
            back = middle;
            middle = front;
            if(front!=null) {
                front = front.next;
            }
        }
        return back;
    }

    public int getDecimalValue(ListNode head){
        ListNode n = reverseList(head);
        int total=0;
        int i=0;
        while (n!=null){
            int curr = (int) (Math.pow(2,i)*n.val);
            total = total + curr;
            n=n.next;
            i++;
        }
        return total;
    }

    public static void demo(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(0);
        head.next.next = new ListNode(1);

        BinaryToInt obj = new BinaryToInt();
        int a = obj.getDecimalValue(head);
        System.out.println(a);
    }
}

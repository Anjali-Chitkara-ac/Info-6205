package Week1.Day1;

//LC 328
public class OddEvenLL {
    public ListNode oddEvenList(ListNode head){
        if(head==null){
            return null;
        }
        ListNode result1 = new ListNode();
        ListNode result2 = new ListNode();

        ListNode tempR1 =result1;
        ListNode tempR2 = result2;
        while (head!=null){
            if(head.next!=null) {
                ListNode n1 = head; //12345
                ListNode n2 = head.next;//2345
                ListNode n3 = head.next.next;//345

                n1.next = null;//n1->1->null
                n2.next = null;//n2->2->null

                tempR1.next = n1;
                tempR2.next = n2;
                tempR1 = tempR1.next;
                tempR2 = tempR2.next;

                head = n3;
            }else{
                tempR1.next = head;
                tempR1 = tempR1.next;
                head = null;
            }
        }
        tempR1.next=result2.next;
        return result1.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        OddEvenLL obj = new OddEvenLL();
        ListNode a = obj.oddEvenList(head);
        while (a!=null){
            System.out.print(a.val+"->");
            a=a.next;
        }
    }
}

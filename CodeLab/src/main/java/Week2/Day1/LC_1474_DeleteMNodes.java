package Week2.Day1;

//LC 1474 delete n nodes after m nodes
public class LC_1474_DeleteMNodes {
    public ListNode deleteNodes(ListNode head, int m, int n) {
        ListNode temp = head;
        while (temp.next!=null) {
            for (int i = 1; i < m; i++) {
                if(temp==null){
                   break;
                }
                temp = temp.next;
            }
            //now we have the mth node
            ListNode temp2 = temp;
            for (int i = 0; i < n; i++) {
                if(temp2==null || temp2.next==null){
                    break;
                }
                temp2 = temp2.next;
            }
            //we have skipped n nodes
            if(temp2==null){
                if(temp==null){
                    break;
                }
                temp.next = null;
            }
            else {
                temp.next = temp2.next;
                temp = temp2.next;
                if(temp==null){
                    break;
                }
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);
//        head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);
//        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(12);
//        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(13);

        LC_1474_DeleteMNodes obj = new LC_1474_DeleteMNodes();
        ListNode a = obj.deleteNodes(head,3,5);
        while (a!=null){
            System.out.print(a.val+"->");
            a=a.next;
        }
    }
}

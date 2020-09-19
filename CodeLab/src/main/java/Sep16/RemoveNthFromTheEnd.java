package Sep16;

public class RemoveNthFromTheEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        if(temp.next==null){
            head = null;
            return head;
        }
        int length = 1;
        while (temp.next!=null){
            length++;
            temp = temp.next;
        }

        if(n == 1) {
            ListNode temp2 = head;
            while (temp2.next.next!=null){
                temp2 = temp2.next;
            }
            temp2.next = null;
            return head;
        }

        int i=0;
        int toBeRemoved = length-n; //index of the node to be removed

        ListNode temp1 = head;
        while (i<toBeRemoved){
            temp1 = temp1.next;
            i++;
        }
        //temp1 =  node to be removed

        int copy = temp1.next.val;
        temp1.val = copy;
        temp1.next = temp1.next.next;
        return head;
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n){
        if(head==null || head.next==null){
            return null;
        }
        ListNode front = head;
        ListNode back = head;
        int i =0;
        while (i<n){
            front = front.next;
            i++;
        }
        while (front != null && front.next!=null){
            front = front.next;
            back = back.next;
        }
        back.next = back.next.next;
        return head;
    }
     */

    public static void demo(){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        RemoveNthFromTheEnd obj = new RemoveNthFromTheEnd();
        ListNode temp = obj.removeNthFromEnd(head, 2);
        //System.out.println(temp.val);
        while (temp!=null){
            System.out.print(temp.val+"->");
            temp = temp.next;
        }

    }
}

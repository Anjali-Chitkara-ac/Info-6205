package Sep16;

//LeetCode 83
public class RemoveDuplicatesFromSortedLL {

    public ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null){
            return head;
        }
        ListNode curr = head;
        ListNode temp = curr.next;
        while (temp!=null){
            if(temp.val==curr.val){
                ListNode a = temp.next;
                curr.next = a;

                temp = a;//incrementing temp
                //do not increment curr
            }
            else{//increment both
                curr = curr.next;
                temp = temp.next;
            }
        }
        return head;
    }

    public static void demo(){
        ListNode head = new ListNode(2);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);


        RemoveDuplicatesFromSortedLL obj = new RemoveDuplicatesFromSortedLL();
        ListNode a = obj.deleteDuplicates(head);

        while (a!=null){
            System.out.print(a.val+"->");
            a = a.next;
        }
    }
}

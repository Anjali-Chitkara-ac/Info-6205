package Sep16;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode small = new ListNode();
        ListNode big = new ListNode();
        ListNode small_temp = small;
        ListNode big_temp = big;
        ListNode temp = head;
        while (temp!=null) {
            if(temp.val>=x){ //43252
                big_temp.next = temp;
                temp = temp.next;
                big_temp = big_temp.next;
                big_temp.next = null;
            }
            else if(temp.val<x){ //143252
                small_temp.next = temp;
                temp = temp.next;
                small_temp = small_temp.next;
                small_temp.next = null;
            }
        }
        small_temp.next = big.next;

        return small.next;
    }

    public static void demo() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(2);

        PartitionList obj = new PartitionList();
        ListNode res = obj.partition(head,0);
        while (res!=null){
            System.out.print(res.val+"->");
            res=res.next;
        }
    }
}

package Week1.Day1;

import java.util.HashMap;
import java.util.Map;

//LC 82
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head){
        if(head==null || head.next==null) return  head;
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next!=null){
            if(curr.val!=next.val){
                prev = prev.next;
                curr = curr.next;
                next = next.next;
            }
            else {
                //delete all nodes with that value
                deleteNodes(prev,curr.val);
                curr = prev.next;
                if(curr!=null)
                    next = curr.next;
                else next=null;

            }
        }
        return dummy.next;
    }

    public void deleteNodes(ListNode prev,int val){
        ListNode temp = prev.next;
        while (temp!=null && temp.val==val){
            temp = temp.next;
        }
        prev.next = temp;
    }

        /* using extra space

        public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return null;
        }
        Map<Integer,Integer> map = new HashMap<>();
        ListNode temp = head;
        while (temp!=null){
            if(!map.containsKey(temp.val)){
                map.put(temp.val,1);
            }else{
                map.put(temp.val,map.get(temp.val)+1);
            }
            temp = temp.next;
        }
        temp = head; //122
        while (temp!=null){
            if(temp.val == Integer.MAX_VALUE)
                break;
            if(map.get(temp.val)==1){
                temp=temp.next;//22
            } else {
                if(temp.next!=null) {
                    temp.val = temp.next.val;
                    temp.next = temp.next.next;//2
                } else temp.val = Integer.MAX_VALUE;
            }
        }

        if(head == null)
            return null;

        while(head != null && head.val == Integer.MAX_VALUE)
            head = head.next;

        temp = head;
        while(temp != null && temp.next != null) {
            if(temp.next.val == Integer.MAX_VALUE) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
     */

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(2);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next = new ListNode(5);


        RemoveDuplicates obj = new RemoveDuplicates();
        ListNode a = obj.deleteDuplicates(head);
        while (a!=null){
            System.out.print(a.val+"->");
            a=a.next;
        }
    }
}

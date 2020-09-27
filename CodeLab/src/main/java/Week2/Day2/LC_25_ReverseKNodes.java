package Week2.Day2;

import java.util.ArrayList;
import java.util.List;

public class LC_25_ReverseKNodes {
    public int getLength(ListNode head){
        if(head==null){
            return 0;
        }
        ListNode temp = head;
        int count=1;
        while (temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;
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

    public ListNode reverseKGroup(ListNode head, int k) {
        //split list
        //reverse all parts
        //join
        if(head==null){
            return null;
        }
        int length = getLength(head);
        int parts = length/k;
        List<ListNode> list = new ArrayList<>();
        ListNode temp = head;
        //split list
        while (temp!=null) {
            if (parts > 0) {
                ListNode headNode = temp; //head of each part
                int a = k;
                while (a > 1) {
                    temp = temp.next;
                    a--;
                }
                ListNode next = temp.next;
                temp.next = null;
                list.add(headNode);
                temp = next;
                parts --;
            } else {
                list.add(temp);
                temp=null;
            }
        }
        //System.out.println(list);
        int rem = length%k;
        int last;
        if(rem==0) {
            last = list.size();
        } else {
            last = list.size()-1;
        }
        List<ListNode> resultList = new ArrayList<>();
        for(int i=0;i<last;i++){
            ListNode item = reverseList(list.get(i));
            resultList.add(item);
        }
        ListNode dummyHead = new ListNode();
        ListNode dummy = dummyHead;
        for(int i =0;i<resultList.size();i++){
            ListNode n = resultList.get(i);
            dummy.next = n;
            while (n.next!=null){
                n=n.next;
            }
            dummy = n;
        }
        if(rem>0){
            //add the last element/unchanged part in the list
            ListNode remainder = list.get(list.size()-1);
            dummy.next = remainder;
        }
        return dummyHead.next;
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


        LC_25_ReverseKNodes obj = new LC_25_ReverseKNodes();
        ListNode a = obj.reverseKGroup(head,3);
        while (a!=null){
            System.out.print(a.val+"->");
            a=a.next;
        }
    }
}

package Week2.Day2;

import java.util.Arrays;

public class LC_1019_NextGreaterNode {

    public int[] nextLargerNodes(ListNode head){
        int length = getLength(head);
        int[] result = new int[length];
        if(head==null) return null;
        if(head.next==null){
            result[0]=0;
            return result;
        }
        ListNode curr = head;
        for(int i=0;i<length-1;i++){
            ListNode next = curr.next;
            while (next!=null){
                if(next.val<=curr.val){
                    next = next.next;
                }
                else {
                    result[i]=next.val;
                    break;
                }
            }
            curr=curr.next;
        }

        return result;
    }

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

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(7);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = new ListNode(1);

        LC_1019_NextGreaterNode obj = new LC_1019_NextGreaterNode();
        int[] ans = obj.nextLargerNodes(head);
        System.out.println(Arrays.toString(ans));
    }


}

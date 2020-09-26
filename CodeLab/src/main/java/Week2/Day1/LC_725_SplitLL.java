package Week2.Day1;

// LC 725
public class LC_725_SplitLL {
    public int getLength(ListNode root){
        if(root==null){
            return 0;
        }
        ListNode temp = root;
        int count=1;
        while (temp.next!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }
    public ListNode[] splitListToParts(ListNode root, int k){
        int length = getLength(root);
        int partSize = length/k;
        int rem = length%k;
        if(partSize < 1){
            partSize=1;
        }
        if(k>length){
            rem = 0;
            partSize = 1;
        }
        ListNode[] result = new ListNode[k];

        for(int i=0;i<k;i++) {
            int totalPartSize;
            if(rem>0) {
                totalPartSize = partSize + 1;
            }else {
                totalPartSize = partSize;
            }
            ListNode temp = root;
            int a=0;
            while (temp != null && a < totalPartSize-1) {
                temp = temp.next;
                a++;
            }
            if(temp!=null) {
                ListNode n = temp.next;
                temp.next = null;
                result[i] = root;
                root = n;
            }
            else{
                result[i]=root;
            }
            if(rem>0) {
                rem--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);
//        head.next.next.next.next.next.next = new ListNode(7);

        LC_725_SplitLL obj = new LC_725_SplitLL();
        ListNode[] ans = obj.splitListToParts(head,3);
        for(int i=0;i<ans.length;i++){
            ListNode n = ans[i];
            while (n!=null) {
                System.out.print(n.val+"->");
                n=n.next;
            }
            System.out.println();
        }
    }
}

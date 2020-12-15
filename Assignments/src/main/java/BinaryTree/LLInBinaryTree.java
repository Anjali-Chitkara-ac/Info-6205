package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class LLInBinaryTree {

    Queue<TreeNode> que = new LinkedList<>();

    public boolean isSubPath(ListNode head, TreeNode root) {
         que = check(head,root);
         while (!que.isEmpty()){
             root = que.poll();
             if(areSame(head,root) ){
                 return true;
             }
         }
        return false;
    }

    public boolean areSame(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null && head==null) return true;
        if(root==null || head==null) return false;

        if(head.val==root.val){
            return areSame(head.next,root.left)||
                    areSame(head.next,root.right);
        }
        return false;
    }

    private Queue<TreeNode> check(ListNode head, TreeNode node){
        if(node!=null){
            if(head.val==node.val){
                //System.out.print(node.val + ", ");
                que.add(node);
            }
            check(head,node.left);
            check(head,node.right);
        }
        return que;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(1);
        n1.left = new TreeNode(4);
        n1.right = new TreeNode(4);

        n1.left.right = new TreeNode(2);
        n1.right.left = new TreeNode(2);

        n1.left.right.left = new TreeNode(1);
        n1.right.left.left = new TreeNode(6);
        n1.right.left.right = new TreeNode(8);

        n1.right.left.right.right = new TreeNode(3);
        n1.right.left.right.left = new TreeNode(1);


        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(8);
        //l1.next.next.next = new ListNode(3);

        LLInBinaryTree obj = new LLInBinaryTree();
        System.out.println(obj.isSubPath(l1,n1));
    }

}

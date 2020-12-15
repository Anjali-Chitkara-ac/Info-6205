package Final;

import java.util.ArrayList;
import java.util.List;

public class TwoSumBST {
    /*Q6
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True


Example 2:

Input:
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/
    public boolean findTarget(TreeNode root, int k) {
        //convert to an array/list using inorder traversal
        //check for pairs
        List<Integer> list = new ArrayList<>();
        list = inorderGetList(root,list);
        for(int i=0;i<list.size();i++){
            if(list.contains(k-list.get(i)) && list.get(i)!= k-list.get(i)){
                return true;
            }
        }
        return false;
    }

    private List<Integer> inorderGetList(TreeNode root, List<Integer> list){
        if(root!=null){
            inorderGetList(root.left,list);
            list.add(root.val);
            inorderGetList(root.right,list);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(5);
        n1.left = new TreeNode(3);
        n1.right = new TreeNode(6);
        n1.left.left = new TreeNode(2);
        n1.left.right = new TreeNode(4);
        n1.right.right = new TreeNode(7);

        TwoSumBST obj = new TwoSumBST();
        System.out.println(obj.findTarget(n1,9));
        System.out.println(obj.findTarget(n1,28));

    }

}

package Final;

class TreeNode{

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;

    }
}

public class IsSubTree {
    /*Q5
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
*/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(areEqual(s,t)){
            return true;
        }
        if(s!=null){
            //isSubtree(s,t);
            return isSubtree(s.left,t) ||
                    isSubtree(s.right,t);
        }
        return false;
    }

    private boolean areEqual(TreeNode n1, TreeNode n2){
        if(n1==null && n2==null){
            return true;
        }
        if(n1==null || n2==null){
            return false;
        }
        if(n1.val == n2.val){
            return areEqual(n1.left, n2.left) &&
                    areEqual(n1.right, n2.right);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        n1.left = new TreeNode(4);
        n1.right = new TreeNode(5);
        n1.left.left = new TreeNode(1);
        n1.left.right = new TreeNode(2);
        //n1.left.right.left = new TreeNode(0);

        TreeNode n2 = new TreeNode(4);
        n2.left = new TreeNode(1);
        n2.right = new TreeNode(2);

        IsSubTree obj = new IsSubTree();
        System.out.println(obj.isSubtree(n1,n2));
    }

}

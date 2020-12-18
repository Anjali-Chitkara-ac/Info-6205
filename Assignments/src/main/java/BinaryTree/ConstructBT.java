package BinaryTree;

public class ConstructBT {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //Check the initial conditions
        if(preorder.length == 0 || inorder.length == 0)
            return null;

        if(preorder.length != inorder.length) //return null if these don't match
            return null;

        return buildTreeUtil(preorder, inorder, 0, inorder.length - 1, 0);
    }

    private TreeNode buildTreeUtil(int[] preorder, int[] inorder, int beginning, int end, int currIndex) {
        if(beginning > end)
            return null;

        //If Node is not null, create a new TreeNode with the preorder array and currIndex
        TreeNode curr = new TreeNode(preorder[currIndex]);

        int start = beginning;
        while(inorder[start] != preorder[currIndex])
            start++;

        curr.left = buildTreeUtil(preorder, inorder, beginning, start - 1, currIndex + 1);

        curr.right = buildTreeUtil(preorder, inorder, start + 1, end, currIndex + start - beginning + 1);

        return curr;
    }
}

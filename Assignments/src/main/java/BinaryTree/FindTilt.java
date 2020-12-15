package BinaryTree;

public class FindTilt {

    int result = 0;
    public int findTilt(TreeNode root){
        int totalTilt = 0;
        if(root!=null){
            findTilt(root.left);
            findTilt(root.right);
            totalTilt += getTilt(root);

        }
        result += totalTilt;
        return result;
    }

    private int getTilt(TreeNode node){
        int left = 0;
        int right = 0;
        if(node.left!=null){
            //left = sum of all nodes below it
            sum = 0;
            left = getSum(node.left) ;

        }
        if(node.right!=null){
            sum = 0;
            right = getSum(node.right);
        }
        //System.out.println(left +" " + right);

        return Math.abs(left-right);
    }

    int sum = 0;
    private int getSum(TreeNode node){
        //sum of everything on left & right
        //int sum = 0;
        if(node!=null){
            getSum(node.left);
            getSum(node.right);
            sum+=node.val;
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        n1.left = new TreeNode(2);
        n1.right = new TreeNode(9);
        n1.left.left = new TreeNode(3);
        n1.left.right = new TreeNode(5);
        n1.right.right = new TreeNode(7);

        FindTilt ft = new FindTilt();
        System.out.println(ft.findTilt(n1));
    }
}

import util.TreeNode;

/**
 * Created by Alvin on 16/12/21.
 */

/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
* */
public class Sum_of_Left_Leaves {
    public int sumOfLeftLeaves(TreeNode root) {
        return leftLeaves(root,false);
    }

    private int leftLeaves(TreeNode node, boolean isLeft){
        if(node == null)
            return  0;
        if(node.left == null && node.right == null && isLeft){
            return node.val;
        }
        int sum = 0;
        if(node.left != null){
            sum += leftLeaves(node.left, true);
        }
        if(node.right != null){
            sum += leftLeaves(node.right, false);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = init();
        System.out.println(new Sum_of_Left_Leaves().sumOfLeftLeaves(root));
    }

    private static TreeNode init() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        return root;
    }
}

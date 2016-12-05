import util.TreeNode;

/**
 * Created by Alvin on 16/12/5.
 */
public class Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTree(root.left);
            invertTree(root.right);
        }
        return  root;
    }

}

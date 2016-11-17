import util.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by pengli on 11/17/2016.
 */

/*
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---

You should return [1, 3, 4].
*/
public class Binary_Tree_Right_Side_View {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        preOrder(map,0,root);
        for (int key : map.keySet()){
            values.add(key,map.get(key));
        }
        return values;
    }

    public void preOrder(HashMap<Integer,Integer> map, int level, TreeNode node){
        if(node == null)
            return;
        map.put(level,node.val);
        preOrder(map,level+1,node.left);
        preOrder(map,level+1,node.right);
    }

    public static void main(String[] args) {
        System.out.println(new Binary_Tree_Right_Side_View().rightSideView(init()));
    }

    private static TreeNode init(){
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        return root;

    }
}

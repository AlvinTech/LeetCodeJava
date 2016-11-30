/**
 * Created by Alvin on 16/11/30.
 */
// 利用线段树求解
// http://poj.org/summerschool/1_interval_tree.pdf
public class NumArray {

    class TreeNode{
        int sum;
        TreeNode left;
        TreeNode right;
    }
    private TreeNode root;
    private int lenth;

    private TreeNode buildTree(int i, int j , int[] nums){
        TreeNode node = new TreeNode();
        if(i == j){
            node.sum = nums[i];
            return node;
        }
        int mid =(i + j) / 2;
        node.left = buildTree(i,mid,nums);
        node.right = buildTree(mid+1, j, nums);
        node.sum = node.left.sum + node.right.sum;
        return node;
    }

    public NumArray(int[] nums) {
        if (nums.length ==0)
            return;
        lenth = nums.length-1;
        root = buildTree(0,lenth,nums);
    }


    private void updateTree(TreeNode node ,int i, int j, int index, int val){
        if(i==j && j == index){
            node.sum = val;
            return;
        }
        int mid = (i + j) / 2;
        if(index <= mid){
            updateTree(node.left,i, mid,index,val);
        }else {
            updateTree(node.right,mid+1,j,index,val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    void update(int i, int val) {
        updateTree(root,0,lenth,i,val);
    }

    public int sumRange(int i, int j) {
        return  range(root,0,lenth,i,j);
    }

    private int range(TreeNode node, int x , int y , int i, int j){
        if(x == i && y ==j){
            return node.sum;
        }
        int mid = (x + y) /2;
        if(mid >= j){
            return range(node.left,x, mid, i, j);
        }else if(mid+1 <= i){
            return range(node.right,mid+1,y, i,j );
        }else {
            return range(node.left,x, mid, i,mid) + range(node.right,mid+1,y, mid+1,j);
        }
    }

    public static void main(String[] args) {
        int[] nums = {0,9,5,7,3};
        NumArray numArray = new NumArray(nums);
       // numArray.sumRange(4,4);
      numArray.sumRange(2,4);
//        numArray.sumRange(3,3);
//        numArray.sumRange(4,5);
        numArray.update(1,2);
        numArray.update(1,2);
        numArray.update(1,2);
        System.out.println(numArray.sumRange(0,2));
    }
}

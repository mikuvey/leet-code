/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // return valid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return valid(root, null, null);
    }
    
    public boolean valid(TreeNode root, Integer low, Integer high){
        if(root == null){
            return true;
        }
        
        //Check if root is higher than low and lower than high then update the limits for it's child
        if((low != null && root.val <= low )|| (high != null && root.val >= high)){
            return false;
        }
        
        return valid(root.left, low, root.val) && valid(root.right, root.val, high);
    }
}
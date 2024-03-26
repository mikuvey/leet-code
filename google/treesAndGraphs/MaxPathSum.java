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
    int maxPath = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        int split = maxPathHelper(root);
        maxPath = Math.max(maxPath, split);
        
        return maxPath;
    }
    
    //In a PostOrder traversal, Choose the maximum out of given children
    //Edge: Also consider -ve nodes (eliminate them by comparing each node to 0)
    public int maxPathHelper(TreeNode root){
        if(root == null){
            return 0;
        }
        
        int leftMax = Math.max(maxPathHelper(root.left), 0); 
        int rightMax = Math.max(maxPathHelper(root.right), 0); 
        
        int SplitSum = leftMax + rightMax + root.val;
        //Compare split sum to maxPath
        maxPath = Math.max(SplitSum, maxPath);
        
        return root.val + Math.max(leftMax, rightMax);
    }
}
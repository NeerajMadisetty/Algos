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
    public List<Integer> postorderTraversal(TreeNode root) {
        
        TreeNode curr = root;
        TreeNode  prev = null;
        Stack<TreeNode> s = new Stack<>();
        
        List<Integer> result = new LinkedList<>();
        if(root != null) s.push(root);
        while(s.size() > 0){
           
            curr = s.peek();
            
           if(prev == null || prev.right == curr || prev.left == curr)
           {
               if(curr.left != null) s.push(curr.left);
               else if(curr.right != null) s.push(curr.right);
           }else if(curr.left == prev){
               if(curr.right != null) s.push(curr.right);
           }else{
               s.pop();
               result.add(curr.val);
           }
            prev = curr;
        }
        
        return result;
    }
}
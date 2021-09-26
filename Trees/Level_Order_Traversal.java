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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        if(root == null) return Collections.EMPTY_LIST;
        
        List<List<Integer>> result = new LinkedList<>();
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        result.add(List.of(root.val));
        queue.add(null);
        
        LinkedList<Integer> list = new LinkedList<>();
        
        while(queue.size() > 0){
            TreeNode node = queue.poll();
            
            if(node == null){
                if(list.size() > 0)  {
                    result.add(list);
                    queue.add(null);
                }
                list = new LinkedList<>();
                continue;
            }
            
            if(node.left!=null) 
            {
                list.add(node.left.val);
                queue.add(node.left);
            }
            if(node.right!=null) 
            {
                list.add(node.right.val);
                queue.add(node.right);
            }
        }
        if(list.size() > 0)  result.add(list);
        
        return result;
        
    }
}
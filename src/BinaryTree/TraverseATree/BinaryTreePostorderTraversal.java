package BinaryTree.TraverseATree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> integers = new ArrayList<Integer>();
		if(root == null) {
			return integers;
		}
		traversal(integers, root);
        return integers;
    }
	public void traversal(List<Integer> integers, TreeNode root) {
		if(root.left == null && root.right == null) {
			integers.add(root.val);
			return;
		}
		if(root.left != null) {
			traversal(integers, root.left);
		}
		if(root.right != null) {
			traversal(integers, root.right);
		}
		integers.add(root.val);
	}
	
 
	
}

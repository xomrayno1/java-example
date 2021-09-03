package BinaryTree.TraverseATree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
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
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> level = new ArrayList<List<Integer>>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()) { //loop đầu tiên là loop cái queue cũ  
			Queue<TreeNode> queueChild = new LinkedList<TreeNode>();
			List<Integer> value = new ArrayList<Integer>();
			while(!queue.isEmpty()) { // loop thứ 2 remove queue cũ và tìm child node
				TreeNode treeNode = queue.remove();
				if(treeNode != null) {
					value.add(treeNode.val);
					queueChild.add(treeNode.left);
					queueChild.add(treeNode.right);
				}
			}
			queue = queueChild; // queueChild tìm hết tất cả cái child node của các node queue
			if(!value.isEmpty()) {
				level.add(value);
			}
		}
		
		return level;
	}
	
	
}

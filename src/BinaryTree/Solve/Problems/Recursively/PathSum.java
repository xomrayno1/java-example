package BinaryTree.Solve.Problems.Recursively;

public class PathSum {
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
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if(root == null) return false;
		if(root.left == null  && root.right == null) {
			if(root.val == targetSum) {
				return true;
			}
			return false;
		}
		return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
		
    }
 
	
	public static int GT(int value) {
		if(value == 0) {
			return 1 ;
		}
		int result = value * GT(value-1);
		return result;
	}
	
	public static void main(String[] args) {
		int result = GT(5);
		System.out.println(result);
				
	}
	
	
}

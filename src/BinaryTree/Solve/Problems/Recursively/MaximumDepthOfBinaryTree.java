package BinaryTree.Solve.Problems.Recursively;

public class MaximumDepthOfBinaryTree {
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
    public int maxDepth(TreeNode root) {
    	 return recursive(root, 0);
    }
    public int recursive(TreeNode root, int depth) {
    	if(root == null) return depth;
    	depth++;
    	int left = recursive(root.left, depth);
    	int right = recursive(root.right, depth);
    	if(left > right) {
    		return left;
    	}else {
    		return right;
    	}
    }
}

package BinaryTree.Solve.Problems.Recursively;

public class SymmetricTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right; 
		public TreeNode() {}
		public TreeNode(int val) {
			this.val = val;
		}
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	public static void main(String[] args) {
		TreeNode treeNode1 = new TreeNode(0);
		TreeNode treeNode2 = new TreeNode(0);
		System.out.println(treeNode1 == treeNode2);
	}
    public boolean isSymmetric(TreeNode root) {
        return root == null ||
            isMirror(root.left,root.right);
    }
    
    boolean isMirror(TreeNode root1, TreeNode root2) {
        if(root1 == root2) return true; // null==null yields true
        if(root1 == null || root2 == null) return false;
        
        return root1.val == root2.val &&
            isMirror(root1.left,root2.right) &&
            isMirror(root1.right,root2.left);
    }
}

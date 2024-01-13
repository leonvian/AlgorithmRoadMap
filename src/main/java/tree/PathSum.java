package tree;

public class PathSum {

    public static void main(String[] args) {
        hasPathSum(BinaryTreeFactory.createBinaryTree(new int[] {1 , 2 , 3 , 4, 5, 6, 7}), 22);
    }

    public static  boolean hasPathSum(TreeNode root, int targetSum) {
        return dsf(root, targetSum, 0);
    }

    private static boolean dsf(TreeNode node, int targetSum, int currentSum) {
        if (node == null)
            return false;
        System.out.println(currentSum);

        currentSum += node.val;

        if (currentSum == targetSum && isLeaf(node))
            return true;


        return dsf(node.left, targetSum, currentSum) || dsf(node.right, targetSum, currentSum);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

package tree;

public class PathSum {

    public static void main(String[] args) {
        hasPathSum(BinaryTreeFactory.createBinaryTree(new int[] {1 , 2 , 3 , 4, 5, 6, 7}), 22);
    }

    public static  boolean hasPathSum(TreeNode root, int targetSum) {
        return dst(root, targetSum, 0);
    }

    private static boolean dst(TreeNode node, int targetSum, int currentSum) {
        if (node == null)
            return false;
        System.out.println(currentSum);

        currentSum += node.value;

        if (currentSum == targetSum && isLeaf(node))
            return true;


        return dst(node.left, targetSum, currentSum) || dst(node.right, targetSum, currentSum);
    }

    private static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

}

package tree;

public class HeightOfTree {


    public static void main(String[] args) {
        TreeNode root = BinaryTreeFactory.createBinaryTree(new int[]{1 , 2 , 3 , 4, 5, 6, 7});
        int size = height(root);
        System.out.println("Size " + size);
    }


    private static int height(TreeNode node) {
        if (node == null) return 0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}

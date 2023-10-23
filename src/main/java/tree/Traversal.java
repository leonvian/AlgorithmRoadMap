package tree;

public class Traversal {

    public static void main(String[] args) {
        TreeNode root = BinaryTreeFactory.createBinaryTree(new int[]{1 , 2 , 3 , 4, 5, 6, 7});

        inorder(root);
        System.out.println("");

        preorder(root);
        System.out.println("");

        postOrder(root);
    }

    private static void inorder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);
        System.out.print("");
        System.out.print(node);
        inorder(node.right);
    }

    private static void preorder(TreeNode node) {
        if (node == null)
            return;

        System.out.print("");
        System.out.print(node);
        inorder(node.left);
        inorder(node.right);
    }

    private static void postOrder(TreeNode node) {
        if (node == null)
            return;

        inorder(node.left);
        inorder(node.right);
        System.out.print(node);
        System.out.print("");
    }

}

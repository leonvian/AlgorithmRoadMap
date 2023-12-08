package tree;

public class ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);

        root.left = node2;
        node2.right = node4;
        root.right = node3;

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        System.out.println(sb);
    }

    private static void preorder(TreeNode node, StringBuilder sb) {
        if (node == null) return;

        sb.append(node.value);
        if (node.left != null) {
            sb.append("(");
            preorder(node.left, sb);
            sb.append(")");
        }

        if(node.right != null) {
            sb.append("(");
            preorder(node.right, sb);
            sb.append(")");
        }
    }
}

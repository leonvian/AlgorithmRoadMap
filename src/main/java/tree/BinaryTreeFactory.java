package tree;

import java.util.LinkedList;

public class BinaryTreeFactory {


    public static void main(String[] args) {
        TreeNode treeNode = createBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println(treeNode);
    }


    public static TreeNode createBinaryTree(int[] array) {
        LinkedList<Integer> queueValues = new LinkedList<>();
        for (int value : array) {
            queueValues.add(value);
        }

        TreeNode root = createNode(queueValues);
        if (array.length <= 3) {
            return root;
        }

        LinkedList<TreeNode> queueNodes = new LinkedList<>();
        queueNodes.add(root);

        while (!queueNodes.isEmpty()) {
            TreeNode node = queueNodes.poll();
            node.left = createNode(queueValues);
            node.right = createNode(queueValues);

            if (node.left != null)
                queueNodes.add(node.left);

            if (node.right != null)
                queueNodes.add(node.right);
        }


        return root;
    }

    private static TreeNode createNode(LinkedList<Integer> queue) {
        if (queue.isEmpty()) return null;

        TreeNode treeNode = new TreeNode(queue.poll());

        /*
        if (!queue.isEmpty())
            treeNode.left = new TreeNode(queue.poll());

        if (!queue.isEmpty())
            treeNode.right = new TreeNode(queue.poll());
         */

        return treeNode;
    }


}

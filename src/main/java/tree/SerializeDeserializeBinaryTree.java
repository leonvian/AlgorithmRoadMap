package tree;

import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

    public static final Character SEPARATOR = '*';
    public static final Character NULL = '#';

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);

        TreeNode treeNode1 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(1);
        TreeNode treeNode4 = new TreeNode(6);
        TreeNode treeNode5 = new TreeNode(14);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(13);

        root.left = treeNode1;
        root.right = treeNode2;

        root.right.right = treeNode5;
        root.right.right.left = treeNode8;

        root.left.left = treeNode3;
        root.left.right = treeNode4;

        root.left.right.left = treeNode6;
        root.left.right.right = treeNode7;

        String result = serialize(root);
        TreeNode nodeResult = deserialize(result);

        System.out.println(isEqual(root, nodeResult));
    }

    private static boolean isEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) return true;

        if (root1 == null || root2 == null) return false;

        if (root1.val != root2.val) return false;

        return isEqual(root1.left, root2.left) && isEqual(root1.right, root2.right);
    }

    private static String serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        LinkedList<TreeNodeHolder> queue = new LinkedList<>();
        queue.add(new TreeNodeHolder(root));

        while (!queue.isEmpty()) {
            TreeNodeHolder current = queue.poll();
            if (current.isValid) {
                stringBuilder.append(current.treeNode.val);
                stringBuilder.append(SEPARATOR);
            } else {
                stringBuilder.append(NULL);
                stringBuilder.append(SEPARATOR);
            }


            if (current.isValid) {
                if (current.treeNode.left != null) {
                    queue.add(new TreeNodeHolder(current.treeNode.left));
                } else {
                    queue.add(new TreeNodeHolder(false));
                }
                if (current.treeNode.right != null) {
                    queue.add(new TreeNodeHolder(current.treeNode.right));
                } else {
                    queue.add(new TreeNodeHolder(false));
                }
            }
        }

        return stringBuilder.toString();
    }

    private static TreeNode deserialize(String tree) {
        if (tree.isEmpty()) return null;

        LinkedList<String> queueValues = new LinkedList<>();
        int start = 0;
        for (int end = 0; end < tree.length(); end ++) {
            if (tree.charAt(end) == SEPARATOR) {
                String nodeValue = tree.substring(start, end);
                queueValues.add(nodeValue);
                start = end+1;
            }
        }

        LinkedList<TreeNode> queueNode = new LinkedList<>();
        TreeNode root = createNode(queueValues);
        queueNode.add(root);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            node.left = createNode(queueValues);
            node.right = createNode(queueValues);

            if (node.left != null) {
                queueNode.add(node.left);
            }

            if (node.right != null) {
                queueNode.add(node.right);
            }
        }

        return root;
    }

    private static TreeNode createNode(LinkedList<String> queueValues) {
        if (queueValues.isEmpty())
            return null;
        else {
            String value = queueValues.poll();
            if (value.equals(NULL.toString()))
                return null;
            else
                return new TreeNode(Integer.valueOf(value));
        }
    }

    private static class TreeNodeHolder {

        boolean isValid;
        TreeNode treeNode;

        public TreeNodeHolder(boolean isValid, TreeNode treeNode) {
            this.isValid = isValid;
            this.treeNode = treeNode;
        }

        public TreeNodeHolder(TreeNode treeNode) {
            this(true, treeNode);
        }

        public TreeNodeHolder(Boolean valid) {
            this(valid, null);
        }
    }


}

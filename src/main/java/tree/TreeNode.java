package tree;

public class TreeNode {

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.value = value;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

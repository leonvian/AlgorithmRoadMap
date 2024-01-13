package tree;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.val = value;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int value) {
        this.val = value;
    }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}

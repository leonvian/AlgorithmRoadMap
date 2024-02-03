package tree;

import java.util.HashMap;

/**
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 *
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 */
public class TreePalindromic {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.right = new TreeNode(1);

        System.out.println(pseudoPalindromicPaths(root));
    }

    private static int pseudoPalindromicPaths (TreeNode root) {
        int[] result = new int[1];
        check(root, new HashMap<Integer, Integer>(), result);
        return result[0];
    }

    private static  void check(TreeNode node, HashMap<Integer, Integer> counter, int[] result) {
        add(counter, node.val);

        if (node.left == null && node.right == null) {
            if (isPalindromic(counter)) {
                result[0] = result[0] + 1;
            }
        } else {
            if (node.left != null) {
                check(node.left, counter, result);
            }

            if (node.right != null) {
                check(node.right, counter, result);
            }
        }

        decrease(counter, node.val);
    }

    private static  void add(HashMap<Integer, Integer> counter, int value) {
        int count = 1;
        if (counter.containsKey(value)) {
            count = counter.get(value) +1;
        }
        counter.put(value, count);
    }

    private static void decrease(HashMap<Integer, Integer> counter, int key) {
        if (counter.containsKey(key)) {
            int count = counter.get(key);
            if (count == 1) {
                counter.remove(key);
            } else {
                count --;
                counter.put(key, count);
            }
        }
    }

    private static boolean isPalindromic(HashMap<Integer, Integer> counter) {
        boolean remain = false;
        for (Integer key : counter.keySet()) {
            int count = counter.get(key);
            int mod = count % 2;
            if (mod > 0) {
                if (remain) return false;
                remain = true;
            }
        }

        return true;
    }
}

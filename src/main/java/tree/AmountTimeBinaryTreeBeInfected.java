package tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class AmountTimeBinaryTreeBeInfected {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);

        root.left = two;
        two.left = three;
        three.left = four;
        four.left = five;


        System.out.println(amountOfTime(root, 3));
    }

    private static int amountOfTime(TreeNode root, int start) {

        return findInfected(new Stack<TreeNode>(), root, start);
    }

    private static boolean find(TreeNode node, int start) {
        if (node == null) return false;
        if (node.val == start) return true;

        return find(node.left, start) || find(node.right, start);
    }

    private static int findInfected(Stack<TreeNode> ancestors, TreeNode node, int start) {
        if (node == null) return -1;

        if (node.val == start) {
            HashSet<Integer> infecteds = new HashSet<Integer>();
            return infect(ancestors, node, infecteds);
        }


        //3 - 2
        ancestors.push(node);

        if (node.left == null && node.right == null) {
            ancestors.pop();
            return - 1;
        }

        int leftResult = -1;
        int rightResult = -1;
        if(node.left != null)
          leftResult = findInfected(ancestors, node.left, start);

        if (node.right != null)
         rightResult = findInfected(ancestors, node.right, start);

        if(!ancestors.isEmpty())
        ancestors.pop();

        return Math.max(leftResult, rightResult);
    }

    private static int infect(Stack<TreeNode> ancestors, TreeNode node, HashSet<Integer> infected) {
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(node);
        int count = -1;
        boolean first = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i ++) {
                TreeNode current = queue.poll();
                infected.add(current.val);

                if (current.left != null && !infected.contains(current.left.val)) {
                    queue.add(current.left);
                }

                if (current.right != null && !infected.contains(current.right.val)) {
                    queue.add(current.right);
                }
            }

            if (!ancestors.isEmpty()) {
                queue.add(ancestors.pop());
            }

            count ++;
        }

        return count;
    }


}

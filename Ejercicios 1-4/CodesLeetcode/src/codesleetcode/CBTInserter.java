package codesleetcode;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayDeque;
import java.util.Queue;

/**
 *
 * @author Jose Gabriel Fuentes
 */
public class CBTInserter {

    Queue<TreeNode> queue;
    TreeNode root;

    public CBTInserter(TreeNode root) {
        queue = new ArrayDeque();
        queue.add(root);
        this.root = root;

        boolean lastLevelReached = false;
        while (!lastLevelReached) {
            TreeNode node = queue.peek();

            if (node.left != null) {
                queue.add(node.left);
            } else {
                lastLevelReached = true;
            }
            if (node.right != null) {
                queue.add(node.right);
                queue.remove();
            } else {
                lastLevelReached = true;
            }
        }
    }

    public int insert(int val) {
        TreeNode node = new TreeNode(val);
        if (queue.peek().left != null && queue.peek().right != null) {
            queue.remove();
        }
        TreeNode var = queue.peek();

        if (var.left == null) {
            var.left = node;
        } else {
            var.right = node;
        }

        queue.add(node);
        return var.val;
    }

    public TreeNode get_root() {
        return root;
    }

    @Override
    public String toString() {
        return "root=" + root;
    }

}

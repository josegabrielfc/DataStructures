/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANDRES
 */
public class Main2 {
     public static final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        List<Integer> path = search(original, target);
        TreeNode res = cloned;
        // use the same path to walk through the cloned tree
        for (int i = path.size() - 1; i >= 0; i--) {
            int d = path.get(i);
            if (d == 1) {
                res = res.right;
            } else if (d == -1) {
                res = res.left;
            }
        }
        return res;
    }
    
    // search for the path from root to target, -1 for turn left, 1 for turn right, 0 for no turn,  return null if no valid path
    private static List<Integer> search(TreeNode root, TreeNode t) {
        if (root == null) return null;
        List<Integer> res = new ArrayList<>();
        if (root == t) {
            res.add(0);
            return res;
        } 
        List<Integer> left = search(root.left, t);
        List<Integer> right = search(root.right, t);
        if (left == null && right == null) return null;
        if (left != null) {
            left.add(-1);
            return left;
        } else {
            right.add(1);
            return right;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TreeNode prueba = new TreeNode();
        int v[] = {7, 4, 3,0,0, 6, 19};
        TreeNode root = prueba.make_tree(v);
        System.out.println(root);
        TreeNode cloned = prueba.make_tree(v);
        TreeNode target = root.left; //The node with value 3
        System.out.println(getTargetCopy(root, cloned, target).val);
    }
    
}

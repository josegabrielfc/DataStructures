/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesleetcode;

/**
 *
 * @author Jose Gabriel Fuentes
 */
public class validateBST { //BinarySearchTree

    private Integer previous = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (previous != null && previous >= root.val) {
            return false;
        }
        previous = root.val;
        return isValidBST(root.right);
    }
}

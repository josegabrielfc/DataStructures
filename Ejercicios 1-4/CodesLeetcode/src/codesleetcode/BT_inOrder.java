/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codesleetcode;

import java.util.*;

/**
 *
 * @author Jose Gabriel Fuentes
 */
public class BT_inOrder {  // BinaryTree

    List<Integer> list = new ArrayList();

    public List<Integer> inorderTraversal(TreeNode root) {

        if (root == null) {
            return new ArrayList();
        }

        this.inorderTraversal(root.left);
        list.add(root.val);
        this.inorderTraversal(root.right);

        return list;
    }
}

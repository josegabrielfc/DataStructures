/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.Stack;

/**
 *
 * @author ANDRES
 */
public class TreeNode {
   
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }

    public TreeNode() {
    }

    @Override
    public String toString() {
        return "TreeNode{" + "val=" + val + ", left=" + left + ", right=" + right + '}';
    }
//   public void insert(TreeNode root, int val){
//   Stack<TreeNode> q = new Stack<TreeNode>();
//   q.push(root);
//   int i = 0;
//   while(!q.isEmpty()){
//      TreeNode temp = q.get(i);
//      q.pop();
//      if(temp.left != null){
//         if(val != 0)
//         temp.left = new TreeNode(val);
//      else
//         temp.left = new TreeNode(0);
//      return;
//      } else {
//         q.push(temp.left);
//      }
//      if(temp.right != null){
//         if(val != 0)
//            temp.right = new TreeNode(val);
//         else
//            temp.right = new TreeNode(0);
//         return;
//      } else {
//         q.push(temp.right);
//      }
//      i++;
//   }
//}
   
   public void insert1(TreeNode root, int key)
    {
        // Create a new Node containing
        // the new element
        TreeNode newnode = new TreeNode(key);
 
        // Pointer to start traversing from root and
        // traverses downward path to search
        // where the new node to be inserted
        TreeNode x = root;
 
        // Pointer y maintains the trailing
        // pointer of x
        TreeNode y = null;
 
        while (x != null) {
            y = x;
            if (key < x.val)
                x = x.left;
            else
                x = x.right;
        }
 
        // If the root is null i.e the tree is empty
        // The new node is the root node
        if (y == null)
            y = newnode;
 
        // If the new key is less than the leaf node key
        // Assign the new node to be its left child
        else if (key < y.val)
            y.left = newnode;
 
        // else assign the new node its right child
        else
            y.right = newnode;
 
        // Returns the pointer where the
        // new node is inserted
        //return y;
    }
   
   public static TreeNode insert(TreeNode root, int key)
    {
        // if the root is null, create a new node and return it
        if (root == null) {
            return new TreeNode(key);
        }
 
        // if the given key is less than the root node,
        // recur for the left subtree
        if (key < root.val) {
            root.left = insert(root.left, key);
        }
 
        // otherwise, recur for the right subtree
        else {
            // key >= root.data
            root.right = insert(root.right, key);
        }
 
        return root;
    }
   
   public void add(Integer value) {
    if (value < this.val) {
        if (left != null) {
            left.add(value);
        } else {
            left = new TreeNode(value);
        }
    } else {
        if (right != null) {
            right.add(value);
        } else {
            right = new TreeNode(value);
        }
    }
}

   
   public TreeNode make_tree(int v[]){
   TreeNode root = new TreeNode(v[0]);
   for(int i = 1; i<v.length; i++){
      insert(root,v[i]);
   }
   return root;
}}


package com.example.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNode {

    public int val;

    public String name;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public boolean evaluateTree(TreeNode root) {
        return iterateIt(root);
    }

    public boolean iterateIt(TreeNode root) {
        Deque<TreeNode> s = new ArrayDeque<>();

        if (root == null)
            return false;
        if (root.left == null) {
            return root.val == 0 ? false : true;
        }

        s.push(root);
        while (!s.isEmpty()) {
            root = s.peek();
            if (root.left != null) {
                s.push(root.left);
            } else {
                TreeNode n = s.pop(); // itself
                TreeNode r = s.pop(); // pop the root
                TreeNode right = r.right;
                boolean theval = evaluateSingle(r.val, n.val == 1, right.val == 1);

                if (s.isEmpty()) {
                    return theval;
                } else {
                    n.val = theval ? 1 : 0;
                    s.push(n);
                    TreeNode rightnode = s.peek().right;
                    if (rightnode != null)
                        s.push(rightnode);
                }
            }
        }
        return false;
    }

    boolean evaluateSingle(int rootval, boolean l, boolean r) {
        if (rootval == 2) {
            // OR
            return l || r;
        } else {
            // AND
            return l && r;
        }
    }

    /**
     * just use recursion
     *
     * @param root
     * @return
     */
    boolean evaluateIt(TreeNode root) {
        boolean l = evaluateIt(root.left);
        boolean r = evaluateIt(root.right);
        if (root.left == null) {
            return root.val == 0 ? false : true;
        }
        return evaluateSingle(root.val, l, r);
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

}

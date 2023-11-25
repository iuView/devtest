package com.example.demo;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class TreeNodeTest {

    private static TreeNode root;
    private static TreeNode zeroroot;

    private static TreeNode complexRoot;

    @BeforeAll
    public static void init() {
        root = new TreeNode(2);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        zeroroot = new TreeNode(0);

        complexRoot = new TreeNode(3); // and
        root.left = new TreeNode(2); // or
        root.right = new TreeNode(3); // and

        root.left.left = new TreeNode(2); // or
        root.left.right = new TreeNode(3); // and
        // left branch children
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        root.left.left.left = l1;
        root.left.left.right = r1;
        l1.left = new TreeNode(0);
        l1.right = new TreeNode(1);
        r1.left = new TreeNode(1);
        r1.right = new TreeNode(1);

        root.left.right.left = new TreeNode(0);
        root.left.right.right = new TreeNode(1);

        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        // right branch children
        root.right.left.left = new TreeNode(0);
        root.right.left.right = new TreeNode(1);

        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);

    }

    @Test
    void iterateIt() {
        TreeNode testNode = root;
        boolean val = testNode.iterateIt(root);
        assertTrue(val);
    }

    @Test
    void testZeroRoot() {
        boolean val = zeroroot.iterateIt(zeroroot);
        assertFalse(val);
    }

    @Test
    void testComplexRoot() {
        boolean val = complexRoot.iterateIt(complexRoot);
        assertTrue(val);
    }

    @Test
    void readTreeNode() {
        String filename = "tree.ser";
        File file = new File(filename);
        if (file.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                TreeNode treeNode1 = (TreeNode) ois.readObject();
                System.out.println(treeNode1.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    void saveTreeNode() {
        TreeNode treeNode = new TreeNode(3);
        String filename = "tree.ser";
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(treeNode);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Verify that the file was created
        File file = new File(filename);
        assertTrue(file.exists());

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            TreeNode treeNode1 = (TreeNode) ois.readObject();
            System.out.println(treeNode1.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
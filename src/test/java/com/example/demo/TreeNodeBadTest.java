package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.data.jpa.domain.AbstractAuditable_;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeBadTest {

    @Test
    void readTreeNode() {

        String filename = "tree.ser";
        File file = new File(filename);
        if (file.exists()) {
            assertThrows(InvalidClassException.class, () -> {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
                    TreeNodeBad treeNode1 = (TreeNodeBad) ois.readObject();
                    System.out.println(treeNode1.toString());
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            });
        }
    }

    @Test
    void saveTreeNode() {
        TreeNodeBad treeNode = new TreeNodeBad(3);
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
            TreeNodeBad treeNode1 = (TreeNodeBad) ois.readObject();
            System.out.println(treeNode1.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
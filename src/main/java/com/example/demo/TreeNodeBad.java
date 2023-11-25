package com.example.demo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Deque;

public class TreeNodeBad implements Serializable {
    // this guy doesnt have the serialVersionUID, so all is bad
    int val;

    TreeNodeBad left;
    TreeNodeBad right;

    TreeNodeBad() {
    }

    TreeNodeBad(int val) {
        this.val = val;
    }

    TreeNodeBad(int val, TreeNodeBad left, TreeNodeBad right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    @Serial
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        // Deserialize object as usual, ignoring any new fields
        // so long as you have the same version defined, you can read write you like.
        // but the most important is you have to have version field defined. or the
        // random UID will be used, and you always fail, eventhough you have this method here.
        ois.defaultReadObject();
    }
}

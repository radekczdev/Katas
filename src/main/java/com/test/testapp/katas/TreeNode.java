package com.test.testapp.katas;

import java.util.Objects;

public class TreeNode {

    TreeNode left;
    TreeNode right;
    int value;

    TreeNode(int value, TreeNode left, TreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value) {
        this(value, null, null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return value == treeNode.value &&
                Objects.equals(left, treeNode.left) &&
                Objects.equals(right, treeNode.right);
    }

    @Override
    public String toString() {
        if(left == null && right != null) {
            return
                    value + " " +
                    right+ " ";
        } else if(right == null && left != null) {
            return
                    left + " " +
                            value+ " ";
        } else if(right == null && left == null) {
            return value + " ";
        }
        return left + " " +
                value + " " +
                right+ " ";
    }
}
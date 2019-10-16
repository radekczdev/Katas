package com.test.testapp.katas;

public class BinTree {

    static TreeNode arrayToTree(int[] array) {
        System.out.println("Curr array: ");
        if(array.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(array[0]);
        System.out.print(array[0] + " ");
        for (int i = 1; i < array.length; i++) {
            System.out.print(array[i] + " ");
            root = addRecursively(root, array[i], array[i-1]);
        }
        System.out.println("END");
        return root;
    }

    static TreeNode addRecursively(TreeNode node, int value, int prevVal) {

        if (node == null) {
            return new TreeNode(value);
        }

        if(node.left == null || (node.right != null && (node.left.left == null || node.left.right == null))) {
            node.left = addRecursively(node.left, value, prevVal);
        } else if(node.right == null || (node.left != null && (node.right.left == null || node.right.right == null))) {
            node.right = addRecursively(node.right, value, prevVal);
        }
        return node;
    }
}

package com.test.testapp.katas;

public class BinTree {

    public static int[] values;

    static TreeNode arrayToTree(int[] array) {
        values = array;
        return add(0);
    }

    static TreeNode add(int i) {
        try {
            return new TreeNode(values[i], add(2*i + 1), add(2*i + 2));
        } catch (Exception e) {
            return null;
        }
    }
}

package com.test.testapp.katas;

import sun.reflect.generics.tree.Tree;

<<<<<<< HEAD
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
=======
public class BinTree {
    public static int[] values;
    public static String lastPath = "right";
    static TreeNode arrayToTree(int[] array) {
        if(array.length == 0) {
            return null;
        }
        values = array;
        int i = 0;
        TreeNode root = new TreeNode(values[0]);
        root = add(root, i);
//        if(array.length == 0) {
//            return null;
//        }
//        if(array.length == 1) {
//            return new TreeNode(array[0]);
//        }
//        TreeNode root = new TreeNode(array[0]);
//        for(int i=0; i < array.length; i++) {
//            if(i > array.length-2*i) {
//                root = addToNode(array[i], null, null, root);
//            } else if(i > array.length-2*i+1) {
//                root = addToNode(array[i], new TreeNode(array[2*i+1]), null, root);
//            } else {
//                root = addToNode(array[i], new TreeNode(array[2*i+1]), new TreeNode(array[2*i+2]), root);
//            }
//        }
        return root;
    }

    static TreeNode add(TreeNode node, int i) {
        if(values.length < i) {
            return null;
        }
//        if(i > values.length - 2*i) {
//            node = new TreeNode(values[i], add(node, 2*i + 1), add(node, 2*i + 2));
//        } else if (i > values.length - 2*i + 1) {
//            node = new TreeNode(values[i], add(node, 2*i + 1), add(node, 2*i + 2));
//        } else {
            node = new TreeNode(values[i], add(node, 2*i + 1), add(node, 2*i + 2));
//        }

        return node;
>>>>>>> 1c69bdadbd5b4d8ea1ab1245f019db8d38da126b
    }

//    static TreeNode addToNode(int value, TreeNode left, TreeNode right, TreeNode node) {
//        boolean used = false;
//        if(node == null) {
//            return new TreeNode(value);
//        }
//        if(node.left == null) {
//            node.left = left;
//        }
//        else if(node.right.toString().contains(" "+value+" ")){
//            node.left = addToNode(value, left, right, node.left);
//            used = true;
////            lastPath = "left";
//        }
//        if(node.right == null) {
//            node.right = right;
//        } else if(!used) {
//            node.right = addToNode(value, left, right, node.right);
////            lastPath = "right";
//        }
//        return node;
//    }
}

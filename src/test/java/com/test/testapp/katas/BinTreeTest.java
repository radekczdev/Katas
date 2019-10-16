package com.test.testapp.katas;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class BinTreeTest {

    @Test
    public void emptyArray() {
        TreeNode expected = null;
        assertThat(BinTree.arrayToTree(arrayFrom()), is(expected));
    }

    @Test
    public void arrayWithMultipleElements() {
        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
        assertThat(BinTree.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
        TreeNode expected2 = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
        assertThat(BinTree.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected2));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }
}
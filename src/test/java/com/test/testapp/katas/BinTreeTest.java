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
//        TreeNode expected = new TreeNode(17, new TreeNode(0, new TreeNode(3), new TreeNode(15)), new TreeNode(-4));
//        assertThat(BinTree.arrayToTree(arrayFrom(17, 0, -4, 3, 15)), is(expected));
        TreeNode expected2 = new TreeNode(731,
                new TreeNode(-306,
                        new TreeNode(415,
                                new TreeNode(-309),
                                new TreeNode(-368)),
                        new TreeNode(146,
                                new TreeNode(955),
                                new TreeNode(-380))),
                new TreeNode(-490,
                        new TreeNode(-150,
                                new TreeNode(-785),
                                new TreeNode(945)),
                        new TreeNode(-846))
        );
        assertThat(BinTree.arrayToTree(arrayFrom(731, -306, -490, 415, 146, -150, -846, -309, -368, 955, -380, -785, 945)), is(expected2));
    }

    private int[] arrayFrom(int... values) {
        return values;
    }
}
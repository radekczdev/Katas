package com.test.testapp.katas;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.*;
import java.util.stream.*;


public class PermutationsTest {

    @Test public void example1() {
        assertEquals( new ArrayList<>(Arrays.asList("a")),
                Permutations.singlePermutations("a").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example2() {
        assertEquals( new ArrayList<>(Arrays.asList("ab","ba")),
                Permutations.singlePermutations("ab").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example3() {
        assertEquals( new ArrayList<>(Arrays.asList("aabb", "abab", "abba", "baab", "baba", "bbaa")),
                Permutations.singlePermutations("aabb").stream().sorted().collect(Collectors.toList()) );
    }

    @Test public void example4() {
        assertEquals( new ArrayList<>(Arrays.asList("flnn", "fnln", "fnnl", "lfnn", "lnfn", "lnnf", "nfln", "nfnl", "nlfn", "nlnf", "nnfl", "nnlf")),
                Permutations.singlePermutations("flnn").stream().sorted().collect(Collectors.toList()) );
    }

}
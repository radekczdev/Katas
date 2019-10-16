package com.test.testapp.katas;

import java.util.Arrays;

public class FoldArray
{
    public static int[] foldArray(int[] array, int runs) {
//        for(int run = 0; run < runs; run++) {
         while(runs-- > 0) {
            for(int i = 0; i < array.length/2; i++) {
                array[i] += array[array.length - i - 1];
                array[array.length - i - 1] = 0;
            }
            array = Arrays.copyOf(array, (array.length % 2 ==0) ? array.length/2 : array.length/2 + 1);
        }
        return array;
    }
}
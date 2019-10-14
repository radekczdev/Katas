package com.test.testapp.katas;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SudokuValidator {
    public static boolean check(int[][] sudoku) {
        for(int i = 0; i < 9; i++) {
            Set<Integer> row = IntStream.of(sudoku[i]).boxed().collect(Collectors.toSet());
            if(row.size() < 9 || row.stream().anyMatch(a -> a < 1)) {
                return false;
            }
        }
        int k = 3;
        int n = 0;
        while(k < 9) {
            Set<Integer> box = new HashSet<>();
            for (int i = n; i < k; i++) {
                for (int j = n; j < k; j++) {
                    box.add(sudoku[i][j]);
                }
            }
            if(box.size() < 9) {
                return false;
            }
            n += 3;
            k += 3;
        }
        return true;
    }
}
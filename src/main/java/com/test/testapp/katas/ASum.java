package com.test.testapp.katas;

import java.util.List;
import java.util.ArrayList;

public class ASum {

    private static List<Long> sumsOfN = new ArrayList<>();

    public static long findNb(long m) {
        for(int n = 0; n < m ;n++) {
            long sum = 0;
            for(int i = 0; i < n; i++) {
                if(sumsOfN.size() > n-1) {
                    sum = sumsOfN.get(n-1);
                } else {
                    int ni = n - i;
                    long ni3 = (long) ni * ni * ni;
                    sum += ni3;
                }
                if(sum > m) {
                    return -1;
                } else if(sum == m) {
                    return n;
                }
            }
            if(sumsOfN.size() < n) {
                sumsOfN.add(sum);
            }
        }
        return -1;
    }

    public static long findNb2(long m) {
            long mm = 0, n = 0;
            while (mm < m) mm += ++n * n * n;
            return mm == m ? n : -1;
        }

}
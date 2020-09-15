package com.test.testapp.katas;

import com.test.testapp.katas.ASum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ASumTest {

    @Test
    void findNb() {
        ASum aSum = new ASum();
        assertEquals(3, ASum.findNb(36));
        assertEquals(4, ASum.findNb(100));
        assertEquals(5, ASum.findNb(225));
        assertEquals(4824, ASum.findNb(135440716410000L));
        assertEquals(55100, ASum.findNb(2304422822859502500L));
        assertEquals(55100, ASum.findNb(2304422822859502500L));
    }

    @Test
    void findNb2() {
        ASum aSum = new ASum();
        assertEquals(3, ASum.findNb2(36));
        assertEquals(4, ASum.findNb2(100));
        assertEquals(5, ASum.findNb2(225));
        assertEquals(4824, ASum.findNb2(135440716410000L));
        assertEquals(55100, ASum.findNb2(2304422822859502500L));
        assertEquals(55100, ASum.findNb2(2304422822859502500L));
    }
}
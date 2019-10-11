package com.test.testapp.katas;

import com.test.testapp.katas.ASum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ASumTest {

    @Test
    void findNb() {
        ASum aSum = new ASum();
        assertEquals(3, aSum.findNb(36));
        assertEquals(4, aSum.findNb(100));
        assertEquals(5, aSum.findNb(225));
        assertEquals(4824, aSum.findNb(135440716410000L));
        assertEquals(55100,aSum.findNb(2304422822859502500L));
        assertEquals(55100,aSum.findNb(2304422822859502500L));
    }

    @Test
    void findNb2() {
        ASum aSum = new ASum();
        assertEquals(3, aSum.findNb2(36));
        assertEquals(4, aSum.findNb2(100));
        assertEquals(5, aSum.findNb2(225));
        assertEquals(4824, aSum.findNb2(135440716410000L));
        assertEquals(55100,aSum.findNb2(2304422822859502500L));
        assertEquals(55100,aSum.findNb2(2304422822859502500L));
    }
}
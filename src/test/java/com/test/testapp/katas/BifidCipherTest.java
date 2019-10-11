package com.test.testapp.katas;

import com.test.testapp.katas.BifidCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BifidCipherTest {

    @Test
    void encodeBifid() {
        BifidCipher testCipher = new BifidCipher();
        assertEquals("CWUAS", testCipher.encodeBifid("","ELVIS"));
        assertEquals("", testCipher.encodeBifid("KEY",""));
        assertEquals("ORGFOSR", testCipher.encodeBifid("CODEWARS","WARRIOR"));
        assertEquals("EKUCERRRIS", testCipher.encodeBifid("ELVIS","JIMMY JAMES"));
        assertEquals("RCPGSSBBBDTELGTHLGHG", testCipher.encodeBifid("BIFID","THE INVENTOR OF BIFID IS"));
    }

    @Test
    void decodeBifid() {
        BifidCipher testCipher = new BifidCipher();
        assertEquals("ELVIS", testCipher.decodeBifid("","CWUAS"));
        assertEquals("", testCipher.decodeBifid("",""));
        assertEquals("MEMPHIS", testCipher.decodeBifid("ELVIS","GMGIIBT"));
        assertEquals("FELIXDELASTELLE", testCipher.decodeBifid("INVENTOR","DLXEBIQNLVEVZLE"));
    }
}
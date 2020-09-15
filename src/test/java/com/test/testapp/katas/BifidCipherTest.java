package com.test.testapp.katas;

import com.test.testapp.katas.BifidCipher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BifidCipherTest {

    @Test
    void encodeBifid() {
        BifidCipher testCipher = new BifidCipher();
        assertEquals("CWUAS", BifidCipher.encodeBifid("","ELVIS"));
        assertEquals("", BifidCipher.encodeBifid("KEY",""));
        assertEquals("ORGFOSR", BifidCipher.encodeBifid("CODEWARS","WARRIOR"));
        assertEquals("EKUCERRRIS", BifidCipher.encodeBifid("ELVIS","JIMMY JAMES"));
        assertEquals("RCPGSSBBBDTELGTHLGHG", BifidCipher.encodeBifid("BIFID","THE INVENTOR OF BIFID IS"));
    }

    @Test
    void decodeBifid() {
        BifidCipher testCipher = new BifidCipher();
        assertEquals("ELVIS", BifidCipher.decodeBifid("","CWUAS"));
        assertEquals("", BifidCipher.decodeBifid("",""));
        assertEquals("MEMPHIS", BifidCipher.decodeBifid("ELVIS","GMGIIBT"));
        assertEquals("FELIXDELASTELLE", BifidCipher.decodeBifid("INVENTOR","DLXEBIQNLVEVZLE"));
    }
}
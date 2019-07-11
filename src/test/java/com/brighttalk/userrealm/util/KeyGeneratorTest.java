package com.brighttalk.userrealm.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class KeyGeneratorTest {

    @Test
    public void generateKeyShoudReturnKeyWithLength32() {
        assertEquals(32, KeyGenerator.generateKey().length());
    }
}
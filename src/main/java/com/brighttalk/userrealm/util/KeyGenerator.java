package com.brighttalk.userrealm.util;

import java.util.UUID;

public class KeyGenerator {
    private KeyGenerator() {
        throw new IllegalStateException("Utility class");
    }

    public static String generateKey() {
        return UUID.randomUUID().toString().substring(0, 32);
    }
}

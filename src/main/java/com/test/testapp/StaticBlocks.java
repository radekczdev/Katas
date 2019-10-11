package com.test.testapp;

class StaticBlocks {
    private static final int NUMBER;

    static {
        NUMBER = 4;
    }

    StaticBlocks()  {
    }

    int getNumber() {
        return NUMBER;
    }
}

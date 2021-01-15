package com.test.testapp.concurrency.inheritingstatic;

abstract class AbstractClass {
    private final int a;
    private final int b;
    private int c;
    AbstractClass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void provideC(int c) {
        this.c = c;
    }
}

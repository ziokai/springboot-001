package com.zou.jdkproxy;

public abstract class JdkTest {
    public static void main(String[] args) {
        Person instance = (Person)new JdkMeipoProxy().getInstance(new Customer());
        instance.findLove();
    }
}

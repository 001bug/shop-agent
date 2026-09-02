package com.ohmygod.shopagent.util;

@FunctionalInterface
public interface TaskCall<V> {

    V call();
}


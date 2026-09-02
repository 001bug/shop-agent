package com.ohmygod.shopagent.core;

public interface ConsumerTask {

    void execute(String content);

    String topic();
}


package com.ohmygod.shopagent.uid.worker;

import com.ohmygod.shopagent.uid.utils.ValuedEnum;


public enum WorkerNodeType implements ValuedEnum<Integer> {

    CONTAINER(1), ACTUAL(2);

    private final Integer type;

    private WorkerNodeType(Integer type) {
        this.type = type;
    }

    @Override
    public Integer value() {
        return type;
    }

}

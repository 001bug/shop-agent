package com.ohmygod.shopagent.lockinfo.impl;

import com.ohmygod.shopagent.lockinfo.AbstractLockInfoHandle;

public class RepeatExecuteLimitLockInfoHandle extends AbstractLockInfoHandle {

    public static final String PREFIX_NAME = "REPEAT_EXECUTE_LIMIT";

    @Override
    protected String getLockPrefixName() {
        return PREFIX_NAME;
    }
}


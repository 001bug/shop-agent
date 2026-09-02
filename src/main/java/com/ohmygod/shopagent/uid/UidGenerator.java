package com.ohmygod.shopagent.uid;

import com.ohmygod.shopagent.uid.exception.UidGenerateException;


public interface UidGenerator {

    long getUid() throws UidGenerateException;

    long getId();

    long getOrderNumber(long userId,long tableCount,long databaseCount);

    long getOrderNumber(long userId);

    @Deprecated
    long getOrderNumber(long userId,long tableCount);

    String parseUid(long uid);

}


package com.ohmygod.shopagent.core;

import com.ohmygod.shopagent.servicelock.LockType;
import com.ohmygod.shopagent.servicelock.ServiceLocker;
import com.ohmygod.shopagent.servicelock.impl.RedissonFairLocker;
import com.ohmygod.shopagent.servicelock.impl.RedissonReadLocker;
import com.ohmygod.shopagent.servicelock.impl.RedissonReentrantLocker;
import com.ohmygod.shopagent.servicelock.impl.RedissonWriteLocker;
import org.redisson.api.RedissonClient;

import java.util.HashMap;
import java.util.Map;

import static com.ohmygod.shopagent.servicelock.LockType.Fair;
import static com.ohmygod.shopagent.servicelock.LockType.Read;
import static com.ohmygod.shopagent.servicelock.LockType.Reentrant;
import static com.ohmygod.shopagent.servicelock.LockType.Write;

public class ManageLocker {

    private final Map<LockType, ServiceLocker> cacheLocker = new HashMap<>();

    public ManageLocker(RedissonClient redissonClient){
        cacheLocker.put(Reentrant,new RedissonReentrantLocker(redissonClient));
        cacheLocker.put(Fair,new RedissonFairLocker(redissonClient));
        cacheLocker.put(Write,new RedissonWriteLocker(redissonClient));
        cacheLocker.put(Read,new RedissonReadLocker(redissonClient));
    }

    public ServiceLocker getReentrantLocker(){
        return cacheLocker.get(Reentrant);
    }

    public ServiceLocker getFairLocker(){
        return cacheLocker.get(Fair);
    }

    public ServiceLocker getWriteLocker(){
        return cacheLocker.get(Write);
    }

    public ServiceLocker getReadLocker(){
        return cacheLocker.get(Read);
    }
}


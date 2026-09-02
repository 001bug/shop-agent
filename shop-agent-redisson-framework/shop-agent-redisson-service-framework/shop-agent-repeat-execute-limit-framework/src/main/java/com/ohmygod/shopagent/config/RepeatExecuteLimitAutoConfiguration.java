package com.ohmygod.shopagent.config;

/**
import com.ohmygod.shopagent.constant.LockInfoType;
import com.ohmygod.shopagent.handle.RedissonDataHandle;
import com.ohmygod.shopagent.locallock.LocalLockCache;
import com.ohmygod.shopagent.lockinfo.LockInfoHandle;
import com.ohmygod.shopagent.lockinfo.factory.LockInfoHandleFactory;
import com.ohmygod.shopagent.lockinfo.impl.RepeatExecuteLimitLockInfoHandle;
import com.ohmygod.shopagent.repeatexecutelimit.aspect.RepeatExecuteLimitAspect;
import com.ohmygod.shopagent.servicelock.factory.ServiceLockFactory;
import org.springframework.context.annotation.Bean;

public class RepeatExecuteLimitAutoConfiguration {

    @Bean(LockInfoType.REPEAT_EXECUTE_LIMIT)
    public LockInfoHandle repeatExecuteLimitHandle(){
        return new RepeatExecuteLimitLockInfoHandle();
    }

    @Bean
    public RepeatExecuteLimitAspect repeatExecuteLimitAspect(LocalLockCache localLockCache,
                                                             LockInfoHandleFactory lockInfoHandleFactory,
                                                             ServiceLockFactory serviceLockFactory,
                                                             RedissonDataHandle redissonDataHandle){
        return new RepeatExecuteLimitAspect(localLockCache, lockInfoHandleFactory,serviceLockFactory,redissonDataHandle);
    }
}
**/


package com.ohmygod.shopagent.config;

import com.ohmygod.shopagent.constant.LockInfoType;
import com.ohmygod.shopagent.core.ManageLocker;
import com.ohmygod.shopagent.lockinfo.LockInfoHandle;
import com.ohmygod.shopagent.lockinfo.factory.LockInfoHandleFactory;
import com.ohmygod.shopagent.lockinfo.impl.ServiceLockInfoHandle;
import com.ohmygod.shopagent.servicelock.aspect.ServiceLockAspect;
import com.ohmygod.shopagent.servicelock.factory.ServiceLockFactory;
import com.ohmygod.shopagent.util.ServiceLockTool;
import org.redisson.api.RedissonClient;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
@ConditionalOnProperty(prefix = "shop.framework.redisson", name = "enabled", havingValue = "true")
public class ServiceLockAutoConfiguration {

    @Bean(LockInfoType.SERVICE_LOCK)
    public LockInfoHandle serviceLockInfoHandle(){
        return new ServiceLockInfoHandle();
    }

    @Bean
    public ManageLocker manageLocker(RedissonClient redissonClient){
        return new ManageLocker(redissonClient);
    }

    @Bean
    public ServiceLockFactory serviceLockFactory(ManageLocker manageLocker){
        return new ServiceLockFactory(manageLocker);
    }

    @Bean
    public ServiceLockAspect serviceLockAspect(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockAspect(lockInfoHandleFactory,serviceLockFactory);
    }

    @Bean
    public ServiceLockTool serviceLockUtil(LockInfoHandleFactory lockInfoHandleFactory,ServiceLockFactory serviceLockFactory){
        return new ServiceLockTool(lockInfoHandleFactory,serviceLockFactory);
    }
}
